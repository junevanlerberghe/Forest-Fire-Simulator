
public class Maple extends Tree{
	
	  public Maple() {
		    currentState = GREEN;
		    BURNING_TIME = 3;
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
		    return BURNING_TIME;
		  }

}
