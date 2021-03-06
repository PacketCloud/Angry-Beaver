package resourceHandling;

import fileUtility.OpenImage;

import java.awt.Image;

public class Resource {
	//Simple type, associating an entity state with the resource(s) to render while in that state, how to render them, and any sounds to play (and how/when to play them).
	private String ResourceName;
	private String TexturePath;
	private Image TexturePointer;
	private float TextureScale;
	private String SoundPath;
	private Boolean SoundLoops;
	private String StateName;
	
	public Resource(String resourceName, String texturePath, float textureScale, String soundPath, Boolean soundLoops, String stateName) {
		setResourceName(resourceName);
		setTexturePath(texturePath);
		setTextureScale(textureScale);
		setSoundPath(soundPath);
		setSoundLoops(soundLoops);
		setStateName(stateName);
	}
	
	/******** Getters and Setters ********/
	public void setResourceName(String name) {
		ResourceName = name;
	}
	
	public String getResourceName() {
		return ResourceName;
	}
	
	public void setTexturePath(String localPath) {
		TexturePath = localPath;
		try {
			TexturePointer = new OpenImage().Open(TexturePath);
			TexturePointer.flush();
		} catch (Exception e) {}
	}
	
	public String getTexturePath() {
		return TexturePath;
	}
	
	public Image getTexture() {
		return TexturePointer;
	}
	
	public void setTextureScale(float scale) {
		TextureScale = scale;
	}
	
	public float getTextureScale() {
		return TextureScale;
	}
	
	public void setSoundPath(String path) {
		SoundPath = path;
	}
	
	public String getSoundPath() {
		return SoundPath;
	}
	
	public void setSoundLoops(Boolean soundLoops) {
		SoundLoops = soundLoops;
	}
	
	public Boolean getSoundLoops() {
		return SoundLoops;
	}
	
	public void setStateName(String name) {
		StateName = name;
	}
	
	public String getStateName() {
		return StateName;
	}
}
