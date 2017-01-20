package com.kivimango.spacefighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * KeyListener for the Game.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=MAYrRb4lZ7Y">Java Game Development #7 - Keyboard Input </a>
 */

public class KeyInput extends KeyAdapter {

	Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}
}
