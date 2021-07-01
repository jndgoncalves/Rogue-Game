package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Wall extends Item {

	private Position position;

	public Wall(Position position) {
		this.position = position;
		isWalkable = false;
		isAttackable = false;
		isPickable = false;

	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
