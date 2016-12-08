package ResourceHandling;

import java.io.File;
import javax.swing.ImageIcon;

public class Resource {
	//Simple type, associating an entity state with the resource(s) to render while in that state, how to render them, and any sounds to play (and how/when to play them).
	private String ResourceName;
	private String TexturePath;
	private ImageIcon TexturePointer;
	private String SoundPath;
	private Boolean SoundLoops;
	private String StateName;
	
	public Resource(String resourceName, String texturePath, String soundPath, Boolean soundLoops, String stateName) {
		setResourceName(resourceName);
		setTexturePath(texturePath);
		setSoundPath(soundPath);
		setSoundLoops(soundLoops);
		setStateName(stateName);
	}
	
	public void setResourceName(String name) {
		ResourceName = name;
	}
	
	public String getResourceName() {
		return ResourceName;
	}
	
	public void setTexturePath(String localPath) {
		TexturePath = localPath;
		File file = new File("");
		String rootPath = file.getAbsolutePath();
		try {
			TexturePointer = new ImageIcon(rootPath + TexturePath); //localPath example: "/Resources/Textures/Background/ExampleBackground.png"
		} catch (Exception e) {}
	}
	
	public String getTexturePath() {
		return TexturePath;
	}
	
	public ImageIcon getTexture() {
		return TexturePointer;
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
