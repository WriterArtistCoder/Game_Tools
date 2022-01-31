package efcm.game_engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Character extends Sprite {

	protected int speed;
	protected Image image; // The source sprite sheet

	public Character(String id) {
		super();
		
		try {
			setImage(ImageIO.read(new File("src/efcm/assets/chars/"+id+".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame = 0;
		setX(2*Runner.SCENE_PXLS_PER_TILE);
		setY(2*Runner.SCENE_PXLS_PER_TILE);
		setWidth(12);
		setHeight(24);
	}
	
	/**
	 * Moves the character to a certain position, using the walking animation.
	 * This recieves the coordinates with a unit of tiles.
	 * @param x X position in tiles
	 * @param y Y position in tiles
	 */
	public void walkTo(int x, int y, Graphics g, ImageObserver observer) {
		for (int cx = getX(); cx < x*Runner.SCENE_PXLS_PER_TILE; cx+=5) {
			setX(cx);
			setFrame(getFrame()+1);
			super.render(g, observer);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actOn(Action action, Sprite reciever) {

	}

	@Override
	public void recieve(Action action, Sprite actor) {

	}

}
