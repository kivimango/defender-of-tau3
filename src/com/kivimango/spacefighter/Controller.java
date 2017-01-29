package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.kivimango.spacefighter.entities.BulletEntity;
import com.kivimango.spacefighter.entities.EnemyEntity;

/**
 * Controller class for controlling game components like bullets, enemies.
 * These components must implement the EntityInterface.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Controller {
	
	private LinkedList<BulletEntity> bullets = new LinkedList<BulletEntity>();
	private LinkedList<EnemyEntity> enemies = new LinkedList<EnemyEntity>();
	
	Random randomNumberGenerator = new Random();
	Textures texture;
	
	public Controller(Textures textures) {
		this.texture = textures;
	}
	
	public void createEnemy(int enemyCount) {
		for(int i=0; i<enemyCount; i++) {
			addEnemy(new Enemy(randomNumberGenerator.nextInt(640), -10, texture));
		}
	}
	
	public void tick() {
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).tick();
		}
		
		for(int i=0; i<enemies.size(); i++) {
			enemies.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<bullets.size(); i++) {
			bullets.get(i).render(g);
		}
		
		for(int i=0; i<enemies.size(); i++) {
			enemies.get(i).render(g);
		}
	}
	
	public void addBullet(BulletEntity b) {
		bullets.add(b);
	}
	
	public void removeBullet(BulletEntity b) {
		bullets.remove(b);
	}
	
	public void addEnemy(EnemyEntity e) {
		enemies.add(e);
	}
	
	public void removeEnemy(EnemyEntity e) {
		enemies.remove(e);
	}
	
	public LinkedList<BulletEntity> getBullets() {
		return bullets;
	}
	
	public LinkedList<EnemyEntity> getEnemies() {
		return enemies;
	}
}
