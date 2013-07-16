/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;


import java.awt.*;
import java.awt.event.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;  //  Mousebehavior
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.*;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.sunflow.SunflowAPI;
import org.sunflow.core.camera.PinholeLens;
import org.sunflow.core.display.FileDisplay;
import org.sunflow.math.Matrix4;
import org.sunflow.math.Point3;
import org.sunflow.math.Vector3;


public class TestJava3D extends JFrame implements ActionListener
{ 
    // controls
    private JButton btnTest;
    
    // Java3D components
    private SimpleUniverse universe; 
    private BranchGroup root_group;

    public TestJava3D(int width, int height) 
    { 
        // -------------------------------
        // add Canvas3D
        setLayout(new BorderLayout()); 
        Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration()); 
        add("Center", c);  
        
        // -------------------------------
        // add Button
        btnTest = new JButton("test");
        btnTest.addActionListener(this);
        add("South", btnTest);
        
        
        // -------------------------------
        // configure Java3D
        universe = new SimpleUniverse(c);           // setup the SimpleUniverse, attach the Canvas3D
        root_group = new BranchGroup();
               
        // ADD TEAPOT
        TransformGroup tg_teapot = new TransformGroup();
        Transform3D t3d_teapot = new Transform3D();
        Scene scene_teapot = loadTeapot();
        // transform teapot
        Vector3f vector = new Vector3f(0f, 0f, 0f);
        t3d_teapot.setTranslation(vector);
        tg_teapot.setTransform(t3d_teapot);
        // add teapot scene to transform group
        tg_teapot.addChild (scene_teapot.getSceneGroup());
        // add teapot to root group
        root_group.addChild(tg_teapot);

/*        
        // ADD 2nd TEAPOT
        tg_teapot = new TransformGroup();
        t3d_teapot = new Transform3D();
        scene_teapot = loadTeapot();
        Shape3D shape_teapot = (Shape3D) scene_teapot.getSceneGroup().getChild(0);
        
        Appearance appearance = new Appearance();
        appearance.setPolygonAttributes(new PolygonAttributes(PolygonAttributes.POLYGON_LINE, PolygonAttributes.CULL_BACK,0.0f));     
        shape_teapot.setAppearance(appearance);
        
        // transform teapot
        vector = new Vector3f(1f, 0f, 0f);
        t3d_teapot.setTranslation(vector);
        tg_teapot.setTransform(t3d_teapot);
        // add teapot scene to transform group
        tg_teapot.addChild (scene_teapot.getSceneGroup());
        // add teapot to root group
        root_group.addChild(tg_teapot);        
*/        

        
        // BoundingSpere für Mousebehavior und Lichtquelle erzeugen
      	BoundingSphere bounds = new BoundingSphere (new Point3d (0.0, 0.0, 0.0), 100.0);
        // Mouse-Rotation-Behavior ersetzen und in Transformgruppe einhängen + Capabilitybits setzen
        MouseRotate behavior = new MouseRotate(tg_teapot);
        tg_teapot.addChild(behavior);
        behavior.setSchedulingBounds( bounds );
        tg_teapot.setCapability( TransformGroup.ALLOW_TRANSFORM_WRITE );
        tg_teapot.setCapability( TransformGroup.ALLOW_TRANSFORM_READ );        
        
        // Lichtquelle erzeugen und in Szenengraphen hängen
        Color3f lColor1 = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f lDir1  = new Vector3f( 0f, 0f, -1.0f);
        DirectionalLight lgt1 = new DirectionalLight( lColor1, lDir1 );
        lgt1.setInfluencingBounds( bounds );
        root_group.addChild( lgt1 );        
        
        
        
        
        
        // VIEW PLATFORM        
        //create the ViewPlatform BranchGroup
//      BranchGroup vpBranchGroup = new BranchGroup();
        //create a TransformGroup to scale the ViewPlatform
        //(and hence View)
        TransformGroup tg = new TransformGroup();
        //create the ViewPlatform
        ViewPlatform vp = new ViewPlatform();
        vp.setViewAttachPolicy( View.RELATIVE_TO_FIELD_OF_VIEW );
        //attach the ViewPlatform to the TransformGroup
        tg.addChild( vp );
        //attach the TransformGroup to the BranchGroup
        root_group.addChild( tg );

        //Move the camera BACK a little. Note that Transformation
        //matrices above the ViewPlatform are inverted by the View
        //renderer prior to rendering. By moving the camera back 20
        //meters, you can see geometry objects that are positioned at 0,0,0.
        Transform3D t3d = new Transform3D();
        t3d.lookAt(new Point3d(0, 0, 20), new Point3d(0, 0, 1), new Vector3d(0, 1, 0));
//        t3d.setTranslation( new Vector3d( 0.0, 0.0, 20.0 ) );
        tg.setTransform( t3d );

        //finally, add the ViewPlatform BranchGroup to the Locale
//        universe.addBranchGraph( root_group ); 
        
        //create the View object
        View view = new View();
        //create the PhysicalBody and PhysicalEnvironment for the View
        //and attach to the View
        PhysicalBody pb = new PhysicalBody();
        PhysicalEnvironment pe = new PhysicalEnvironment();
        view.setPhysicalEnvironment( pe );
        view.setPhysicalBody( pb );

        //attach the View to the ViewPlatform
        view.attachViewPlatform( vp );

        //set the near and far clipping planes for the View
        view.setBackClipDistance( 110 );
        view.setFrontClipDistance( 10 );
       
        
        
        
        
        
//        root_group.compile(); 
//        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(root_group);             //add your SceneGraph to the SimpleUniverse   
        
        
        // -------------------------------
        // configure window
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
        setSize( width, height );
//      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//      setLocation(new Point((d.width-getSize().width )/2, (d.height-getSize().height)/2));        

    }
    
    
    private Scene loadTeapot()
    {
        Scene scene = null;
        ObjectFile objfile = new ObjectFile();
        objfile.setFlags (ObjectFile.RESIZE);     // | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY

        try 
        {
            scene = objfile.load ("C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\teapot.obj");
        } 
        catch (FileNotFoundException ex) 
        {
        }

        return scene;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnTest)
        { 
            Transform3D t3d_view = new Transform3D();
            TransformGroup tg = universe.getViewingPlatform().getMultiTransformGroup().getTransformGroup(0);

            View view = universe.getViewer().getView();
            double fov = view.getFieldOfView();
            double zNear = view.getBackClipDistance();
            double zFar = view.getFrontClipDistance();
            System.out.println(fov);
            System.out.println(zNear);
            System.out.println(zFar);
            
            tg.getTransform(t3d_view);
            
            Vector3f v = new Vector3f();
            t3d_view.get(v);
            System.out.println(v.toString());
            
            v.z += 0.1f;
            
//            t3d_view.set(v);
            //t3d_view.perspective(Math.toRadians(30), 1.7777777, 0.1, 10);
            //t3d_view.setIdentity();
//            t3d_view.perspective(0.78, 1.33333333, 0.1, 10);
//            tg.setTransform(t3d_view);
            
            
            Matrix4f m = new Matrix4f();
            t3d_view.get(m);
            System.out.println(m.toString()); 

            
            render();
        } 
    }    
    
    public void destroy() 
    {	
        universe.removeAllLocales();    
    }  

    public static void main(String[] args) 
    {
        JFrame frame = new TestJava3D(800, 600);    
    }

    
    
    public void render()
    {
        SunflowAPI sun = new SunflowAPI();
        
        // camera
        
        sun.parameter("transform", Matrix4.lookAt(
                //new Point3(-18.19f, 8.97f, -0.93f),         // eye 
                new Point3(0f, 0f, 2.4142137f),
                //new Point3(-0.69f, 0.97f, -0.93f),          // target
                new Point3(0f, 0f, 0f),         
                //new Vector3(0.0f, 1.0f, 0.0f)));            // up
                new Vector3(0.0f, 1.0f, 0.0f)));            
        //sun.parameter("fov", 30.0f);
        sun.parameter("fov", (float)Math.toDegrees(0.7853981633974483));
        System.out.print((float)Math.toDegrees(0.7853981633974483));
        sun.parameter("aspect", 1.777777777777f);
        sun.camera("camera_default", "pinhole");
        
        // light
        
        sun.parameter("up", new Vector3(0, 1, 0));
        sun.parameter("east", new Vector3(0, 0, 1));
        sun.parameter("sundir", new Vector3(1, 1, 1));
        sun.parameter("turbidity", 4.0f);
        sun.parameter("samples", 64);
        sun.light("light", "sunsky");   
        
        // shader
        
        sun.parameter("depths.diffuse", 0.2f);
        sun.parameter("depths.reflection", 0.1f);
        //sun.parameter("depths.refraction", 0);
        sun.shader("default", "shiny_diffuse");     // shiny_phong

        // object - load from wavefront .obj file
        
        sun.parameter("filename", "C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\teapot.obj");
        sun.parameter("smooth_normals", true);
        sun.geometry("teapot", "file_mesh");
        sun.parameter("shaders", "default");
        sun.instance("teapot.instance", "teapot");        
        
        // options
        
        sun.parameter("camera", "camera_default");
        //sun.parameter("light", "light_default");
        //sun.parameter("resolutionX", 800);
        //sun.parameter("resolutionY", 450);
        sun.parameter("resolutionX", 533);
        sun.parameter("resolutionY", 300);
        sun.parameter("aa.min", 0);
        sun.parameter("aa.max", 1);
        sun.parameter("filter", "triangle");
        sun.options(sun.DEFAULT_OPTIONS);
        
       
        //FileDisplay disp = new FileDisplay(true);
        sun.render(sun.DEFAULT_OPTIONS, null);
    }

}
