import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Ball {

	private Point location;
	private Color color;
	private Dimension size;

	public Ball(Color color) {
		this.color = color;
		this.location = new Point(100, 100);
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

	private Point getLocation() {
		return this.location;
	}

	public void setLocation(Point point) {
		this.location = point;
	}
}