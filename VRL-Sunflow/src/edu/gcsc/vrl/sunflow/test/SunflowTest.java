/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;

import org.sunflow.*;
import org.sunflow.core.*;
import org.sunflow.core.camera.*;
import org.sunflow.core.display.FileDisplay;
import org.sunflow.core.primitive.*;
import org.sunflow.core.shader.*;
import org.sunflow.image.Color;
import org.sunflow.math.*;

/**
 *
 * @author ThomasL
 */
public class SunflowTest extends SunflowAPI {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        FileDisplay disp = new FileDisplay(true);

        //SunflowAPI a = SunflowAPI.create("C:\\Test.java", 0);
        //a.render(DEFAULT_OPTIONS, disp);
        
        SunflowTest test = new SunflowTest();
        //test.setup_sponge();
        //test.setup_wireframe_demo();
        //test.setup_aliens_shiny();
        //test.setup_bump_demo();
        //test.setup_bunny_ibl();
        //test.setup_cornell_box_jensen();
        //test.setup_julia();
        //test.setup_sphereflake();
        //test.setup_obj();
        test.render(DEFAULT_OPTIONS, disp);
    }
     
    // Change settings here
    int depth = 5;
    boolean preview = false;

    
    
    public void setup_obj()
    {
        parameter("width", (float) (Math.PI * 0.5 / 8192));
        shader("ao_wire", "custom_wireframe");
        // you can put the path to your own scene here to use this rendering
        // technique just copy this file to the same directory as your main .sc
        // file, and swap the fileanme in the line below
        include("C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\obj.sc");

        // shader override
        parameter("override.shader", "ao_wire");
        parameter("override.photons", true);

        // this may need to be tweaked if you want really fine lines
        // this is higher than most scenes need so if you render with ambocc =
        // false, make sure you turn down the sampling rates of
        // dof/lights/gi/reflections accordingly
        parameter("aa.min", 2);
        parameter("aa.max", 2);
        parameter("filter", "blackman-harris");
        options(DEFAULT_OPTIONS);
    }    
    
    
    
    
    
    
    
    public void setup_sponge() 
    {
        parameter("eye", new Point3(0, 0.2f, 0));
        parameter("target", new Point3(-1.0f, -0.5f, 0.5f));
        parameter("up", new Vector3(0.0f, 1.0f, 0.0f));
        camera("camera_inside", "spherical");

        parameter("maxdist", 0.4f);
        parameter("samples", 16);
        shader("ao_sponge", "ambient_occlusion");

        parameter("maxdist", 0.4f);
        parameter("samples", 128);
        shader("ao_ground", "ambient_occlusion");

        PluginRegistry.primitivePlugins.registerPlugin("menger_sponge", MengerSponge.class);
        parameter("depth", depth);
        geometry("sponge", "menger_sponge");
        // Matrix4 m = null;
        // m = Matrix4.rotateX((float) Math.PI / 3);
        // m = m.multiply(Matrix4.rotateZ((float) Math.PI / 3));
        // parameter("transform", m);
        parameter("shaders", "ao_sponge");
        instance("sponge.instance", "sponge");

        parameter("center", new Point3(0, -1.25f, 0.0f));
        parameter("normal", new Vector3(0.0f, 1.0f, 0.0f));
        geometry("ground", "plane");
        parameter("shaders", "ao_ground");
        instance("ground.instance", "ground");

        // rendering options
        parameter("camera", "camera_inside");
        parameter("resolutionX", 1024);
        parameter("resolutionY", 512);
        if (preview) {
            parameter("aa.min", 0);
            parameter("aa.max", 1);
            parameter("bucket.order", "spiral");
        } else {
            parameter("aa.min", 1);
            parameter("aa.max", 2);
            parameter("bucket.order", "column");
            parameter("filter", "mitchell");
        }
        options(DEFAULT_OPTIONS);
    }
    
    public void setup_wireframe_demo()
    {
        PluginRegistry.shaderPlugins.registerPlugin("custom_wireframe", CustomWireShader.class);

        parameter("width", (float) (Math.PI * 0.5 / 8192));
        shader("ao_wire", "custom_wireframe");
        // you can put the path to your own scene here to use this rendering
        // technique just copy this file to the same directory as your main .sc
        // file, and swap the fileanme in the line below
        include("gumbo_and_teapot.sc");

        // shader override
        parameter("override.shader", "ao_wire");
        parameter("override.photons", true);

        // this may need to be tweaked if you want really fine lines
        // this is higher than most scenes need so if you render with ambocc =
        // false, make sure you turn down the sampling rates of
        // dof/lights/gi/reflections accordingly
        parameter("aa.min", 2);
        parameter("aa.max", 2);
        parameter("filter", "blackman-harris");
        options(DEFAULT_OPTIONS);
    }
    
    public void setup_aliens_shiny()
    {
        include("aliens_shiny.sc");
    }
    
    public void setup_bump_demo()
    {
        include("bump_demo.sc");
    }
    
    public void setup_bunny_ibl()
    {
        include("bunny_ibl.sc");
    }
    
    public void setup_cornell_box_jensen()
    {
        include("cornell_box_jensen.sc");
    }
    
    public void setup_julia()
    {
        include("julia.sc");
    }
    
    public void setup_sphereflake()
    {
        include("sphereflake.sc");
    }
 
}
