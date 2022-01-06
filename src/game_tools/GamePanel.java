
package game_tools;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
class GamePanel extends JPanel implements ActionListener {
	private GameScene gameScene;
	public static final int DEFAULT_SIZE = 500;
	private Timer time = new Timer(1000 / 30, this);

	public GamePanel(GameScene game) {
		this.gameScene = game;
	}

	public GamePanel() {
	}

	public void start() {
		time.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		gameScene.draw(g);
	}

	public void setGameScene(GameScene gameScene) {
		this.gameScene = gameScene;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
