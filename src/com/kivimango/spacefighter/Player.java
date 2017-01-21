package com.kivimango.spacefighter;

import java.awt.Graphics;

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
	private Textures texture;
	private boolean shooting = false;
	
	public Player(double x, double y, Textures texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public void tick() {
		x+=velX;
		y+=velY;
			
		// Basic collision bounds : the player can't go out from the game window
		// On the right side of the window (X axis), we have to subtract the width of the player sprite from the actual window width
		// On the bottom of the window (Y axis), we have to subtract the height of the player sprite from the actual window height
		
		if(x < 0) {
			x = 0;
		}
		if(x >= 640-20) {
			x = 640-20;
		}
		if(y <= 0) {
			y = 0;
		}
		if(y >= 480-60) {
			y = 480-60;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(texture.playerSprite, (int)x, (int)y, null);
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

	public boolean isShooting() {
		return shooting;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}
}
