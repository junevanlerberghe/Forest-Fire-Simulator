
public class Simulator {
	
	private int r;
	private int c;
	private Forest forest;
	/***
	 * Create a new simulator.  The simulator creates a new Forest of size (r, c).
	 * 
	 * @param r
	 * @param c
	 */
	public Simulator(int r, int c, double density) {
		forest = new Forest(r, c, density);
		this.r = r;
		this.c = c;
	}
	
	public Forest getForest() {
		return forest;
	}
		
	public double getAveragePercentBurned(int width, int height, double density, int trials) {
		double sum = 0;
		for (int i = 0; i < trials; i++) {	
			forest.doOneStep();
			sum += forest.percentBurned();
		}
		return sum / trials;
	}
	
	public void setRandomFire() {
		boolean onFire = false;			
		while (!onFire) {
			int randRow = (int)(Math.random()*forest.getHeight());
			int randCol = (int)(Math.random()*forest.getWidth());
			if (forest.getObjectAt(randRow, randCol) != null) {
				forest.getObjectAt(randRow, randCol).setCurrentState(Tree.FIRE);
				onFire = true;
			}
		}
	}

	public void runOneStep() {
		forest.doOneStep();
	}
	
	public void run() {
		boolean isOver = false;
		while (!isOver) {
			runOneStep();
			isOver = true;
			for (int r = 0; r < forest.getHeight(); r++) {
				for (int c = 0; c < forest.getWidth(); c++) {
					if (forest.getGrid()[r][c] != null && forest.getGrid()[r][c].getCurrentState() == Tree.FIRE) 
						isOver = false;
				}
			}
		}	
	}

	public void reset() {
		forest.initializeCurrentTrees();
	}
}