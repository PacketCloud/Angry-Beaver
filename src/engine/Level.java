package engine;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import entities.Entity;

public class Level {
/* Currently one ArrayList. This is the level Singleton which
 * 	will hold a list of all Entities to draw and update on.
 * 	In order to use this class:
 * 		Level level = Level.getInstance();
 */
 
	private ArrayList<Entity> entityList = new ArrayList<Entity>();
    private static Level firstInstance = null;
    
	public static Level getInstance(){
        if(firstInstance == null){
            synchronized(Level.class){
                if(firstInstance == null){
                	firstInstance = new Level ();
                }
            }
        }
        return firstInstance;
    }
	
	public boolean loadLevel(String s) {
		//TODO
		return false;
	}
	public void addEntity(Entity ent) {
		entityList.add(ent);
	}
	
	public void clearLevel() {
		entityList.clear();
	}
	
	//Updates all entities to their correct location/action
	public void updateLevel(){
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).update();
		}
	}
	
	//Draws all entities to Graphics
	public void drawLevel(Graphics g){
		for(int i = 0; i < entityList.size(); i++){
			entityList.get(i).draw(g);
		}
	}
	
	// FOR TESTING
	public void print() {
		if(entityList == null) {
			System.out.println("Empty");
		} else {
			System.out.println("Init");
			System.out.println(entityList.get(0));
		}
	}
	
	
/*
	public static void main(String[] args) {
		Level level = Level.getInstance();
		//Entity ent = new Entity(new Point(0,0), "", "");
		level.addEntity(ent);
		level.print();
		//Level level = new Level();
		Level level2 = Level.getInstance();

		level2.print();	
	}
*/
}
