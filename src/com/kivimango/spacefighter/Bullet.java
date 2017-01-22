package com.kivimango.spacefighter;

import java.awt.Graphics;

/**
 * Bullet class storing data of a particular bullet.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Bullet implements EntityInterface {
	
	private double x;
	private double y;
	private Textures texture;
	
	public Bullet(double x, double y, Textures texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public void tick() {
		y -= 10;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.bulletSprite, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

}
