package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Red extends Item {

	private Position position;

	public Red(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "Red";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
