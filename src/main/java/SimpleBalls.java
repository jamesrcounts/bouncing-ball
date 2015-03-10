import java.awt.EventQueue;

public class SimpleBalls {
	public static void main(String[] args) {
		new SimpleBalls();
	}

	public SimpleBalls() {
		Runnable runnable = new BallSimulation();
		EventQueue.invokeLater(runnable);
	}
}
