/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.v3d.Node;
import eu.mihosoft.vrl.v3d.OBJ2Geometry;
import eu.mihosoft.vrl.v3d.Triangle;
import eu.mihosoft.vrl.v3d.VTriangleArray;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.vecmath.Point3f;

/**
 *
 * @author Thomas Licht <thomas.licht@stud.uni-frankfurt.de>
 */
@ComponentInfo(name="MyClass", category="Sunflow")
public class MyClass implements Serializable {
    private final long serialVersionUID=1L;
    
    private String string;

    public MyClass() {
        //
    }
    

//    /**
//     * @return the string
//     */
//    public String getString() {
//        return "test1";
//    }

//    /**
//     * @param string the string to set
//     */
//    public void setString(String string) {
//        this.string = string;
//    }
    
//    public VGeometry3D2 simpleGeometry()
//    {
//        VTriangleArray result = new VTriangleArray();
//
//        Node n1 = new Node(new Point3f(0f,0f,0f));
//        Node n2 = new Node(new Point3f(10f,0f,0f));
//        Node n3 = new Node(new Point3f(0f,10f,0f));
//        Node n4 = new Node(new Point3f(0f,0f,10f));
//
//        result.addTriangle(new Triangle(1,n1,n2,n3));
//        result.addTriangle(new Triangle(2,n1,n2,n4));
//        result.addTriangle(new Triangle(3,n1,n3,n4));
//        result.addTriangle(new Triangle(4,n2,n3,n4));
//
//        return new VGeometry3D2(result,Color.black,Color.green,1F,false);       
//    }
    
    private VGeometry3D2 geom = null;
    public VGeometry3D2 loadObjFile() throws IOException
    {
        if (geom == null)
        {
            File f = new File("C:\\Users\\ThomasL\\Dropbox\\3d-cells\\bowfly_visual_lobe\\bowfly_visual_lobe_VS4-fluoro03.CNG.obj");
            //File f = new File("C:\\Users\\ThomasL\\Dropbox\\3d-cells\\human_neocortec_03b\\human_neocortec_03b_pyramidal4aFI.CNG.obj");
            //File f = new File("C:\\Users\\ThomasL\\Dropbox\\3d-cells\\mouse_retina_simple\\mouse_retina_simple_cell-101-trace.CNG.obj");
            //File f = new File("C:\\Users\\ThomasL\\Dropbox\\3d-cells\\rat_hippocampus_crablike\\rat_hippocampus_crablike_CA1-W-P15-2.CNG.obj");
            OBJ2Geometry o = new OBJ2Geometry();
            geom = new VGeometry3D2(o.loadAsVTriangleArray(f));
        }
        
        return geom;
    }
    
}
