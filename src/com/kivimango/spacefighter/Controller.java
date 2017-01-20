package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Controller class for controlling game components like bullets.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Controller {
	
	LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	Bullet tempBullet;
	Game game;
	
	public Controller(Game game) {
		this.game = game;
	}
	
	public void tick() {
		for(int i=0; i<bullets.size(); i++) {
			tempBullet = bullets.get(i);
			
			if(tempBullet.getY() < 0) {
				removeBullet(tempBullet);
			}
			
			tempBullet.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<bullets.size(); i++) {
			tempBullet = bullets.get(i);
			
			tempBullet.render(g);
		}
	}
	
	public void addBullet(Bullet block) {
		bullets.add(block);
	}
	
	public void removeBullet(Bullet block) {
		bullets.remove(block);
	}

}
