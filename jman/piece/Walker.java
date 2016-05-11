package jman.piece;

import java.awt.Color;
import jman.Map;
import jman.Piece;
/**
 * An instance of this class is a Walker.
 * 
 * @author Methawee Apinainarong 5810546714
 */

public class Walker extends Piece {
	/**
	 * Constructor: a new Block at position (x, y) on Map m.
	 */
	public Walker(int x, int y, Map m) {
		super(Piece.WALKER, m);
		setX(x);
		setY(y);
		
		int c = rand(0, 2);
		if (c == 0) {
			setColor(Color.RED);
		} else if (c == 1) {
			setColor(Color.GREEN);
		} else {
			setColor(Color.YELLOW);
		}
	}
	
    /** Walker should move 1/3 of the time.*/
	public void act() {
		
		if (rand(0, 2) == 0) {
			int direction = rand(0, 3);
			if (direction == 0) {
				step(0, -1);
			} else if (direction == 1) {
				step(0, 1);
			} else if (direction == 2) {
				step(-1, 0);
			} else {
				step(1, 0);
			}
		}
	}
/**
 * Move to the current position
 * @param moveX position in x-axis
 * @param moveY position in y-axis
 */
	public void step(int moveX, int moveY) {
		
		int newx = getX() + moveX;
		int newy = getY() + moveY;
		
		if (getMap().isEmpty(newx, newy)) {
			getMap().move(getX(), getY(), newx, newy);
		}
	}

	/** representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}