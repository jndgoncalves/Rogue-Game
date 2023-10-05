package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Green extends Item {

	private Position position;

	public Green(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "Green";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}