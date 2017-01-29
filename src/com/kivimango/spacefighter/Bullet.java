package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.kivimango.spacefighter.entities.BulletEntity;

/**
 * Bullet class storing data of a particular bullet.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Bullet extends GameObject implements BulletEntity {
	
	private Textures texture;
	private Game game;
	
	public Bullet(double x, double y, Textures texture, Game game) {
		super(x,y);
		this.texture = texture;
		this.game = game;
	}
	
	public void tick() {
		y -= 10;
		if(Physics.isCollided(this, game.enemies)) {
			System.out.println("COLLISION DETECTED");
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.bulletSprite, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, texture.bulletSprite.getWidth(), texture.bulletSprite.getWidth());
	}
	
	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

}
