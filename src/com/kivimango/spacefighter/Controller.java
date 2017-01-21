package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Controller class for controlling game components like bullets, enemies.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Controller {
	
	private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private Bullet tempBullet;
	private Enemy tempEnemy;
	
	public Controller(Game game, Textures textures) {
		
		
		for(int x=0; x<(Game.WIDTH * Game.SCALE); x+=64) {
			addEnemy(new Enemy(x, 0, textures));
		}
	}
	
	public void tick() {
		for(int i=0; i<bullets.size(); i++) {
			tempBullet = bullets.get(i);
			
			if(tempBullet.getY() < 0) {
				removeBullet(tempBullet);
			}
			
			tempBullet.tick();
		}
		
		for(int i=0; i<enemies.size(); i++) {
			tempEnemy = enemies.get(i);
			tempEnemy.tick();
		}
	}
	
	public void render(Graphics g) {
		// Rendering player bullets...
		for(int i=0; i<bullets.size(); i++) {
			tempBullet = bullets.get(i);
			
			tempBullet.render(g);
		}
		
		// Rendering enemies...
		for(int i=0; i<enemies.size(); i++) {
			tempEnemy = enemies.get(i);
			
			tempEnemy.render(g);
		}
	}
	
	public void addBullet(Bullet block) {
		bullets.add(block);
	}
	
	public void removeBullet(Bullet block) {
		bullets.remove(block);
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}

}
