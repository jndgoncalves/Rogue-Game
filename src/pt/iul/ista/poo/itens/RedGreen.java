package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class RedGreen extends Item {

	private Position position;

	public RedGreen(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "RedGreen";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}