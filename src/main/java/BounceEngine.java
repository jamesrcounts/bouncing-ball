import java.awt.Dimension;
import java.awt.Point;


public class BounceEngine implements Runnable {

	private Balls parent;

	public BounceEngine(Balls parent) {
		this.parent = parent;
	}

	public void run() {
		int width = this.getParent().getWidth();
		int height = this.getParent().getHeight();
		
		for (Ball ball : this.getParent().getBalls()) {
			int x = AnimationUtils.random(width);
			int y = AnimationUtils.random(height);
			
			Dimension size = ball.getSize();
			if(x + size.width > width){
				x= width - size.width;
			}
			if (y+ size.height > height) {
				y = height - size.height;
			}
			
			ball.setLocation(new Point(x,y));
		}
	}

	public Balls getParent() {
		return parent;
	}


}
