package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Fire extends Item {

	private Position position;

	public Fire(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = true;
		isWalkable = true;
	}

	@Override
	public String getName() {
		return "Fire";
	}

	@Override
	public Position getPosition() {
		return position;
	}

}