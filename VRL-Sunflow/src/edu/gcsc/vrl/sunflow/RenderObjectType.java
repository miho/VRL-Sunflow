package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.TypeInfo;
import eu.mihosoft.vrl.reflection.CustomParamData;
import eu.mihosoft.vrl.reflection.TypeRepresentationBase;
import javax.swing.JButton;

@TypeInfo(type = RenderObject.class, input = true, output = true, style = "default")
public class RenderObjectType extends TypeRepresentationBase {

    private static final long serialVersionUID = 1;
    private RenderObject renderObject;
    private SunflowCtrl ctrl;
    
    public RenderObjectType() {
        
//        nameLabel.setText("Shape3D Array:");
//        nameLabel.setAlignmentY(0.5f);
//        this.add(nameLabel);        
//        JButton button = new JButton("test");
//        this.add(button);

        ctrl = new SunflowCtrl();
        this.add(ctrl);
    }
    
    
    @Override
    public void setViewValue(Object o) {
        this.renderObject = (RenderObject)o;
        ctrl.setRenderObject(renderObject);
    }

    @Override
    public Object getViewValue() {
        return this.renderObject;
    }
    
    public RenderObject getRenderObject()
    {
        return this.renderObject;
    }
    
    
/**
 * Example for generating a CustomParamData object. It can store additional data that
 * is not part of the value the type representation visualizes. For example, it can store
 * ui properties such as default values, tables, etc. This method is called automatically
 * when serialization starts (project save).
 */
 @Override
 public CustomParamData getCustomData() {

     CustomParamData result = super.getCustomData();

//     MyData data = new MyData();
//
//     result.put("MY_KEY", data); // adds data to the CustomParamData object

     return result;
 }

/**
 * Example for evaluation a CustomParamData object.
 *
 *
 */
 @Override
 public void evaluateCustomParamData() {
//     MyData data = (MyData)super.getCustomData().get("MY_KEY"); // returns the data object from the CustomParamData object
     
     // update ui with values from data
     
 }    
    
    
    
    
}
