package pt.iul.ista.poo.rogue.utils;

/**
 * @author POO2016
 * 
 *         Cardinal directions
 *
 */
public enum Direction {
	LEFT, UP, RIGHT, DOWN;

	public Vector2D asVector() {
		if (this == Direction.LEFT)
			return new Vector2D(-1, 0);
		if (this == Direction.DOWN)
			return new Vector2D(0, 1);
		if (this == Direction.RIGHT)
			return new Vector2D(1, 0);
		else
			return new Vector2D(0, -1);
	}
}
