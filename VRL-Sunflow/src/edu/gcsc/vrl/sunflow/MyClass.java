/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.ComponentInfo;
import java.io.Serializable;

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
    

    /**
     * @return the string
     */
    public String getString() {
        return "test1";
    }

    /**
     * @param string the string to set
     */
    public void setString(String string) {
        this.string = string;
    }
    
    public void setVGeometry3D2(VGeometry3D2 geo)
    {
        
    }
}
