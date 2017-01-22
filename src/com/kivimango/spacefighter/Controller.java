package com.kivimango.spacefighter;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 * Controller class for controlling game components like bullets, enemies.
 * These components must implement the EntityInterface.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=FjTDgspqIBo">Java Game Development #10 - Shooting Bullets!</a>
 */

public class Controller {
	
	private LinkedList<EntityInterface> entities = new LinkedList<EntityInterface>();
	private EntityInterface ent;
	Random randomNumberGenerator = new Random();
	Textures texture;
	
	public Controller(Textures textures) {
		this.texture = textures;
	}
	
	public void createEnemy(int enemyCount) {
		for(int i=0; i<enemyCount; i++) {
			addEntity(new Enemy(randomNumberGenerator.nextInt(640), -10, texture));
		}
	}
	
	public void tick() {
		for(int i=0; i<entities.size(); i++) {
			ent = entities.get(i);
			ent.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<entities.size(); i++) {
			ent = entities.get(i);
			ent.render(g);
		}
	}
	
	public void addEntity(EntityInterface block) {
		entities.add(block);
	}
	
	public void removeEntity(EntityInterface block) {
		entities.remove(block);
	}
}
