package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Sword extends Item {

	private Position position;

	public Sword(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = true;
		isWalkable = true;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public String getName() {
		return "Sword";
	}
}
