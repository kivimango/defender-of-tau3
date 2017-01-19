package com.kivimango.spacefighter;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Loading a sprite sheet from image file.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=hXImR8Wm53M">Java Game Development #1 - Starting up our Project</a>
 * @see <a href="https://www.youtube.com/watch?v=jedilHUPO7c">Java Game Development #5 - Sprite Sheets</a>
 * @see <a href="https://www.codeandweb.com/what-is-a-sprite-sheet">What is a sprite sheet?</a>
 */

public class BufferedImageLoader {
	
	private BufferedImage spriteSheet;
	/** 
	 * Loading a sprite sheet from image file.
	 * @param path
	 * @return
	 * @throws IOException Theres ia a possibility that the file didnt exists, in this case we throw a new IOException,
	 * which we will catch in the Game class, and give an error message to the user.
	 */
	
	public BufferedImage loadImage(String path) throws IOException {
		spriteSheet = ImageIO.read(getClass().getResource(path));
		return spriteSheet;
	}

}
