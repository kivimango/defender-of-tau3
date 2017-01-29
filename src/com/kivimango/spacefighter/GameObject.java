package com.kivimango.spacefighter;

/**
 * The basic game object that the other objects of the game will extends.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=BTDcR4smi5A">Java Game Development #16 - Collision Detection</a>
 */

public class GameObject {
	
	protected double x, y;

	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
}