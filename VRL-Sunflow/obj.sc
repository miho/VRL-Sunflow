
shader {
  name default
  type shiny
  diff 0.2 0.2 0.2
  refl 0.1
}



object { 
   shader default
	transform {
		rotatex 0
		scaleu 1
		rotatey -90
		translate 0 0 0
	}
	type file-mesh
	name objectName
/*	filename C:\Users\ThomasL\Documents\NetBeansProjects\VRL-Sunflow\VRL-Sunflow\teapot.obj  */
	filename C:\Users\ThomasL\Dropbox\3d-cells\bowfly_visual_lobe\bowfly_visual_lobe_VS4-fluoro03.CNG.obj  	
	smooth_normals true 
}





