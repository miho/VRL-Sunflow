/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;

import org.sunflow.SunflowAPI;
import org.sunflow.core.ParameterList;
import org.sunflow.core.PrimitiveList;
import org.sunflow.core.primitive.CubeGrid;

/**
 *
 * @author ThomasL
 */
public class MengerSponge extends CubeGrid 
{
    private int depth;

    public MengerSponge() {
        depth = 3;
    }
    
    @Override
    public boolean update(ParameterList pl, SunflowAPI api) {
        depth = pl.getInt("depth", depth);
        int n = 1;
        for (int i = 0; i < depth; i++) {
            n *= 3;
        }
        pl.addInteger("resolutionX", n);
        pl.addInteger("resolutionY", n);
        pl.addInteger("resolutionZ", n);
        return super.update(pl, api);
    }

    @Override
    protected boolean inside(int x, int y, int z) {
        for (int i = 0; i < depth; i++) {
            if ((x % 3) == 1 ? (y % 3) == 1 || (z % 3) == 1 : (y % 3) == 1 && (z % 3) == 1) {
                return false;
            }
            x /= 3;
            y /= 3;
            z /= 3;
        }
        return true;
    }

    @Override
    public PrimitiveList getBakingPrimitives() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}

