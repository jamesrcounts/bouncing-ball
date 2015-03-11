import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import javax.swing.SwingUtilities;

public class BounceEngine implements Runnable {

	private Balls parent;

	public BounceEngine(Balls parent) {
		this.parent = parent;
	}

	public void run() {
		final Balls ballContainer = this.getParent();
		randomizePositions(ballContainer.getWidth(), ballContainer.getHeight(),
				ballContainer.getBalls());

		while (ballContainer.isVisible()) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					ballContainer.repaint();
				}
			});

			for (Ball ball : ballContainer.getBalls()) {
				ball.move(ballContainer.getWidth(), ballContainer.getHeight());
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
		}
	}

	public static void randomizePositions(int width, int height, List<Ball> balls) {
		for (Ball ball : balls) {
			int x = AnimationUtils.random(width);
			int y = AnimationUtils.random(height);

			Dimension size = ball.getSize();
			if (x + size.width > width) {
				x = width - size.width;
			}
			if (y + size.height > height) {
				y = height - size.height;
			}

			ball.setLocation(new Point(x, y));
		}
	}

	public Balls getParent() {
		return parent;
	}

}
