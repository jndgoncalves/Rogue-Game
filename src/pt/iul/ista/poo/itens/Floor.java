package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Floor extends Item {

	private Position position;

	public Floor(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = true;
	}

	@Override
	public String getName() {
		return "Floor";
	}

	@Override
	public Position getPosition() {
		return position;
	}

}