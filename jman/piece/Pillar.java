package jman.piece;

import java.awt.Color;
import jman.Map;
import jman.Piece;

/**
 * An instance of this class is a Pillar.
 * 
 * @author Methawee Apinainarong 5810546714
 */
public class Pillar extends Piece {
	/**
	 * Constructor: a new Block at position (x, y) on Map m with random color.
	 */
	public Pillar(int x, int y, Map m) {
		super(Piece.PILLAR, m);
		setX(x);
		setY(y);
		color();
	}

	/** Pillar should change color 1/3 of the time. */
	@Override
	public void act() {
		if (rand(0, 2) > 1)
			color();
	}

	/**
	 * Random the color of the pillar
	 */
	public void color() {
		int color = rand(0, 2);
		if (color == 0)
			setColor(Color.RED);
		else if (color == 1)
			setColor(Color.GREEN);
		else
			setColor(Color.YELLOW);
	}

	/** representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}

}
