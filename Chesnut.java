
public class Chesnut extends Tree{
	private double BURN_PROBABILITY = 0.9;

	  public Chesnut() {
	    currentState = GREEN;
	    BURNING_TIME = 8;
	  }

	  @Override
	  public void update(Forest f, int r, int c) {
	    if (f.getObjectAt(r, c).getCurrentState() == Tree.FIRE)
	      this.BURNING_TIME--;
	    
	    double rand = Math.random();
	    if (rand < BURN_PROBABILITY) {
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
