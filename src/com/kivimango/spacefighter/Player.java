package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Player class storing player data.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=oyWyo6fdGRo">Java Game Development #6 - Player Class</a>
 */

public class Player {
	
	private double x;
	private double y;
	private double velX;
	private double velY;
	private BufferedImage playerSprite;
	
	public Player(double x, double y, Game game) {
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		playerSprite = ss.grabImage(1, 1, 29, 64);
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
	}
	
	public void render(Graphics g) {
		g.drawImage(playerSprite, (int)x, (int)y, null);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}
}
