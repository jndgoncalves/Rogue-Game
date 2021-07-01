package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.example.Room;
import pt.iul.ista.poo.rogue.utils.Position;

public class Skeleton extends Enemy {

	public Skeleton(Position position, Room room) {
		super(position, room);
	}

	@Override
	public String getName() {
		return "Skeleton";
	}

}
