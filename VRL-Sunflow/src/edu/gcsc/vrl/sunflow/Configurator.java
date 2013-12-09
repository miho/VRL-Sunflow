/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import edu.gcsc.vrl.sunflow.test.VGeometry3D2Type;
import eu.mihosoft.vrl.io.VJarUtil;
import eu.mihosoft.vrl.io.VersionInfo;
import eu.mihosoft.vrl.lang.visual.CompletionUtil;
import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import java.io.File;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Configurator extends VPluginConfigurator {
    
    private File templateProjectSrc;

    public Configurator() {
        //specify the plugin name and version
        setIdentifier(new PluginIdentifier("VRL-Sunflow", "0.1"));

        // optionally allow other plugins to use the api of this plugin
        // you can specify packages that shall be
        // exported by using the exportPackage() method:
        // 
        exportPackage("edu.gcsc.vrl.sunflow");
//        disableAccessControl(true);
        
        this.exportClass("edu.gcsc.vrl.sunflow.RenderObject");
        this.exportClass("edu.gcsc.vrl.sunflow.RenderObjectType");

        // describe the plugin
        setDescription("Raytracing Plugin based on Sunflow");

        // copyright info
//        setCopyrightInfo("Sample-Plugin",
//                "(c) Your Name",
//                "www.you.com", "License Name", "License Text...");

        // specify dependencies
        addDependency(new PluginDependency("VRL", "0.4.2.7", VersionInfo.UNDEFINED));

    }

    @Override
    public void register(PluginAPI api) {

        // register plugin with canvas
        if (api instanceof VPluginAPI) {
            VPluginAPI vapi = (VPluginAPI) api;

            // Register visual components:
            //
            // Here you can add additional components,
            // type representations, styles etc.
            //
            // ** NOTE **
            //
            // To ensure compatibility with future versions of VRL,
            // you should only use the vapi or api object for registration.
            // If you directly use the canvas or its properties, please make
            // sure that you specify the VRL versions you are compatible with
            // in the constructor of this plugin configurator because the
            // internal api is likely to change.
            //
            // examples:
            //
            // vapi.addComponent(MyComponent.class);
            // vapi.addTypeRepresentation(MyType.class);
            
            vapi.addTypeRepresentation(RenderObjectType.class);

            vapi.addComponent(MyClass.class);
            vapi.addComponent(SunflowComponent.class);
            
        }
    }

    @Override
    public void unregister(PluginAPI api) {
        // nothing to unregister
    }

    @Override
    public void init(InitPluginAPI iApi) {

        CompletionUtil.registerClassesFromJar(
                VJarUtil.getClassLocation(Configurator.class));
        
//        initTemplateProject(iApi);
    }
    
    @Override
    public void install(InitPluginAPI iApi) {
        // ensure template projects are updated
//        new File(iApi.getResourceFolder(), "template-01.vrlp").delete();
    }

//    private void saveProjectTemplate() {
//        InputStream in = Configurator.class.getResourceAsStream(
//                "/edu/gcsc/vrl/densityvis/resources/projects/template-01.vrlp");
//        try {
//            IOUtil.saveStreamToFile(in, templateProjectSrc);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(VRLPlugin.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(VRLPlugin.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//    }

//    private void initTemplateProject(InitPluginAPI iApi) {
//        templateProjectSrc = new File(iApi.getResourceFolder(), "template-01.vrlp");
//
//        if (!templateProjectSrc.exists()) {
//            saveProjectTemplate();
//        }
//
//        iApi.addProjectTemplate(new ProjectTemplate() {
//
//            @Override
//            public String getName() {
//                return "Density-Vis - Template 1";
//            }
//
//            @Override
//            public File getSource() {
//                return templateProjectSrc;
//            }
//
//            @Override
//            public String getDescription() {
//                return "Density-Vis Template Project 1";
//            }
//
//            @Override
//            public BufferedImage getIcon() {
//                return null;
//            }
//        });
//    }
}
