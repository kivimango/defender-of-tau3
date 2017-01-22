package com.kivimango.spacefighter;

import java.awt.Graphics;

public interface EntityInterface {
	public void tick();
	public void render(Graphics g);
	public double getX();
	public double getY();
}
