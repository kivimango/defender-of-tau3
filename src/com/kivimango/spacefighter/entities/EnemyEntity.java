package com.kivimango.spacefighter.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=BTDcR4smi5A">Java Game Development #16 - Collision Detection</a>
 */

public interface EnemyEntity {
	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	public double getX();
	public double getY();
}
