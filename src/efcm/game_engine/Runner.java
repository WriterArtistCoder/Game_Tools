package efcm.game_engine;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	
	public static final int SCENE_WIDTH_PXL = 96;
	public static final int SCENE_HEIGHT_PXL = 72;
	
	public static final int SCENE_PXLS_PER_TILE = 12;
	public static final int SCENE_PXL_SCALE = 7;

	public class MyGraphics extends JComponent {

		private static final long serialVersionUID = 1L;

		MyGraphics() {
			setPreferredSize(new Dimension(SCENE_WIDTH_PXL*SCENE_PXL_SCALE, SCENE_HEIGHT_PXL*SCENE_PXL_SCALE));
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Scene s = new Scene(1, 1);
			s.render(g, getFocusCycleRootAncestor());
			
			Character c = new Character("guard-maria-zurita");
			c.render(g, getFocusCycleRootAncestor());

			c.walkTo(5*Runner.SCENE_PXLS_PER_TILE, 5*Runner.SCENE_PXLS_PER_TILE, g, getFocusCycleRootAncestor());
		}
	}

	public void createGUI() {
		final JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(new MyGraphics());
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Runner GUI = new Runner();
				GUI.createGUI();
			}
		});
	}
}
