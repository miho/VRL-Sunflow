package edu.gcsc.vrl.sunflow;

import eu.mihosoft.vrl.annotation.TypeInfo;
import eu.mihosoft.vrl.reflection.CustomParamData;
import eu.mihosoft.vrl.reflection.TypeRepresentationBase;
import javax.swing.JButton;

// never set output to false, otherwise this type representation is not used (no gui will be shown)
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
        System.out.println("RenderObjectType.setViewValue");
        if (o==null) {
            System.out.println("  input is null");
        }
        
        if (o != null)
        {
            this.renderObject = (RenderObject)o;
            ctrl.setRenderObject(renderObject);
        }
    }

    @Override
    public Object getViewValue() {
        System.out.println("RenderObjectType.getViewValue");
        if (renderObject==null) {
            System.out.println("  result is null");
        }
        
        return this.renderObject;
    }
    
    @Override
    public void setValue(Object o)
    {
        System.out.println("RenderObjectType.setValue");
        if (o==null) {
            System.out.println("  input is null");
        }
        
        if (o != null)
        {
            this.renderObject = (RenderObject)o;
            ctrl.setRenderObject(renderObject);
        }
    }
    
    @Override
    public Object getValue()
    {
        System.out.println("RenderObjectType.getValue");
        if (renderObject==null) {
            System.out.println("  result is null");
        }
        
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

     if (ctrl != null)
     {
        SunflowSettings settings = ctrl.getSunflowSettings();
        // adds data to the CustomParamData object
        if (settings != null)
            result.put("my_settings", settings);                     
     }
     
     return result;
 }

/**
 * Example for evaluation a CustomParamData object.
 *
 *
 */
 @Override
 public void evaluateCustomParamData() {

     if (ctrl != null)
     {
        // returns the data object from the CustomParamData object
        SunflowSettings settings = (SunflowSettings)super.getCustomData().get("my_settings"); 

        // update ui with values from data
        if (settings != null)
            ctrl.setSunflowSettings(settings);
     }
     
 }    
    
    
    
    
}
