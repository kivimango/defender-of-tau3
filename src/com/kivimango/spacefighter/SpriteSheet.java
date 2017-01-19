package com.kivimango.spacefighter;

import java.awt.image.BufferedImage;

/**
 * Loading a sprite from a sprite sheet.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=hXImR8Wm53M">Java Game Development #1 - Starting up our Project</a>
 * @see <a href="https://www.youtube.com/watch?v=jedilHUPO7c">Java Game Development #5 - Sprite Sheets</a>
 * @see <a href="https://www.codeandweb.com/what-is-a-sprite-sheet">What is a sprite sheet?</a>
 */

public class SpriteSheet {
	
	private BufferedImage image;
	private final int SPRITE_WIDTH = 32;
	
	public SpriteSheet(BufferedImage imageFromConstructor) {
		this.image = imageFromConstructor;
	}
	
	/**
	 * Grabbing a sub image (a.k.a the sprite) from a sprite sheet.
	 * 
	 * @param col Column number of the sub image in the sprite sheet.
	 * @param row Row number of the sub image in the sprite sheet.
	 * @param width Width of the sub image in the sprite sheet in pixels.
	 * @param height Height of the sub image in the sprite sheet in pixels.
	 * @return The grabbed sub image. 
	 */
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage sprite = image.getSubimage((col * SPRITE_WIDTH) - SPRITE_WIDTH, (row * SPRITE_WIDTH) - SPRITE_WIDTH, width, height);
		return sprite;
	}

}