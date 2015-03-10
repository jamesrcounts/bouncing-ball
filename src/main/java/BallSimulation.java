import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BallSimulation implements Runnable{

	public void run() {
		 try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (ClassNotFoundException ex) {
         } catch (InstantiationException ex) {
         } catch (IllegalAccessException ex) {
         } catch (UnsupportedLookAndFeelException ex) {
         }
		 
		 JFrame frame = new JFrame("Spot");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLayout(new BorderLayout());
		 Balls balls = new Balls();
		 frame.add(balls);
		 frame.setSize(400, 400);
		 frame.setVisible(true);
		 
		 new Thread(new BounceEngine(balls)).start();
	}

}