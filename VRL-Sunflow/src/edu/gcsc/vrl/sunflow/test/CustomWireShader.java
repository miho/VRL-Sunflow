/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;

import org.sunflow.core.ShadingState;
import org.sunflow.core.shader.WireframeShader;
import org.sunflow.image.Color;

/**
 *
 * @author ThomasL
 */
public class CustomWireShader extends WireframeShader 
{
    // set to false to overlay wires on regular shaders
    private boolean ambocc = true; 

    @Override
    public Color getFillColor(ShadingState state) 
    {
        return ambocc ? state.occlusion(16, 6.0f) : state.getShader().getRadiance(state);  
    }
}
