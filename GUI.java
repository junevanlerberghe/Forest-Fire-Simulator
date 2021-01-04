import processing.core.*;

public class GUI extends PApplet {
	int c;
	Simulator sim;
	Display display;

	public void setup() {
		size(640, 550); // set the size of the screen.

		// Create a simulator
		sim = new Simulator(100, 100, 0.7);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (620, 530) is the width and height
		display = new Display(this, 10, 10, 620, 530);

		display.setNumCols(100);		// NOTE:  these must match your simulator!!
		display.setNumRows(100);
	
		// Set different grid values to different colors
		// TODO:  uncomment these lines!
		
		display.setColor(Tree.FIRE, color(255, 0, 0)); 
		display.setColor(Tree.ASH, color(170, 170, 170));
		display.setColor(Tree.GREEN, color(0, 255, 0));

		// You can use classes instead, for example:
		// display.setColor(Tree.class, color(0, 255, 0));
		// display.setColor(Ash.class, color(0, 255, 0));
		
		sim.setRandomFire();
		//System.out.println(sim.getForest().getObjectAt(0, 0).getCurrentState());
	}

	@Override
	public void draw() {
		background(200);
		
		sim.runOneStep();
		
		display.drawGrid(sim.getForest()); // display the game
		
	}
}