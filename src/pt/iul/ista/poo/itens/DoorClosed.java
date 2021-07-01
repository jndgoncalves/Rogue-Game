package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class DoorClosed extends Item {

	private Position position;

	public DoorClosed(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "DoorClosed";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
