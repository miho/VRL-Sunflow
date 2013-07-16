/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import javax.swing.JFrame;

/**
 *
 * @author ThomasL
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                new Runnable() 
                {
                    @Override
                    public void run() 
                    {        
                        JFrame frame = new JFrame();
                        SunflowCtrl ctrl = new SunflowCtrl();

                        frame.add(ctrl);
                        frame.setSize(800, 600);

                        frame.setVisible(true);
                    }
                });
    }
}
