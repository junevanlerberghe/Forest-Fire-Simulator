import java.util.Arrays;

public class Forest {
	
	private static Tree[][] currentState;
	private static Tree[][] nextState;
	
	public static int width;
	public static int height;
	private static double treeDensity;
	private static int numTrees;
	
	public Forest(int r, int c, double d) {
		width = c;
		height = r;
		treeDensity = d;
		numTrees = (int) (r*c*d);
		
		currentState = new Tree[r][c];
		nextState = new Tree[r][c];
		initializeCurrentTrees();
		nextState = currentState;
	}
	
	public void copyArray(Tree[][] array1, Tree[][] array2) {	
		for (int r = 0; r < array1.length; r++) {
			for (int c = 0; c < array1[0].length; c++) {
				array1[r][c] = array2[r][c];
			}
		}
	}

	public void doOneStep() {
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				if (currentState[r][c] != null) {
					currentState[r][c].update(this, r, c);
				}
			}
		}
		copyArray(currentState, nextState);
	}
	
	public void initializeCurrentTrees() {
		for (int i = numTrees; i >= 1; i-- ) {		
			Tree.putTreeInRandomPosition(this, Tree.getRandomTree());		
		}
	}
	
	public int countTreesOfState(int state) {
		int count = 0;
		for (int row = 0; row < currentState[0].length; row++) {
			for (int col = 0; col < currentState.length; col++) {
				Tree tree = currentState[row][col];
				if (tree != null && tree.getCurrentState() == state)
					count++;
			}
		}	
		return count;
	}
	
	public double percentBurned() {
		int numOriginalTrees = (int)(width*height*treeDensity);
		return (countTreesOfState(Tree.ASH)/numOriginalTrees)*100;
	}
	
	public Tree[][] getCurrentState() {
		return currentState;
	}
	
	public Tree[][] getNextState() {
		return currentState;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tree getObjectAt(int r, int c) {
		if ( r < currentState.length && r >= 0 && c >= 0 && c < currentState[0].length) {
			return currentState[r][c];
		}
		else return null;
	}

	public Tree[][] getGrid() {
		return currentState;
	}

}
