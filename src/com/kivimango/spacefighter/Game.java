package com.kivimango.spacefighter;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * Implementation of a 2D Space Fighter Game in JAVA.The code is based on RealTutsGML's 'Java Game Development' 
 * series on Youtube.
 * 
 * Game Mechanism : The player can control a spaceship via keyboard to shoot enemies down.
 * 
 * @author RealTutsGML
 * @link https://www.youtube.com/channel/UCOs7Q7IeuzgRyARaEqif75A
 * @see <a href="https://www.youtube.com/watch?v=hXImR8Wm53M">Java Game Development #1 - Starting up our Project</a>
 */

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -7654654228944009721L;
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public static final String GAME_TITLE = "Defender of Tau-3 : A 2D Space Game";
	
	private boolean running;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet;
	private BufferedImage bulletSpriteSheet;
	private BufferedImage enemySpriteSheet;
	private BufferedImage backgroundImage;
	
	private Player player;
	private Controller controller;
	private Textures textures;
	
	public void init() {
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try {
			spriteSheet = loader.loadImage("/spritesheet/player.png");
			bulletSpriteSheet = loader.loadImage("/spritesheet/M484BulletCollection1.png");
			enemySpriteSheet = loader.loadImage("/spritesheet/enemy.png");
			backgroundImage = loader.loadImage("/background/starfield.png");
			
			addKeyListener(new KeyInput(this));
			
			textures = new Textures(this);
			
			player = new Player(200, 200, textures);
			controller = new Controller(this, textures);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Spawning a new thread with checking if the game is already started.
	 * You can't start a thread twice, it doesn't make any sense.
	 * @see <a href="http://www.javaworld.com/article/2077138/java-concurrency/introduction-to-java-threads.html">Introduction to Java threads</a>
	 * @see <a href="https://www.tutorialspoint.com/java/java_multithreading.htm">Java - Multithreading</a>
	 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html">Thread (Java Platform SE 7 )</a>
	 */
	
	private synchronized void start()  {
		if(running) 
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * Stopping the running thread, (if there is any) and quitting from the program with the code 0.
	 * @see <a href="http://stackoverflow.com/questions/2434592/difference-in-system-exit0-system-exit-1-system-exit1-in-java">System exit codes</a>
	 */
	
	private synchronized void stop()  {
		if(!running) 
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		
		// The game will run in 60 FPS
		final double amountOfTicks = 60.0;
		double nanoSeconds = 1000000000 / amountOfTicks;
		double delta = 0;
		
		// FPS measuring related variables
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		/** The game loop itself.The code in this block will be executed until the conditions met, eg: user closes the program,
		 * the player wins or dies, etc.The game will be updated 60x times in one second.
		 * In this way, we make sure the game will run on the same speed on every PC 
		 * (the problem is, the machines computes too fast, so the game would be run by 150 billion FPS...
		 * we don't want that, thats why we have to update 60x in one second)
		 */
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoSeconds;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("Ticks: " + updates + " FPS: " + frames);
				updates = 0;
				frames = 0;
			}
		}
		
		stop();
	}
	
	private void tick() {
		player.tick();
		controller.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null ) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(backgroundImage, 0, 0, this);
		
		player.render(g);
		controller.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
			case KeyEvent.VK_RIGHT : player.setVelX(5); break;
			case KeyEvent.VK_LEFT : player.setVelX(-5); break;
			case KeyEvent.VK_DOWN : player.setVelY(5); break;
			case KeyEvent.VK_UP : player.setVelY(-5); break;
		}
		// prevent form the player to shoot endless stream of bullets
		if(key == KeyEvent.VK_SPACE && !player.isShooting()) {
			player.setShooting(true);
			controller.addBullet(new Bullet(player.getX(), player.getY()-25, textures));
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
			case KeyEvent.VK_RIGHT : player.setVelX(0); break;
			case KeyEvent.VK_LEFT : player.setVelX(0); break;
			case KeyEvent.VK_DOWN : player.setVelY(0); break;
			case KeyEvent.VK_UP : player.setVelY(0); break;
			// forcing the player to release the SPACE key to able to shoot again
			case KeyEvent.VK_SPACE : player.setShooting(false); break;
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		initGameWindow(game);
	}

	public static void initGameWindow(Game game) {
		JFrame frame = new JFrame(GAME_TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}
	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	
	public BufferedImage getBulletSpriteSheet() {
		return bulletSpriteSheet;
	}
	
	public BufferedImage getEnemySpriteSheet() {
		return enemySpriteSheet;
	}

}
