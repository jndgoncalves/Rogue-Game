package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.rogue.utils.Position;

public class Trap extends Item {

	Position position;

	public Trap(Position position) {

		this.position = position;
		isAttackable = false;
		isPickable = false;
		isWalkable = true;
	}

}
