package examples.bughunt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import game_tools.Game;
import game_tools.GameControlScene;

public class BugHunt implements GameControlScene {
	public static Game game = new Game();
	public static Random gen = new Random();
	public static boolean gameOver = false;
	static ArrayList<Bug> bugs = new ArrayList<Bug>();
	long frameCount = 0;
	int spawnValue = 3;

	static int score = 0;
	static int highscore = 0;
	static int splats = 0;
	static boolean debug = false;
	Bug gameOverBug;
	Font scoreFont = new Font("arial", Font.PLAIN, 25);
	Font gameOverFont = new Font("arial", Font.BOLD, 50);
	
	public static void main(String[] args) {
		new BugHunt();
	}

	BugHunt() {
		game.setSize(1200, 1000);
		game.setScene(this);
		game.getFrame().setResizable(false);
		bugs.add(new Bug(gen.nextInt(50) + 20));
		gameOverBug = new Bug(200);
		gameOverBug.isActing = false;
		gameOverBug.location.x = game.screenWidth/2 - 100;
		gameOverBug.location.y = game.screenHeight/4;
		game.start();
	}

	@Override
	public void draw(Graphics g) {
		if (!gameOver) {
			setBackgroundColor(g);
			g.fillRect(0, 0, game.screenWidth, game.screenHeight);
			for (int i = bugs.size() - 1; i >= 0; i--) {
				bugs.get(i).draw(g);
			}

			spawnBugs();

			g.setColor(Color.RED);
			g.setFont(scoreFont);
			g.drawString("Life: " + score, 10, 30);
			g.drawString("Score:" + highscore, 10, 55);
			frameCount++;
		} else {
			g.setColor(new Color(40,40,40));
			g.fillRect(0, 0, game.screenWidth, game.screenHeight);
			g.setColor(Color.RED);
			g.setFont(gameOverFont);
			gameOverBug.draw(g);
			g.drawString("GAME OVER", game.screenWidth / 2 - 155, game.screenHeight / 2);
			g.drawString("Score: "+ highscore, game.screenWidth / 2 - 100, game.screenHeight / 2 + 100);
		}
	}

	void setBackgroundColor(Graphics g) {
		int start = 180;
		Color bg = new Color(Math.max(0, start-(splats)),Math.max(0, start-(splats)),Math.max(0, start-(splats)));
		g.setColor(bg);
	}
	void restart() {
		score = 0;
		highscore = 0;
		splats = 0;
		bugs.clear();
		frameCount = 0;
		gameOver = false;
	}

	void spawnBugs() {
		spawnValue = 3 + (splats / 5);

		int guaranteed = spawnValue / 100;
		for (int i = 0; i < guaranteed; i++) {
			bugs.add(new Bug(gen.nextInt(100- (splats/4)) + 40));
		}
		int chance = gen.nextInt(100);
		if (chance < spawnValue % 100) {
			bugs.add(new Bug(gen.nextInt(100- (splats/4)) + 40));
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			restart();
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			gameOver = true;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!gameOver) {
			for (int i = bugs.size() - 1; i >= 0; i--) {
				Bug bug = bugs.get(i);
				if (bug.wasClicked(e.getX() - 8, e.getY() - 32)) {
					bug.die();
					bugs.remove(i);
					score++;
					splats++;
					if (score > highscore)
						highscore = score;
				}
			}
		}
	}

	public static void bugEscapes(Bug bug) {
		bugs.remove(bug);
		score--;
		if (score < 0)
			gameOver = true;
	}


	public static Location getRandomEdgeLocation() {
		Location loc = new Location(0, 0);
		if (BugHunt.gen.nextBoolean()) {
			loc.x = BugHunt.gen.nextInt(2) * game.screenWidth;
			loc.y = BugHunt.gen.nextInt(game.screenHeight);
		} else {
			loc.x = BugHunt.gen.nextInt(game.screenWidth);
			loc.y = BugHunt.gen.nextInt(2) * game.screenHeight;
		}
		return loc;
	}

	public static Location getRandomLocation() {
		return new Location(gen.nextInt(BugHunt.game.screenWidth), gen.nextInt(BugHunt.game.screenHeight));
	}
}
