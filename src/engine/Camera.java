package engine;

import java.awt.Point;

import entities.AbstractEntity;

/**
 * Class Camera provides values to offset rendering.
 * Camera will smoothly position itself to a given Entity or Point.
 */

public class Camera {
	protected Point position;
	protected double OFFSETX = 1920/2; // Offset camera to center on X axis
	protected double OFFSETY = 1080/2; // Offset camera to center on Y axis
	
	protected AbstractEntity focusEntity; // The camera will follow this entity
	protected Point focusPoint;	// The camera will move to this point
	
	public Camera() {
		this.position = new Point(0,0);
		this.focusEntity = null;
		this.focusPoint = null;
	}

	/*
	 * Return the X-axis offset so that drawing is centered around the camera position
	 */
	public double getX() {
		return position.getX() - OFFSETX;
	}

	/*
	 * Return the Y-axis offset so that drawing is centered around the camera position
	 */
	public double getY() {
		return position.getY() - OFFSETY;
	}
	
	/*
	 * Calculate the next position of the Camera 
	 */
	public void updateCamera() {
		// For now, the camera will only focus on entities
		if(focusEntity != null) {
			// TODO: Smooth Camera Algorithm
			position = focusEntity.getPosition();
		}
	}
	
	/******** Getters and Setters ********/
	
	public AbstractEntity getFocusEntity() {
		return focusEntity;
	}

	public void setFocusEntity(AbstractEntity focusOn) {
		this.focusEntity = focusOn;
	}

	public Point getFocusPoint() {
		return focusPoint;
	}

	public void setFocusPoint(Point focusPoint) {
		this.focusPoint = focusPoint;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
