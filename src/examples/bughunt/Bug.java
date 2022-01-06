package examples.bughunt;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import game_tools.Animation;
import game_tools.Sprite;

public class Bug {
	Animation anim;
	Location location = new Location(0, 0);
	Location target;
	double vx;
	double vy;
	int width;
	int height;
	boolean isEscaping = false;
	boolean isActing = true;

	Bug(int size) {
		width = size;
		height = size;
		anim = new Animation();
		location = BugHunt.getRandomEdgeLocation();
		if(location.x == 0) location.x = -size;
		if(location.y == 0) location.y = -size;
		
		target = BugHunt.getRandomLocation();

		while (location.getDistanceTo(target) < 100)
			target = BugHunt.getRandomLocation();
		vx = (target.x - location.x) / 100;
		vy = (target.y - location.y) / 100;

		for (int i = 0; i < 8; i++) {
			anim.add(new Sprite("/examples/bughunt/bug/Bug" + i + ".png"));
		}
	}

	void draw(Graphics g) {
		if(isActing) move();

		anim.draw(g, location.x, location.y, width, height);
		if (BugHunt.debug) {
			if (isEscaping)
				g.setColor(Color.RED);
			else
				g.setColor(Color.GREEN);
			g.drawOval(location.x, location.y, width, height);
		}
	}

	void move() {
		int dx = getSkewedIntFromRange(target.x, location.x, 8);
		int dy = getSkewedIntFromRange(target.y, location.y, 8);
		vx = (vx + dx) * 0.9;
		vy = (vy + dy) * 0.9;
		location.x += vx;
		location.y += vy;

		if (location.getDistanceTo(target) < 30) {
			if (isEscaping) {
				BugHunt.bugEscapes(this);
			} else {
				isEscaping = true;
				while (location.getDistanceTo(target) < 400)
					target = BugHunt.getRandomEdgeLocation();
				if (target.x == 0)
					target.x = -100;
				if (target.x == BugHunt.game.screenWidth)
					target.x = BugHunt.game.screenWidth + 50;
				if (target.y == 0)
					target.x = -100;
				if (target.y == BugHunt.game.screenHeight)
					target.y = BugHunt.game.screenHeight + 50;
			}

		}
	}

	int getSkewedIntFromRange(int r1, int r2, int size) {
		int dr = r1 - r2;
		int d = 0;
		if (dr > 0) {
			d = (int) (BugHunt.gen.nextInt(size) - (size * 0.3));
		} else if (dr < 0) {
			d = (int) (BugHunt.gen.nextInt(size) - (size * 0.7));
		} else {
			d = (int) (BugHunt.gen.nextInt(size) - (size * 0.5));
		}
		return d;
	}

	boolean wasClicked(int x, int y) {
		int cx = location.x + (width / 2);
		int cy = location.y + (height / 2);
		Location center = new Location(cx, cy);
		int dist = (int) center.getDistanceTo(x, y);
		
		if (dist < width / 2)
			return true;
		else
			return false;
	}

	void die() {

	}
}
