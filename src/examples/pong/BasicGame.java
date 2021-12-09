package examples.pong;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.Game;
import game_tools.GameControlScene;

public class BasicGame implements GameControlScene {
	public static void main(String[] args) {
		new BasicGame();
	}

	Game game = new Game();

	BasicGame() {
		game.setScene(this);
		game.start();
	}

	int x = 0;
	int y = 0;

	@Override
	public void draw(Graphics g) {
		g.fillRect(x++, y++, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}
}
