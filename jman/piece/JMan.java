package jman.piece;

import java.awt.*;
import jman.Map;
import jman.Piece;

/**
 * An instance of this class is a J*Man. There should at most one J*Man in a
 * game board at a time
 */
public class JMan extends Piece {

	/**
	 * Constructor: a new J*Man at position (x, y) on Map m with color red if c
	 * = 0, green if c = 1, and yellow if c = 2.
	 */
	public JMan(int x, int y, Map m) {
		super(Piece.JMAN, m);
		setX(x);
		setY(y);
		color();
	}

	/**
	 * Constructor: a new J*Man at position (x, y) on Map m with color c.
	 * Precondition: c is one of Color.RED, Color.GREEN, and Color.YELLOW.
	 */
	public void color() {
		int color = rand(0, 2);
		if (color == 0) {
			setColor(Color.RED);
		} else if (color == 1) {
			setColor(Color.GREEN);
		} else if (color == 2) {
			setColor(Color.YELLOW);
		}
	}

	/**
	 * J*Man should move based on what button is pushed. This method is not
	 * used.
	 */
	public void act() {
		return;
	}

	/**
	 * Move J*Man one step based on the value of i: 0 = up, 1 = down, 2 = left,
	 * 3 = right.
	 */
	public void step(int i) {
		setActed(true);
		if (i == 0) {
			position(0, -1);
		} else if (i == 1) {
			position(0, 1);
		} else if (i == 2) {
			position(-1, 0);
		} else if (i == 3) {
			position(1, 0);
		}
	}

	/**
	 * Move to the current position in (x,y) coordinate
	 * 
	 * @param moveX
	 *            move the position of the x-axis
	 * @param moveY
	 *            move the position of the y-axis
	 */
	public void position(int moveX, int moveY) {

		int newX = getX() + moveX;
		int newY = getY() + moveY;

		if (!getMap().isInGrid(newX, newY))
			return;

		if (getMap().pieceAt(newX, newY) == null)
			getMap().move(getX(), getY(), newX, newY);

		if (isCapture(getColor(), getMap().pieceAt(newX, newY).getColor())) {
			setColor(getMap().pieceAt(newX, newY).getColor());
			getMap().move(getX(), getY(), newX, newY);
		}
	}

	public boolean isCapture(Color a, Color b) {
		if (a == Color.GREEN && b == Color.RED)
			return true;
		if (a == Color.YELLOW && b == Color.GREEN)
			return true;
		if (a == Color.RED && b == Color.YELLOW)
			return true;
		return false;
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}
}
