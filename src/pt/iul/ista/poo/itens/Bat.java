package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.example.Room;
import pt.iul.ista.poo.rogue.utils.Position;

public class Bat extends Enemy {

	public Bat(Position position, Room room) {
		super(position, room);
	}

	@Override
	public String getName() {
		return "Bat";
	}

}
