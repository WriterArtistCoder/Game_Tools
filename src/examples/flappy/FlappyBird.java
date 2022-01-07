package examples.flappy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game_tools.Animation;
import game_tools.Game;
import game_tools.GameControlScene;
import game_tools.Sprite;

public class FlappyBird implements GameControlScene {
	float x = 100;
	float y = 0;
	int pipeX = 500;
	float velocity = 1;
	public static final int GRAVITY = 1;
	Game game = new Game();
	Animation animation;

	public FlappyBird() {
		animation = new Animation();
		game.setScene(this);
		game.start();
		for (int i = 0; i < 6; i++) {
			animation.add(new Sprite("/examples/flappy/bird" + i + ".png"));
		}
	}

	@Override
	public void draw(Graphics g) {
		// draw background
		g.setColor(new Color(100, 150, 230));
		g.fillRect(0, 0, game.screenWidth, game.screenHeight);

		// draw bird
		drawBird(g);
		drawPipes(g);

		// physics
		pipeX -= 2;
		y -= velocity;
		velocity -= GRAVITY;

	}

	public void drawPipes(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(pipeX, 0, 50, 200);
	}

	public void drawBird(Graphics g) {
		animation.draw(g, (int) x, (int) y, 100, 100);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		velocity = 10;
	}
}
