package com.kivimango.spacefighter;

import java.awt.image.BufferedImage;

/**
 * Storing and loading textures (sorites) from the spritesheets. 
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=hJ2wXMQ9Wfk">Java Game Development #12 - Adding Enemies</a>
 */

public class Textures {
	
	private SpriteSheet spriteSheet;
	private SpriteSheet bulletSpriteSheet;
	private SpriteSheet enemySpriteSheet;
	public BufferedImage playerSprite, bulletSprite, enemySprite;
	
	public Textures(Game game) {
		 spriteSheet = new SpriteSheet(game.getSpriteSheet());
		 bulletSpriteSheet = new SpriteSheet(game.getBulletSpriteSheet());
		 enemySpriteSheet = new SpriteSheet(game.getEnemySpriteSheet());
		 
		 getTextures();
	}
	
	private void getTextures() {
		playerSprite = spriteSheet.grabImage(1, 1, 29, 64);
		bulletSprite = bulletSpriteSheet.grabImage(1, 1, 20, 20);
		enemySprite = enemySpriteSheet.grabImage(1, 1, 40, 30);
	}
	
}