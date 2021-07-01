package pt.iul.ista.poo.rogue.utils;

public class Vector2D {

	private int i;
	private int j;

	public Vector2D(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getX() {
		return i;
	}

	public int getY() {
		return j;
	}

	public Vector2D plus(Vector2D vector2d) {
		Vector2D v = new Vector2D(i + vector2d.getX(), j + vector2d.getY());
		return v;
	}

	public Vector2D minus(Vector2D vector2d) {
		Vector2D v = new Vector2D(i - vector2d.getX(), j - vector2d.getY());
		return v;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2D other = (Vector2D) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
}
