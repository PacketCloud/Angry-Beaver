package resourceHandling;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import resourceHandling.Resource;

public class ResourceCollection {
//A structure referencing all assets associated with an entity for all possible states.
//This way the game knows what to render for each entity, or what sounds to play, depending on what state it is in. 
	private String CollectionName;
	private ArrayList<Resource> CollectionList = new ArrayList<Resource>();
	
	public ResourceCollection(String name) {
		CollectionName = name;
	}
	
	public void add(Resource resource) {
		CollectionList.add(resource);
	}
	/******** Getters and Setters ********/
	
	// TODO: Error handling on the methods getImageIcon() and getImageIconMask()
	//	If a model does not contain state 'Default', then it will get into an infinite loop
	public Image getImageIcon(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state) {  
				return i.getTexture();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return getImageIcon("Default");
	}
	
	// TODO: Clean up getImageIconMask() method
	public Image getImageIconMask(String state, Color color, float alpha) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state) {
				ResourceTint rt = new ResourceTint();  
				return rt.getTintedResource(i.getTexture(), Color.red, 0.5f);
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		ResourceTint rt = new ResourceTint();  
		return rt.getTintedResource(getImageIcon("Default"), color, alpha);
	}
	
	public Image getImageIconFromPath(String path) {
		for(Resource i : CollectionList){
			if (i.getTexturePath() == path) {
				return i.getTexture();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not reference resource at '" + path + "'");
		return null;
	}
	
	public String getSoundPath(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state) {
				return i.getSoundPath();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return null;
	}
	
	public boolean getSoundLoops(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state) {
				return i.getSoundLoops();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return false;
	}
	
	public String getTexturePath(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state) {
				return i.getTexturePath();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return null;
	}
	
	public float getImageScale(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state){
				return i.getTextureScale();
			}
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return 0;
	}
	
	public Resource getResource(String state) {
		for(Resource i : CollectionList){
			if (i.getStateName() == state){
				return i;
			}		
		}
		System.out.println("ResourceCollection '" + CollectionName + "' does not have state '" + state + "'");
		return null;
	}
}
