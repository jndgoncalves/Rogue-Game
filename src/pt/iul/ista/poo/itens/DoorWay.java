package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class DoorWay extends Item {

	private Position position;

	public DoorWay(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "DoorWay";
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
