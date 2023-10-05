package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Grass extends Item {

	private Position position;

	public Grass(Position position) {
		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = true;
	}

	@Override
	public String getName() {
		return "Grass";
	}

	@Override
	public Position getPosition() {
		return position;
	}
}