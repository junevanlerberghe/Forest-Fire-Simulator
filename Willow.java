
public class Willow extends Tree{
	  private static int moisture = 5;

	  public Willow() {
	    currentState = GREEN;
	  }

	  @Override
	  public void update(Forest f, int r, int c) {
		  if (f.getObjectAt(r, c).getCurrentState() == Tree.FIRE)
		      this.BURNING_TIME--;
		    if ((f.getObjectAt(r - 1, c) != null && (f.getObjectAt(r - 1, c).getCurrentState() == Tree.FIRE)
		        || (f.getObjectAt(r + 1, c) != null && f.getObjectAt(r + 1, c).getCurrentState() == Tree.FIRE)
		        || (f.getObjectAt(r , c - 1) != null && f.getObjectAt(r , c - 1).getCurrentState() == Tree.FIRE)
		        || (f.getObjectAt(r, c + 1) != null && f.getObjectAt(r, c + 1).getCurrentState() == Tree.FIRE))) {
		      f.getObjectAt(r, c).setCurrentState(Tree.FIRE);
		    }
		    if (this.BURNING_TIME <= 0) {
		      currentState = ASH;
		    }
	  }

	  @Override
	  public int getBurningTime() {
	    return 2 * moisture + 1;
	  }

	}

