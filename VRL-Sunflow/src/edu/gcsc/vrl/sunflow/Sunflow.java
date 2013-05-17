/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.v3d.Shape3DArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Point3f;
import org.sunflow.SunflowAPI;
import org.sunflow.math.Matrix4;
import org.sunflow.math.Point3;
import org.sunflow.math.Vector3;

/**
 *
 * @author ThomasL
 */
public class Sunflow extends javax.swing.JFrame {
    
    public void render(float[] orientation, Shape3DArray shapes)
    {
        final SunflowAPI sun = new SunflowAPI();
        
        // ---------------------------------------------------------------------
        // IMAGE
        
        // image {
        //   resolution 800 600
        //   aa 0 2
        //   samples 4
        //   contrast 0.1
        //   filter gaussian
        //   jitter false
        // }
        
//        sun.parameter("resolutionX", int);
//        sun.parameter("resolutionY", int);        
//        sun.parameter("sampler", String);
//        sun.parameter("aa.min", int);
//        sun.parameter("aa.max", int);        
//        sun.parameter("aa.samples", int);
//        sun.parameter("aa.contrast", float);
//        sun.parameter("filter", String);
//                    box [float] [float] (filter size = 1)
//                    triangle [float] [float] (filter size = 2)
//                    gaussian [float] [float] (filter size = 3)
//                    blackman-harris [float] [float] (filter size = 4)
//                    sinc [float] [float] (filter size = 4) 
//                    mitchell (filter size = 4)
//                    catmull-rom (filter size = 4)
//                    lanczos (filter size = 4)
//                    bspline (in the 0.07.3 SVN) (filter size = 4)
//        sun.parameter("aa.jitter", boolean);
//        sun.parameter("aa.cache", boolean);
//        sun.options(SunflowAPI.DEFAULT_OPTIONS);
        
        
        
        // ---------------------------------------------------------------------
        // BACKGROUND
        
//        sun.parameter("color", null, parseColor().getRGB());
//        sun.shader("background.shader", "constant");
//        sun.geometry("background", "background");
//        sun.parameter("shaders", "background.shader");
//        sun.instance("background.instance", "background");        
        
        
        
        // ---------------------------------------------------------------------
        // CAMERA
        
        //sun.parameter("shutter.open", p.getNextFloat());
        //sun.parameter("shutter.close", p.getNextFloat());        
        sun.parameter("transform", Matrix4.lookAt(
                //new Point3(-18.19f, 8.97f, -0.93f),         // eye 
                //new Point3(0f, 0f, 15),
                new Point3(0f, 0f, 35),
                //new Point3(-0.69f, 0.97f, -0.93f),          // target
                new Point3(0f, 0f, 0f),         
                //new Vector3(0.0f, 1.0f, 0.0f)));            // up
                new Vector3(0.0f, 1.0f, 0.0f)));            
        sun.parameter("fov", 25.0f);
        //sun.parameter("fov", (float)Math.toDegrees(0.7853981633974483));
        System.out.print((float)Math.toDegrees(0.7853981633974483));
        sun.parameter("aspect", 1.777777777777f);
        sun.camera("camera_default", "pinhole");
        
        
/*        
        // ---------------------------------------------------------------------
        // SHADER
        
        
        // DIFFUSE SHADER http://sfwiki.geneome.net/images/c/cf/Diffuse.png
     
        sun.parameter("diffuse", null, parseColor().getRGB());
        sun.shader(name, "diffuse");
        // alternatively textured
        sun.parameter("texture", p.getNextToken());
        sun.shader(name, "textured_diffuse");
        
        
        // PHONG SHADER http://sfwiki.geneome.net/images/c/cf/Diffuse.png
        
        sun.parameter("diffuse", null, parseColor().getRGB());
        // alternatively textured
        sun.parameter("texture", tex = p.getNextToken());
       
        sun.parameter("specular", null, parseColor().getRGB());
        sun.parameter("power", p.getNextFloat());
        sun.parameter("samples", p.getNextInt());
        
        sun.shader(name, "phong");
        // alternatively textured
        sun.shader(name, "textured_phong");
        
        
        // AMBIENT OCCLUSION SHADER http://sfwiki.geneome.net/images/7/72/Ao.png
        // based on geometric proximity - it totally ignores lights
        
        sun.parameter("bright", null, parseColor().getRGB());
        // or textured
        sun.parameter("texture", tex = p.getNextToken());
        
        sun.parameter("dark", null, parseColor().getRGB());
        sun.parameter("samples", p.getNextInt());
        sun.parameter("maxdist", p.getNextFloat());

        sun.shader(name, "ambient_occlusion");
        // or textured
        sun.shader(name, "textured_ambient_occlusion");
        
        
        // MIRROR SHADER http://sfwiki.geneome.net/images/b/b8/Mirror.png
        
        sun.parameter("color", null, parseColor().getRGB());
        sun.shader(name, "mirror");        
        
        
        // GLASS SHADER http://sfwiki.geneome.net/images/1/15/Glass.png
        
        sun.parameter("eta", p.getNextFloat());
        sun.parameter("color", null, parseColor().getRGB());
        sun.parameter("absorption.distance", p.getNextFloat());
        sun.parameter("absorption.color", null, parseColor().getRGB());
        sun.shader(name, "glass");
        
        
        // SHINY SHADER http://sfwiki.geneome.net/images/1/10/Shiny.png
        
        sun.parameter("diffuse", null, parseColor().getRGB());
        // or textured
        sun.parameter("texture", tex = p.getNextToken());
        
        sun.parameter("shiny", p.getNextFloat());   // reflection
        
        sun.shader(name, "shiny_diffuse");
        // or textured
        sun.shader(name, "textured_shiny_diffuse");
        
        
        // WARD SHADER http://sfwiki.geneome.net/images/7/73/Ward.png
        
        sun.parameter("diffuse", null, parseColor().getRGB());
        // or textured
        sun.parameter("texture", tex = p.getNextToken());
        
        sun.parameter("specular", null, parseColor().getRGB());
            sun.parameter("roughnessX", p.getNextFloat());
            sun.parameter("roughnessY", p.getNextFloat());        
        sun.parameter("samples", p.getNextInt());
        
        sun.shader(name, "ward");
        // or textured
        sun.shader(name, "textured_ward");
        
        
        // CONSTANT SHADER http://sfwiki.geneome.net/images/7/76/Constant.png
        
        sun.parameter("color", null, parseColor().getRGB());
        sun.shader(name, "constant");
            
            
        // UBER SHADER
        
        sun.parameter("diffuse", null, parseColor().getRGB());
        sun.parameter("diffuse.texture", p.getNextToken());
        sun.parameter("diffuse.blend", p.getNextFloat());
        sun.parameter("specular", null, parseColor().getRGB());
        sun.parameter("specular.texture", p.getNextToken());
        sun.parameter("specular.blend", p.getNextFloat());
        sun.parameter("glossyness", p.getNextFloat());
        sun.parameter("samples", p.getNextInt());
        sun.shader(name, "uber");        
        
        
        // OTHER SHADERS
        
        sun.shader(name, "view_caustics");
        sun.shader(name, "view_irradiance");
        sun.shader(name, "view_global");

        
        
        // ---------------------------------------------------------------------
        // MODIFIER
        
        sun.parameter("texture", p.getNextToken());
        sun.parameter("scale", p.getNextFloat());
        sun.modifier(name, "bump_map");

        sun.parameter("texture", p.getNextToken());
        sun.modifier(name, "normal_map");

        sun.parameter("function", p.getNextInt());
        sun.parameter("size", p.getNextFloat());
        sun.parameter("scale", p.getNextFloat());
        sun.modifier(name, "perlin");        
        

        
        // ---------------------------------------------------------------------
        // OBJECT
        
        // these are the parameters to be passed to the instance
        sun.parameter("accel", p.getNextToken());
            
        // mesh
        sun.parameter("triangles", triangles);
        sun.parameter("points", "point", "vertex", points);
        sun.parameter("normals", "vector", "vertex", normals);
        sun.parameter("uvs", "texcoord", "vertex", uvs);
        sun.geometry(name, "triangle_mesh");    
        
        // flat-mesh
        sun.parameter("triangles", triangles);
        sun.parameter("points", "point", "vertex", points);
        sun.parameter("uvs", "texcoord", "vertex", uvs);
        sun.geometry(name, "triangle_mesh");            
            
        // sphere
        sun.parameter("transform", Matrix4.translation(x, y, z).multiply(Matrix4.scale(radius)));
        sun.parameter("shaders", shaders);
        sun.parameter("modifiers", modifiers);
        sun.instance(name + ".instance", name);
            
        // cylinder
        sun.geometry(name, "cylinder");           
            
        // banchoff
        sun.geometry(name, "banchoff");            
            
        // torus
        sun.parameter("radiusInner", p.getNextFloat());
        sun.parameter("radiusOuter", p.getNextFloat());
        sun.geometry(name, "torus");            
            
        // sphereflake
        sun.parameter("level", p.getNextInt());
        sun.parameter("axis", parseVector());
        sun.parameter("radius", p.getNextFloat());
        sun.geometry(name, "sphereflake");            
            
        // plane
        sun.parameter("center", parsePoint());
        sun.parameter("normal", parseVector());
        // or
        sun.parameter("point1", parsePoint());
        sun.parameter("point2", parsePoint());
        sun.geometry(name, "plane");
            
        // generic-mesh
        sun.parameter("points", "point", "vertex", parseFloatArray(np * 3));
        sun.parameter("triangles", parseIntArray(nt * 3));    
        sun.parameter("normals", "vector", "vertex", parseFloatArray(np * 3));    
        sun.parameter("normals", "vector", "facevarying", parseFloatArray(nt * 9));
        sun.parameter("uvs", "texcoord", "vertex", parseFloatArray(np * 2));
        sun.parameter("uvs", "texcoord", "facevarying", parseFloatArray(nt * 6));
        sun.parameter("faceshaders", parseIntArray(nt));
        sun.geometry(name, "triangle_mesh");
        
        // hair
        sun.parameter("segments", p.getNextInt());
        sun.parameter("widths", p.getNextFloat());
        sun.parameter("points", "point", "vertex", parseFloatArray(p.getNextInt()));
        sun.geometry(name, "hair");
        
        // file-mesh
        sun.parameter("filename", p.getNextToken());
        sun.parameter("smooth_normals", p.getNextBoolean());
        sun.geometry(name, "file_mesh");
        
            
        // create instance
        sun.parameter("shaders", shaders);
        sun.parameter("modifiers", modifiers);
        sun.parameter("transform", transform[0]);
        sun.instance(name + ".instance", name);
        

        
        // ---------------------------------------------------------------------
        // LIGHT       
        
        // mesh
        sun.parameter("radiance", null, parseColor().getRGB());
        sun.parameter("samples", samples);
        sun.parameter("points", "point", "vertex", points);
        sun.parameter("triangles", triangles);
        sun.light(name, "triangle_mesh");        
        
        // point
        sun.parameter("center", parsePoint());
        sun.parameter("power", null, pow.getRGB());
        sun.light(generateUniqueName("pointlight"), "point");        

        // spherical
        sun.parameter("radiance", null, pow.getRGB());
        sun.parameter("center", parsePoint());
        sun.parameter("radius", p.getNextFloat());
        sun.parameter("samples", p.getNextInt());
        sun.light(generateUniqueName("spherelight"), "sphere");
        
        // directional
        sun.parameter("source", s);
        sun.parameter("dir", Point3.sub(t, s, new Vector3()));
        sun.parameter("radius", p.getNextFloat());
        sun.parameter("radiance", null, e.getRGB());
        sun.light(generateUniqueName("dirlight"), "directional");
        
        // ibl (image based light)
        sun.parameter("texture", p.getNextToken());
        sun.parameter("center", parseVector());
        sun.parameter("up", parseVector());
        sun.parameter("fixed", p.getNextBoolean());
        sun.parameter("samples", samples);
        sun.parameter("lowsamples", p.getNextInt());
        sun.light(generateUniqueName("ibl"), "ibl");
        
        // meshlight
        sun.parameter("radiance", null, e.getRGB());
        sun.parameter("samples", samples);
        sun.parameter("points", "point", "vertex", parseFloatArray(np * 3));
        sun.parameter("triangles", parseIntArray(nt * 3));
        sun.light(name, "triangle_mesh");
        
        // sunsky
        sun.parameter("up", parseVector());
        sun.parameter("east", parseVector());
        sun.parameter("sundir", parseVector());
        sun.parameter("turbidity", p.getNextFloat());
        sun.parameter("samples", p.getNextInt());
        sun.parameter("ground.extendsky", p.getNextBoolean());
        sun.parameter("ground.color", null, parseColor().getRGB());
        sun.light(generateUniqueName("sunsky"), "sunsky");        

        // cornellbox
        sun.parameter("corner0", parsePoint());
        sun.parameter("corner1", parsePoint());
        sun.parameter("leftColor", null, parseColor().getRGB());
        sun.parameter("rightColor", null, parseColor().getRGB());
        sun.parameter("topColor", null, parseColor().getRGB());
        sun.parameter("bottomColor", null, parseColor().getRGB());
        sun.parameter("backColor", null, parseColor().getRGB());
        sun.parameter("radiance", null, parseColor().getRGB());
        sun.parameter("samples", p.getNextInt());
        sun.light(generateUniqueName("cornellbox"), "cornell_box");

        
*/        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // light
        
        sun.parameter("up", new Vector3(0, 1, 0));
        sun.parameter("east", new Vector3(0, 0, 1));
        sun.parameter("sundir", new Vector3(1, 1, 1));
        sun.parameter("turbidity", 4.0f);
        sun.parameter("samples", 64);
        sun.light("light", "sunsky");   
        
        
        
        // shader
        
        sun.parameter("depths.diffuse", 0.2f);
        sun.parameter("depths.reflection", 0.1f);
        //sun.parameter("depths.refraction", 0);
        sun.shader("default", "shiny_diffuse");     // shiny_phong

        // object - load from wavefront .obj file
        
//        float[] o = orientation;
//        Matrix4 M = new Matrix4(o[0], o[1], o[2], o[3], o[4], o[5], o[6], o[7], o[8], o[9], o[10], o[11]);
//        sun.parameter("filename", "C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\teapot.obj");
//        sun.parameter("smooth_normals", true);
//        sun.geometry("teapot", "file_mesh");
//        sun.parameter("shaders", "default");
//        sun.parameter("transform", M);
//        sun.instance("teapot.instance", "teapot");    
        AddShape3DObject(sun, orientation, shapes.get(0));
        
        
        // options
        
        sun.parameter("camera", "camera_default");
        //sun.parameter("light", "light_default");
        //sun.parameter("resolutionX", 800);
        //sun.parameter("resolutionY", 450);
        sun.parameter("resolutionX", 533);
        sun.parameter("resolutionY", 300);
        sun.parameter("aa.min", 0);
        sun.parameter("aa.max", 1);
        sun.parameter("filter", "triangle");
        sun.parameter("sampler", "bucket");
        sun.options(SunflowAPI.DEFAULT_OPTIONS);
        
       
        //FileDisplay disp = new FileDisplay(true);
        //sun.render(sun.DEFAULT_OPTIONS, null);
        
        final SunflowGUI frm = new SunflowGUI(new float[] {}, null);
        frm.setVisible(true);
        
        // start rendering in new thread for bucket rendering
        // without a own thread, image panel is first refreshed after rendering finished
        new Thread() 
        {
            @Override
            public void run() 
            {
//                sun.render(SunflowAPI.DEFAULT_OPTIONS, frm.getImagePanel());
            }
            
        }.start();
    }
    
  
    private void AddShape3DObject(SunflowAPI sun, float[] o, Shape3D shape)
    {
        String name = "test";

//      BUILD SIMPLE 3D OBJECT FOR TESTING
//        
//	VTriangleArray vTriangleArray = new VTriangleArray();		
//			
//	Node n1 = new Node(new Point3f(0f,0f,0f));
//        Node n2 = new Node(new Point3f(10f,0f,0f));
//        Node n3 = new Node(new Point3f(0f,10f,0f));
//        Node n4 = new Node(new Point3f(0f,0f,10f));
//
//        vTriangleArray.addTriangle(new Triangle(1,n1,n2,n3));
//        vTriangleArray.addTriangle(new Triangle(2,n1,n2,n4));
//        vTriangleArray.addTriangle(new Triangle(3,n1,n3,n4));
//        vTriangleArray.addTriangle(new Triangle(4,n2,n3,n4));    
//        
//	VGeometry3D geometry = new VGeometry3D(vTriangleArray, Color.black, Color.green, 1F, false);
//        
//        Shape3DArray shape3DArray = geometry.generateShape3DArray();        

        
        TriangleArray triangleArray = (TriangleArray) shape.getGeometry();
        //TriangleArray triangleArray = (TriangleArray) shape3DArray.get(0).getGeometry();
        
        
        int numVertices = triangleArray.getVertexCount();
        int numTriangles = triangleArray.getVertexCount() / 3;   
        float[] points = new float[numVertices * 3];
        int[] triangles = new int[numTriangles * 3];
        
        if (triangleArray != null)
        {
            System.out.println("VertexCount " + triangleArray.getVertexCount());
            for (int i = 0; i < triangleArray.getVertexCount(); i++)
            {
                Point3f p = new Point3f();
                triangleArray.getCoordinate(i, p);
                points[i * 3] = p.x;
                points[i * 3 + 1] = p.y;
                points[i * 3 + 2] = p.z;
                
                triangles[i] = i;
            }
        }
        

        sun.parameter("triangles", triangles);
        sun.parameter("points", "point", "vertex", points);
        //sun.parameter("normals", "vector", "vertex", normals);
        //sun.parameter("uvs", "texcoord", "vertex", uvs);
        sun.geometry(name, "triangle_mesh");


        // create instance
        sun.parameter("shaders", "default");
        //sun.parameter("modifiers", modifiers);
        //sun.parameter("transform", transform[0]);
        Matrix4 M = new Matrix4(o[0], o[1], o[2], o[3], o[4], o[5], o[6], o[7], o[8], o[9], o[10], o[11]);
        sun.parameter("transform", M);        
        sun.instance(name + ".instance", name);	        
        
        
    }
    
    
    
    
    
    
    
//@ComponentInfo(name="Test Sphere", category="Custom")
//class SphereSample implements Serializable {
//  private static final long serialVersionUID=1
//
//  @MethodInfo(callOptions="autoinvoke")
//  public VGeometry3D getSphere() {
//
//    Sphere s = new Sphere(0, 0, 0, 1);
//    s.init(0, 0, 0, 1, Color.white);
//    return s;
//  }
//
//  public VGeometry3D getObj()
//  {
//    File f = new File("C:\\Users\\ThomasL\\Documents\\Queisser\\VRL\\teapot.obj");
//    
//    OBJ2Geometry o = new OBJ2Geometry();
//    return new VGeometry3D(o.loadAsVTriangleArray(f));
//  }
//}    
    
    
    
    
    
    
    
    
    
}
