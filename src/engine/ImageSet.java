package engine;

import java.awt.image.BufferedImage;


public class ImageSet {
/* Currently one Image. This is the ImageSet Singleton which
 * 	will hold a list of all BufferedImages to draw.
 * 	In order to use this class:
 * 		ImageSet imageSet = ImageSet.getInstance();
 */
	
	Boolean loaded = false;
	private static ImageSet firstInstance = null;
	
	//TODO set up a structure to hold BufferedImage variables
	BufferedImage img = null;
    
	public static ImageSet getInstance(){
        if(firstInstance == null){
            synchronized(Level.class){
                if(firstInstance == null){
                	firstInstance = new ImageSet ();
                	firstInstance.loadImages();
                }
            }
        }
        return firstInstance;
	}

	public void loadImages() {
		//TODO call to FileUtility to open images
		loaded = true;
	}

	public BufferedImage getImage(String image) {
		if(loaded == true) {
			return getImageLogic(image);
		}
		return null;
	}
	
	public BufferedImage getImageLogic(String image) {
		//TODO use logic to determine the BufferedImage to return
		return img;
	}
}
