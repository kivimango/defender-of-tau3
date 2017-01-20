package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Bullet class storing data of a particular bullet.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Bullet {
	
	private double x;
	private double y;
	BufferedImage bulletSprite;
	
	public Bullet(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		// TO-DO: FIX: every new instance of a bullet will load the sprite again
		SpriteSheet ss = new SpriteSheet(game.getBulletSpriteSheet());
		bulletSprite = ss.grabImage(1, 1, 20, 20);
	}
	
	public void tick() {
		y -= 10;
	}
	
	public void render(Graphics g) {
		g.drawImage(bulletSprite, (int)x, (int)y, null);
	}
	
	public double getY() {
		return y;
	}

}
