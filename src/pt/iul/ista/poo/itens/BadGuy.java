package pt.iul.ista.poo.itens;

import pt.iul.ista.poo.example.Room;
import pt.iul.ista.poo.rogue.utils.Position;

public class BadGuy extends Enemy {

	public BadGuy(Position position, Room room) {
		super(position, room);
	}

	@Override
	public String getName() {
		return "BadGuy";
	}
}