import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Ball {

	private Point location;
	private Color color;
	private Dimension size;
	private Point speed;

	public Ball(Color color) {
		this.color = color;
		this.location = new Point(100, 100);
		this.speed = new Point(10 - AnimationUtils.random(20),
				10 - AnimationUtils.random(20));
		this.size = new Dimension(30, 30);
	}

	public void paint(Graphics2D g2d) {
		Point p = this.getLocation();
		if (p != null) {
			g2d.setColor(this.getColor());
			Dimension size = this.getSize();
			g2d.fillOval(p.x, p.y, size.width, size.height);
		}

	}

	public Dimension getSize() {
		return this.size;
	}

	private Color getColor() {
		return this.color;
	}

	public Point getLocation() {
		return this.location;
	}

	public void setLocation(Point point) {
		this.location = point;
	}

	public Point getSpeed() {
		return this.speed;
	}

	public void setSpeed(Point speed) {
		this.speed = speed;
	}

	public void move(int width, int height) {
		Point point = this.getLocation();
		Point speed = this.getSpeed();
		Dimension size = this.getSize();

		int vx = speed.x;
		int vy = speed.y;

		int x = point.x;
		int y = point.y;

		// bounce
		// 0 is the left border
		// x + width is the right border
		// if movement would take the ball past these boundaries
		// change direction
		if (x + vx < 0 || x + size.width + vx > width) {
			vx *= -1; // change direction on the x axis
		}

		if (y + vy < 0 || y + size.height + vy > height) {
			vy *= -1; // change direction on the y axis
		}
		this.setSpeed(new Point(vx, vy));

		// relocate
		x += vx;
		y += vy;
		this.setLocation(new Point(x, y));
	}
}