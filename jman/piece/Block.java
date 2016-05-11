package jman.piece;

import java.awt.Color;
import jman.Map;
import jman.Piece;

/**
 * An instance of this class is a Block.
 * @author Methawee Apinainarong 5810546714
 */
public class Block extends Piece {
	
	/**
	 * Constructor: a new Block at position (x, y) on Map m with color white
	 */
	public Block(int x, int y, Map m) {
		super(Piece.BLOCK, m);
		setX(x);
		setY(y);
		setColor(Color.WHITE);
	}

	/**
	 * Block should not move. This method is not used.
	 */
	@Override
	public void act() {
		return;
	}

	/** representation of this piece */
	public String toString() {
		return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
	}

}
