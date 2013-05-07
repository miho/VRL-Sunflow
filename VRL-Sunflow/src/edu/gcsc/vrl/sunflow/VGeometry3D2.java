/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

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
 
    public VGeometry3D() {
        setAppearance(new VGeometry3DAppearance());
    }

    public VGeometry3D(VTriangleArray geometry) {
        setAppearance(new VGeometry3DAppearance());
        setGeometry(geometry);
    }

    public VGeometry3D(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting) {

        setAppearance(new VGeometry3DAppearance(wireColor,
                solidColor, wireThickness, lighting));

        this.geometry = geometry;
    }

    public VGeometry3D(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting,
            boolean vertexColoring,
            boolean volumeRendering) {

        setAppearance(new VGeometry3DAppearance(wireColor,
                solidColor, wireThickness, lighting, vertexColoring,
                Material.DIFFUSE, volumeRendering));

        this.geometry = geometry;
    }

    public VGeometry3D(VTriangleArray geometry,
            Color solidColor,
            Color wireColor,
            float wireThickness,
            boolean lighting,
            boolean vertexColoring,
            int vertexColoringType,
            boolean volumeRendering) {

        setAppearance(new VGeometry3DAppearance(wireColor,
                solidColor, wireThickness, lighting, vertexColoring,
                vertexColoringType, volumeRendering));

        this.geometry = geometry;
    }
    

    public VGeometry3D(VTriangleArray geometry,
            VGeometry3DAppearance appearance) {
        setGeometry(geometry);
        setAppearance(appearance);
    }    
    
}
