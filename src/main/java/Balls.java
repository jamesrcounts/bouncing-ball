import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class Balls extends JPanel{
	
	private static final long serialVersionUID = -4821100110829484902L;
	private ArrayList<Ball> ballsUp;

	public Balls() {
		this.ballsUp = new ArrayList<Ball>(25);
		for (int i = 0; i < 10 + AnimationUtils.random(90); i++) {
			Color color = new Color(AnimationUtils.random(255), AnimationUtils.random(255), AnimationUtils.random(255));
			ballsUp.add(new Ball(color));
		}
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (Ball ball : ballsUp) {
			ball.paint(g2d);
		}
		
		g2d.dispose();
	}

	public List<Ball> getBalls() {
		return new ArrayList<Ball>(this.ballsUp);
	}
}