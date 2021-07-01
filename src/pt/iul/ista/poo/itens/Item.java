package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.rogue.utils.*;

public class Item implements ImageTile {

	Position position;

	boolean isWalkable;
	boolean isAttackable;
	boolean isPickable;

	public Item() {

	}

	@Override
	public String getName() {
		return "Item";
	}

	@Override
	public Position getPosition() {
		return position;
	}

	public boolean isWalkable() {
		return isWalkable;
	}

	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}

	public boolean isAttackable() {
		return isAttackable;
	}

	public void setAttackable(boolean isAttackable) {
		this.isAttackable = isAttackable;
	}

	public boolean isPickable() {
		return isPickable;
	}

	public void setPickable(boolean isPickable) {
		this.isPickable = isPickable;
	}

}
