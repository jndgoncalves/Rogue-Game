package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Black extends Item {

	private Position position;

	public Black(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = false;
	}

	@Override
	public String getName() {
		return "Black";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}