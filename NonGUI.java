public class NonGUI {
	public static void main(String[] args) {
				
		// A non-graphical runner for doing a lot
		// of simulations and displaying the results

		// You'd run this if you wanted to run, say 1000 trials for
		// a set of initial conditions and see the results.
		
		
		for (double i = 0.05; i <= 1; i = i + 0.05) {
			Simulator sim = new Simulator(100, 100, i);
			System.out.println(sim.getAveragePercentBurned(100, 100, i, 100));
			//System.out.println(i);
		}
		
		
	}
}
