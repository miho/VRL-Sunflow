/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import eu.mihosoft.vrl.v3d.VGeometry3D;
import eu.mihosoft.vrl.v3d.VGeometry3DAppearance;
import eu.mihosoft.vrl.v3d.VTriangleArray;
import java.awt.Color;
import javax.media.j3d.Material;

/**
 *
 * @author ThomasL
 */
@ComponentInfo(name="VGeometry3D2", category="Sunflow")
public class VGeometry3D2 extends VGeometry3D {
 
    public VGeometry3D2() {
        super();
    }

    public VGeometry3D2(VTriangleArray geometry) {
        super(geometry);
    }

    public VGeometry3D2(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting) {

        super(geometry, solidColor, wireColor, wireThickness, lighting);
    }

    public VGeometry3D2(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting,
            boolean vertexColoring,
            boolean volumeRendering) {

        super(geometry, solidColor, wireColor, wireThickness, lighting, vertexColoring, volumeRendering);
    }

    public VGeometry3D2(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting,
            boolean vertexColoring,
            int vertexColoringType,
            boolean volumeRendering) {
        
        super(geometry, solidColor, wireColor, wireThickness, lighting, vertexColoring, vertexColoringType, volumeRendering);
    }
    

    public VGeometry3D2(VTriangleArray geometry,
            VGeometry3DAppearance appearance) {
        
        super(geometry, appearance);
    }    
    
}
