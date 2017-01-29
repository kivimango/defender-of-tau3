package com.kivimango.spacefighter;

import java.util.LinkedList;
import com.kivimango.spacefighter.entities.BulletEntity;
import com.kivimango.spacefighter.entities.EnemyEntity;

/**
 * Basic physics class for the game.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=BTDcR4smi5A">Java Game Development #16 - Collision Detection</a>
 */

public class Physics {
	
	public static boolean isCollided(BulletEntity bullet, LinkedList<EnemyEntity> enemies) {
		for(int i=0; i<enemies.size(); i++) {
			if(bullet.getBounds().intersects(enemies.get(i).getBounds())) {
				return true;
			}
		}
		return false;
	}

}
