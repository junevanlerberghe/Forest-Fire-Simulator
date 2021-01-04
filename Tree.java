
public abstract class Tree {
	
	  protected int currentState;
	  public static final int GREEN = 0;
	  public static final int FIRE = 1;
	  public static final int ASH = 2;
	  protected int BURNING_TIME;

	  public Tree() {
	    currentState = GREEN;
	  }

	  public void initialize() {
	    currentState = GREEN;
	  }
	  
	  public static void putTreeInRandomPosition(Forest f, Tree t) {
		  int row = 0;
			int col = 0;
			do {
				row = (int)(Math.random() * f.height);
				col = (int)(Math.random() * f.width);
			} while(f.getObjectAt(row, col) != null);
			
			f.getGrid()[row][col] = t;
	  }
	  
	  public static Tree getRandomTree() {
		  int rand = (int) (Math.random() * 1);
	        if (rand == 0)
	          return new Maple();
	        if (rand == 1)
	          return new Willow();
	        if (rand == 2)
	          return new Chesnut();
	        else return null;
	  }

	  public void setOnFire() {
	    currentState = FIRE;
	  }

	  public void burn() {
	    currentState = ASH;
	  }
	  
	  public void setCurrentState(int newState) {
		  currentState = newState;
	  }

	  public int getCurrentState() {
	    return currentState;
	  }

	  public abstract void update(Forest f, int r, int c);

	  public abstract int getBurningTime();
	}
