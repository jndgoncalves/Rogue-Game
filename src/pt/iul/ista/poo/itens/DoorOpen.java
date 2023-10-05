package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class DoorOpen extends Item {

	private Position position;

	public DoorOpen(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "DoorOpen";
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
