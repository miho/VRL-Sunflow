/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.sunflow;

import java.awt.Color;
import java.io.Serializable;
import org.sunflow.math.Point3;
import org.sunflow.math.Vector3;

/**
 *
 * @author ThomasL
 */
public class SunflowSettings implements Serializable {
    
    // image
    
    public int ImageResolutionX;
    public int ImageResolutionY;
    public String ImageSampler;
    public float ImageAaMin;
    public float ImageAaMax;
    public int ImageAaSamples;
    public float ImageAaContrast;
    public String ImageFilter;
    public boolean ImageJitter;
    public boolean ImageCache;

    // background
    
    //public float[] BackgroundColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
    public float[] BackgroundColor;
    
    // shader
    
    public String ShaderType;

    public float[] ShaderDiffuseRGB;
    public String ShaderDiffuseTexture;

    public float[] ShaderPhongDiffuseRGB;
    public String ShaderPhongTexture;
    public float[] ShaderPhongSpecularRGB;
    public float ShaderPhongPower;
    public int ShaderPhongSamples;

    public float[] ShaderAmbientBrightRGB;
    public String ShaderAmbientTexture;
    public float[] ShaderAmbientDarkRGB;
    public int ShaderAmbientSamples;
    public float ShaderAmbientMaxDist;
    
    public float[] ShaderMirrorColorRGB;
    
    public float ShaderGlassEta;
    public float[] ShaderGlassColorRGB;
    public float ShaderGlassAbsorptionDistance;
    public float[] ShaderGlassAbsorptionColorRGB;

    public float[] ShaderShinyDiffuseColorRGB;
    public String ShaderShinyTexture;
    public float ShaderShinyValue;

    public float[] ShaderWardDiffuseColorRGB;
    public String ShaderWardTexture;
    public float[] ShaderWardSpecularColorRGB;
    public float ShaderWardRoughnessX;
    public float ShaderWardRoughnessY;
    public int ShaderWardSamples;

    public float[] ShaderConstantColorRGB;
    
    public float[] ShaderUberDiffuseColorRGB;
    public String ShaderUberDiffuseTexture;
    public float ShaderUberDiffuseBlend;
    public float[] ShaderUberSpecularColorRGB;
    public String ShaderUberSpecularTexture;
    public float ShaderUberSpecularBlend;
    public float ShaderUberGlossyness;
    public int ShaderUberSamples;
    
    // light

     public String LightType;

     public float[] LightMeshRadianceColor;
     public int LightMeshSamples;
     public String LightMeshSource;

     public Point3 LightPointCenter;
     public float[] LightPointPower;

     public float[] LightSphericalRadianceColor;
     public Point3 LightSphericalCenter;
     public float LightSphericalRadius;
     public float LightSphericalSamples;

     public Point3 LightDirectionalSource;
     public Point3 LightDirectionalTarget;
     public float LightDirectionalRadius;
     public float[] LightDirectionalRadianceColor;

     public String LightIblTexture;
     public Vector3 LightIblCenter;
     public Vector3 LightIblUp;
     public boolean LightIblFixed;
     public int LightIblSamples;
     public int LightIblLowsamples;

     public float[] LightMeshlightRadiance;
     public int LightMeshlightSamples;

     public Vector3 LightSunskyUp;
     public Vector3 LightSunskyEast;
     public Vector3 LightSunskySundir;
     public float LightSunskyTurbidity;
     public int LightSunskySamples;
     public boolean LightSunskyGroundExtendsky;
     public float[] LightSunskyGroundColor;

     public Point3 LightCornellboxCorner0;
     public Point3 LightCornellboxCorner1;
     public float[] LightCornellboxLeftColor;
     public float[] LightCornellboxRightColor;
     public float[] LightCornellboxTopColor;
     public float[] LightCornellboxBottomColor;
     public float[] LightCornellboxBackColor;
     public float[] LightCornellboxRadiance;
     public int LightCornellboxSamples;
    
    // camera

    public String CameraType;

    public float CameraPinholeShutterOpen;
    public float CameraPinholeShutterClose;
    public float CameraPinholeFov;
    public float CameraPinholeAspect;
    public float CameraPinholeShiftX;
    public float CameraPinholeShiftY;

    public float CameraThinlensShutterOpen;
    public float CameraThinlensShutterClose;
    public float CameraThinlensFov;
    public float CameraThinlensAspect;
    public float CameraThinlensShiftX;
    public float CameraThinlensShiftY;
    public float CameraThinlensFocusDistance;
    public float CameraThinlensLensRadius;
    public int CameraThinlensLensSides;
    public float CameraThinlensLensRotation;

    public float CameraSphericalShutterOpen;
    public float CameraSphericalShutterClose;

    public float CameraFisheyeShutterOpen;
    public float CameraFisheyeShutterClose;

    
    
    
//    // image
//    
//    public int ImageResolutionX = 800;
//    public int ImageResolutionY = 600;
//    public String ImageSampler = "bucket";
//    public float ImageAaMin = 0f;
//    public float ImageAaMax = 1f;
//    public int ImageAaSamples = 4;
//    public float ImageAaContrast = 0.1f;
//    public String ImageFilter = "triangle";
//    public boolean ImageJitter = false;
//    public boolean ImageCache = false;
//
//    // background
//    
//    //public float[] BackgroundColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public float[] BackgroundColor;
//    
//    // shader
//    
//    public String ShaderType = "diffuse";
//
//    public float[] ShaderDiffuseRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderDiffuseTexture = "";
//
//    public float[] ShaderPhongDiffuseRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderPhongTexture = "";
//    public float[] ShaderPhongSpecularRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public float ShaderPhongPower = 0.1f;
//    public int ShaderPhongSamples = 10;
//
//    public float[] ShaderAmbientBrightRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderAmbientTexture = "";
//    public float[] ShaderAmbientDarkRGB = SunflowCtrl.colorToFloatArray(Color.BLACK);
//    public int ShaderAmbientSamples = 10;
//    public float ShaderAmbientMaxDist = 0.5f;
//    
//    public float[] ShaderMirrorColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    
//    public float ShaderGlassEta = 1f;
//    public float[] ShaderGlassColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public float ShaderGlassAbsorptionDistance = 5f;
//    public float[] ShaderGlassAbsorptionColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//
//    public float[] ShaderShinyDiffuseColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderShinyTexture = "";
//    public float ShaderShinyValue = 0f;
//
//    public float[] ShaderWardDiffuseColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderWardTexture = "";
//    public float[] ShaderWardSpecularColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public float ShaderWardRoughnessX = 0f;
//    public float ShaderWardRoughnessY = 0f;
//    public int ShaderWardSamples = 10;
//
//    public float[] ShaderConstantColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    
//    public float[] ShaderUberDiffuseColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderUberDiffuseTexture = "";
//    public float ShaderUberDiffuseBlend = 0f;
//    public float[] ShaderUberSpecularColorRGB = SunflowCtrl.colorToFloatArray(Color.WHITE);
//    public String ShaderUberSpecularTexture = "";
//    public float ShaderUberSpecularBlend = 0f;
//    public float ShaderUberGlossyness = 0f;
//    public int ShaderUberSamples = 10;
//    
//    // light
//
//     public String LightType = "mesh";
//
//     public float[] LightMeshRadianceColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public int LightMeshSamples = 4;
//     public String LightMeshSource = "";
//
//     public Point3 LightPointCenter = new Point3(0, 2.4f, 1f);
//     public float[] LightPointPower = SunflowCtrl.colorToFloatArray(Color.WHITE);;
//
//     public float[] LightSphericalRadianceColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public Point3 LightSphericalCenter = new Point3(0, 2.4f, 1f);
//     public float LightSphericalRadius = 1f;
//     public float LightSphericalSamples = 64;
//
//     public Point3 LightDirectionalSource = new Point3(0, 2.4f, 1f);
//     public Point3 LightDirectionalTarget = new Point3(0, 0f, 0f);
//     public float LightDirectionalRadius = 6f;
//     public float[] LightDirectionalRadianceColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//
//     public String LightIblTexture = "";
//     public Vector3 LightIblCenter = new Vector3(0, 2.4f, 1f);
//     public Vector3 LightIblUp = new Vector3(0, 1f, 0f);
//     public boolean LightIblFixed = false;
//     public int LightIblSamples = 4;
//     public int LightIblLowsamples = 4;
//
//     public float[] LightMeshlightRadiance = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public int LightMeshlightSamples = 4;
//
//     public Vector3 LightSunskyUp = new Vector3(0, 1, 0);
//     public Vector3 LightSunskyEast = new Vector3(0, 0, 1);
//     public Vector3 LightSunskySundir = new Vector3(1, 1, 1);
//     public float LightSunskyTurbidity = 4f;
//     public int LightSunskySamples = 64;
//     public boolean LightSunskyGroundExtendsky = false;
//     public float[] LightSunskyGroundColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//
//     public Point3 LightCornellboxCorner0 = new Point3(0, 2.4f, 1f);
//     public Point3 LightCornellboxCorner1 = new Point3(0, 2.4f, 1f);
//     public float[] LightCornellboxLeftColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public float[] LightCornellboxRightColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public float[] LightCornellboxTopColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public float[] LightCornellboxBottomColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public float[] LightCornellboxBackColor = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public float[] LightCornellboxRadiance = SunflowCtrl.colorToFloatArray(Color.WHITE);
//     public int LightCornellboxSamples = 4;
//    
//    // camera
//
//    public String CameraType = "pinhole";
//
//    public float CameraPinholeShutterOpen = 0f;
//    public float CameraPinholeShutterClose = 0f;
//    public float CameraPinholeFov = 25f;
//    public float CameraPinholeAspect = 1.777f;
//    public float CameraPinholeShiftX = 0f;
//    public float CameraPinholeShiftY = 0f;
//
//    public float CameraThinlensShutterOpen = 0f;
//    public float CameraThinlensShutterClose = 0f;
//    public float CameraThinlensFov = 20f;
//    public float CameraThinlensAspect = 1.777f;
//    public float CameraThinlensShiftX = 0f;
//    public float CameraThinlensShiftY = 0f;
//    public float CameraThinlensFocusDistance = 1f;
//    public float CameraThinlensLensRadius = 1f;
//    public int CameraThinlensLensSides = 1;
//    public float CameraThinlensLensRotation = 0f;
//
//    public float CameraSphericalShutterOpen = 0f;
//    public float CameraSphericalShutterClose = 0f;
//
//    public float CameraFisheyeShutterOpen = 0f;
//    public float CameraFisheyeShutterClose = 0f;    
    
    
    
    
    
}





    /* 
     * image.resolution
     * image.sampler
     * image.aa.min
     * image.aa.max
     * image.aa.samples
     * image.aa.contrast
     * image.filter
     * image.jitter
     * image.cache
     * 
     * background.color
     * 
     ** shader.type
     * diffuse.rgb
     * diffuse.texture
     * phong.diffuse.rgb
     * phong.texture
     * phong.specular.rgb
     * phong.power
     * phong.samples
     * ambient.bright.RGB
     * ambient.texture
     * ambient.dark.RGB
     * ambient.samples
     * ambient.maxdist
     * mirror.color.RGB
     * glass.eta
     * glass.color.RGB
     * glass.absorption.distance
     * glass.absorption.color.RGB
     * shiny.diffuse.color.RGB
     * shiny.texture
     * shiny.value
     * ward.diffuse.color.RGB
     * ward.texture
     * ward.specular.color.RGB
     * ward.roughnessX
     * ward.roughnessY
     * ward.samples
     * constant.color.RGB
     * uber.diffuse.color.RGB
     * uber.diffuse.texture
     * uber.diffuse.blend
     * uber.specular.color.RGB
     * uber.specular.texture
     * uber.specular.blend
     * uber.glossyness
     * uber.samples
     * 
     ** light.type
     * mesh.radiance.color
     * mesh.samples
     * mesh.source
     * point.center
     * point.power
     * spherical.radiance.color
     * spherical.center
     * spherical.radius
     * spherical.samples
     * directional.source
     * directional.target
     * directional.radius
     * directional.radiance.color
     * ibl.texture
     * ibl.center
     * ibl.up
     * ibl.fixed
     * ibl.samples
     * ibl.lowsamples
     * meshlight.radiance
     * meshlight.samples
     * sunsky.up
     * sunsky.east
     * sunsky.sundir
     * sunsky.turbidity
     * sunsky.samples
     * sunsky.ground.extendsky
     * sunsky.ground.color
     * cornellbox.corner0
     * cornellbox.corner1
     * cornellbox.leftColor
     * cornellbox.rightColor
     * cornellbox.topColor
     * cornellbox.bottomColor
     * cornellbox.backColor
     * cornellbox.radiance
     * cornellbox.samples
     * 
     ** camera.type
     * pinhole.shutter.open
     * pinhole.shutter.close
     * pinhole.fov
     * pinhole.aspect
     * pinhole.shift.x
     * pinhole.shift.y
     * thinlens.shutter.open
     * thinlens.shutter.close
     * thinlens.fov
     * thinlens.aspect
     * thinlens.shift.x
     * thinlens.shift.y
     * thinlens.focus.distance
     * thinlens.lens.radius
     * thinlens.lens.sides
     * thinlens.lens.rotation
     * spherical.shutter.open
     * spherical.shutter.close
     * fisheye.shutter.open
     * fisheye.shutter.close
     * 
     * 
    */