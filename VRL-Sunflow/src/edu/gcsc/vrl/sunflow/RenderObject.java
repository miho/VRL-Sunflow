package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.ObjectInfo;
import eu.mihosoft.vrl.v3d.Shape3DArray;
import java.io.Serializable;


@ObjectInfo(serializeParam=false)
public class RenderObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private float[] orientation;
    private Shape3DArray shapes;    
    
    public RenderObject(Shape3DArray shapes, float[] orientation) {
    //public RenderObject() {
        this.shapes = shapes;
        this.orientation = orientation;
    }
    
    public float[] getOrientation()
    {
        return this.orientation;
    }
    
    public Shape3DArray getShapes()
    {
        return this.shapes;
    }
}
