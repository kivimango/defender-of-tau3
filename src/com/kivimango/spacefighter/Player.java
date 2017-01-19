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
	private BufferedImage playerSprite;
	
	public Player(double x, double y, Game game) {
		super();
		this.x = x;
		this.y = y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		
		playerSprite = ss.grabImage(1, 1, 29, 64);
	}
	
	public void tick() {
		x++;
	}
	
	public void render(Graphics g) {
		g.drawImage(playerSprite, (int)x, (int)y, null);
	}
	
}
