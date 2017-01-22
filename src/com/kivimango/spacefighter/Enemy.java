package com.kivimango.spacefighter;

import java.awt.Graphics;

/**
 * Enemy class storing data of a particular enemy.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=hJ2wXMQ9Wfk">Java Game Development #12 - Adding Enemies</a>
 */

public class Enemy implements EntityInterface {
	
	private double x, y;
	private Textures texture;
	
	public Enemy(double x, double y, Textures texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public void tick() {
		y += 5;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.enemySprite, (int)x, (int)y, null);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}
}
