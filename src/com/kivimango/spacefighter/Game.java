package com.kivimango.spacefighter;

import java.awt.Canvas;
import java.awt.Dimension;

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
		thread = new Thread();
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
		start();
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
	}

}
