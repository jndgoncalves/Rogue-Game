package pt.iul.ista.poo.itens;

import java.util.Random;

import pt.iul.ista.poo.example.Hero;
import pt.iul.ista.poo.example.Room;
import pt.iul.ista.poo.rogue.utils.Direction;
import pt.iul.ista.poo.rogue.utils.Position;
import pt.iul.ista.poo.rogue.utils.Vector2D;

public class Enemy extends Item {

	private Position position;

	private int hp;
	private int attack;

	private Room room;

	public Enemy(Position position, Room room) {
		this.position = position;
		this.room = room;

		hp = 70;
		attack = 5;

		isAttackable = true;
		isPickable = false;
		isWalkable = false;

	}

	public void dealDamageToHero(Hero hero) {
		int dmg = getAttack();
		int heroHPafterAttack = hero.getHp() - dmg;

		hero.setHp(heroHPafterAttack);
	}

	public void moveEnemy() {
		int aux = (int) (Math.random() * (19)) + 1;
		Position enemyPos = getPosition();

		if (aux <= 5 && aux > 0) {
			Vector2D v = Direction.UP.asVector();
			Position posPlusEne = enemyPos.plus(v);
			if (room.getItem(posPlusEne).isWalkable() == true) {
				position = posPlusEne;
				// System.out.println(room.getItem(posPlusEne).getName());
			}

		} else if (aux <= 10 && aux > 5) {
			Vector2D v = Direction.DOWN.asVector();
			Position posPlusEne = enemyPos.plus(v);
			if (room.getItem(posPlusEne).isWalkable() == true) {
				position = posPlusEne;
			}

		} else if (aux <= 15 && aux > 10) {
			Vector2D v = Direction.LEFT.asVector();
			Position posPlusEne = enemyPos.plus(v);
			if (room.getItem(posPlusEne).isWalkable() == true) {
				position = posPlusEne;
			}

		} else if (aux <= 20 && aux > 15) {
			Vector2D v = Direction.RIGHT.asVector();
			Position posPlusEne = enemyPos.plus(v);
			if (room.getItem(posPlusEne).isWalkable() == true) {
				position = posPlusEne;
			}
		}
		room.getGui().clearImages();
		room.getGui().newImages(room.getTela());
		room.getGui().update();
	}

	public Position getPosition() {
		return position;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

}
