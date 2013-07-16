/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.annotation.MethodInfo;
import eu.mihosoft.vrl.annotation.ParamInfo;
import eu.mihosoft.vrl.reflection.TypeRepresentationBase;
import eu.mihosoft.vrl.v3d.Shape3DArray;
import java.awt.Button;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author ThomasL
 */
@ComponentInfo(name="SunflowComponent", category="Sunflow")
public class SunflowComponent implements Serializable {
    private final long serialVersionUID=1L; 
    private Shape3DArray shapes;
    private float[] orientation;
    
    
    public SunflowComponent() {
        
    }
    
//    @MethodInfo(interactive=false, noGUI=true, hideCloseIcon=true, valueStyle="silent")
//    public void setGeometry(@ParamInfo(name="VGeometry3D2", style="silent")VGeometry3D2 v)
//    {
//        System.out.print("setGeometry");
//        this.shapes = v.generateShape3DArray();
//        
//        double[] doubleArray = v.getOrientation();
//        if (doubleArray != null)
//        {
//            float[] floatArray = new float[doubleArray.length];
//            for (int i = 0 ; i < doubleArray.length; i++)
//            {
//                floatArray[i] = (float) doubleArray[i];
//            }
//            this.orientation = floatArray;
//        }
//        else
//            this.orientation = null;
//    }
    
//    public RenderObject Render()
//    {
//        return new RenderObject(this.shapes, this.orientation);
//    }
       
    private transient VGeometry3D2 geom = null;
    //@ParamInfo options = "hideConnector=false" , nullIsValid=true
    //@MethodInfo valueStyle="silent"
    @MethodInfo(interactive=true, noGUI=false, hideCloseIcon=true)
    public RenderObject Render(@ParamInfo(name=" ", style="silent")VGeometry3D2 v)
    {
        System.out.println("-> Render()");
        if (v != null)
        {
            if (geom == null || geom != v)
            {
                this.shapes = v.generateShape3DArray();
                geom = v;
            }

            // convert orientation from double[] to float[]
            double[] doubleArray = v.getOrientation();
            if (doubleArray != null)
            {
                float[] floatArray = new float[doubleArray.length];
                for (int i = 0 ; i < doubleArray.length; i++)
                {
                    floatArray[i] = (float) doubleArray[i];
                }
                this.orientation = floatArray;
            }
            else
            {
                this.orientation = null;        
            }
            
            return new RenderObject(this.shapes, this.orientation);
        }
        else 
        {
            System.out.println("   Input is null!");
            //return null;
            return new RenderObject(this.shapes, this.orientation);
        }
    }        
        
}
