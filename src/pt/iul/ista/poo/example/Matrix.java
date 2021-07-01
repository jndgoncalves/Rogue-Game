package pt.iul.ista.poo.example;

import java.util.List;

import pt.iul.ista.poo.gui.ImageTile;

public class Matrix {

	private int hp;
	private List<ImageTile> matrix;
	private int mana;
	private int bag_capacity;

	public Matrix(int hp, List<ImageTile> matrix) {
		this.hp = hp;
		// matrix = new List<ImageTile>();
		// newStatusImages? init?
		this.matrix = matrix;
		this.mana = mana;
		this.bag_capacity = bag_capacity;
	}

	public int getHp() {
		return hp;
	}

	public List<ImageTile> getMatrix() {
		return matrix;
	}

	public int getMana() {
		return mana;
	}
}
