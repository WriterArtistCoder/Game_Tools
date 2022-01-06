package game_tools;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
	public Controller controller;

	public static final int DEFAULT_SIZE = 500;
	public int screenWidth = DEFAULT_SIZE;
	public int screenHeight = DEFAULT_SIZE;

	private GamePanel gamePanel;
	
	public GameFrame() {
		this.gamePanel = new GamePanel();
		this.setSize(DEFAULT_SIZE, DEFAULT_SIZE);
		this.add(gamePanel);
	}
	
	public GameFrame(String title) {
		this();
		this.setTitle(title);
	}
	/**
	 * 
	 * @param gamePanel
	 */
	public void add(GamePanel panel) {
		this.add((JPanel) panel);


	}

	@Override
	public void setSize(int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		super.setSize(width, height);
	}

	@Override
	public void setSize(Dimension d) {
		this.screenWidth = d.width;
		this.screenHeight = d.height;
		super.setSize(d);
	}

	public void setResizable(boolean b) {
		super.setResizable(b);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		controller.keyTyped(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (controller != null)
			controller.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (controller != null)
			controller.keyReleased(e);
	}

	/**
	 * Add your game's keyPress
	 * 
	 * @param keyPress
	 */
	public void addController(Controller controller) {
		this.controller = controller;
		addControls();
	}

	private void addControls() {
		this.addKeyListener(controller);
		this.addMouseListener(controller);
	}

	/**
	 * Set the scene of your game
	 * 
	 * @param GameScene
	 */
	public void setGameScene(GameScene scene) {
		this.gamePanel.setGameScene(scene);
		addControls();
		this.setVisible(true);
	}

	public void setGameScene(GameControlScene gameControlScene) {
		this.gamePanel.setGameScene(gameControlScene);
		this.controller = gameControlScene;
		addControls();
		this.setVisible(true);
	}


	public void start() {
		this.gamePanel.start();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		controller.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		controller.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controller.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		controller.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		controller.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		controller.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		controller.mouseMoved(e);
	}
}
