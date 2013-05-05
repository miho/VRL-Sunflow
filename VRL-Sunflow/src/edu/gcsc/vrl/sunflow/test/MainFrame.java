/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow.test;

import java.awt.Frame;
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

public class MainFrame extends JFrame implements ActionListener
{ 
    private SimpleUniverse simpleU; 
    private BranchGroup scene;
    private JButton btnTest;

    public MainFrame(int width, int height) 
    { 
        setLayout(new BorderLayout()); 
        Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration()); 
        add("Center", c);  
        
        btnTest = new JButton("test");
        btnTest.addActionListener(this);
        add("South", btnTest);
        
        simpleU = new SimpleUniverse(c); // setup the SimpleUniverse, attach the Canvas3D
        scene = createSceneGraph(); 
        simpleU.getViewingPlatform().setNominalViewingTransform();
        scene.compile(); 
        simpleU.addBranchGraph(scene); //add your SceneGraph to the SimpleUniverse   
        
        
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
        setSize( width, height );
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(new Point((d.width-getSize().width )/2, (d.height-getSize().height)/2));        

    }
    
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == btnTest)
        { 
            System.out.println("Button geklickt!"); 
            
        } 
    }    
    
    
    public BranchGroup createSceneGraph() {      

   	BranchGroup objRoot = new BranchGroup(); 
	TransformGroup tg = new TransformGroup();
        Transform3D t3d = new Transform3D();

        Scene s = null;
        ObjectFile f = new ObjectFile ();
        //f.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        f.setFlags (ObjectFile.RESIZE);
        

        //String s1 = "C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\Bic2.obj";
        String s1 = "C:\\Users\\ThomasL\\Documents\\NetBeansProjects\\VRL-Sunflow\\VRL-Sunflow\\teapot.obj";
        try 
        {
            s = f.load (s1);
        } 
        catch (FileNotFoundException ex) 
        {
        }
        tg.addChild (s.getSceneGroup ());


        // BoundingSpere für Mousebehavior und Lichtquelle erzeugen
      	BoundingSphere bounds = new BoundingSphere (new Point3d (0.0, 0.0, 0.0), 100.0);
        // Mouse-Rotation-Behavior ersetzen und in Transformgruppe einhängen + Capabilitybits setzen
        MouseRotate behavior = new MouseRotate(tg);
        tg.addChild(behavior);
        behavior.setSchedulingBounds( bounds );
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_WRITE );
        tg.setCapability( TransformGroup.ALLOW_TRANSFORM_READ );
   

        //Lichtquelle erzeugen und in Szenengraphen hängen
        Color3f lColor1 = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f lDir1  = new Vector3f( 0f, 0f, -1.0f);
        DirectionalLight lgt1 = new DirectionalLight( lColor1, lDir1 );
        lgt1.setInfluencingBounds( bounds );
        objRoot.addChild( lgt1 );
        

        
      	t3d.setTranslation(new Vector3f(0f,0f,-5f));
      	tg.setTransform(t3d);
      	objRoot.addChild(tg);
      	return objRoot;
      	}

      	public void destroy() 
        {	
            simpleU.removeAllLocales();    
      	}  

      	public static void main(String[] args) 
        {
            JFrame frame = new MainFrame(800, 600);    
      	}


}
