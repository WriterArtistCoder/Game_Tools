package efcm.game_engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Scene {

	public static final long FRAME_RATE = 200;
	protected ArrayList<Sprite> sprites;
	
	private Image image;
	public final int level;
	public final int scene;
	
	public Scene(int level, int scene) {
		try {
			this.image = ImageIO.read(new File("src/efcm/assets/scenes/l"+level+"s"+scene+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.level = level;
		this.scene = scene;
	}

	public void render(Graphics g, ImageObserver observer) {
		g.drawImage(image, 0, 0, Runner.SCENE_WIDTH_PXL*Runner.SCENE_PXL_SCALE, Runner.SCENE_HEIGHT_PXL*Runner.SCENE_PXL_SCALE, observer);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Sprite> getSprites() {
		return (ArrayList<Sprite>) sprites.clone();
	}

	@SuppressWarnings("unchecked")
	public void setSprites(ArrayList<Sprite> sprites) {
		this.sprites = (ArrayList<Sprite>) sprites.clone();
	}

	public void addSprites(ArrayList<Sprite> sprites) {
		this.sprites.addAll(sprites);
	}
	
}
