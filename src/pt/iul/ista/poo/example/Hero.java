package pt.iul.ista.poo.example;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.itens.Black;
import pt.iul.ista.poo.itens.Enemy;
import pt.iul.ista.poo.itens.Fire;
import pt.iul.ista.poo.itens.Green;
import pt.iul.ista.poo.itens.Hammer;
import pt.iul.ista.poo.itens.Item;
import pt.iul.ista.poo.itens.Sword;
import pt.iul.ista.poo.rogue.utils.Direction;
import pt.iul.ista.poo.rogue.utils.Position;
import pt.iul.ista.poo.rogue.utils.Vector2D;
import pt.iul.ista.poo.gui.ImageMatrixGUI;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Hero extends Item implements Observer {

	private ImageMatrixGUI gui;
	private ArrayList<ImageTile> statusImages = new ArrayList<ImageTile>();

	private Position position;
	private Room room;


	private ArrayList<Item> weapons = new ArrayList<Item>();
	private Direction aim = Direction.UP;

	private int pocket;
	private int spells;
	private int hp;
	private int attack;

	public Hero(Position position, Room room, ImageMatrixGUI gui) {
		this.position = position;
		this.room = room;
		this.gui = gui;

		this.spells = 0;
		this.pocket = 7;

		this.hp = 100;
		this.attack = 10;

		addStatusBar();
	}

	// -----MOVE-----
	public void move(Direction dir) {

		Vector2D v = dir.asVector();
		Position posPlus = position.plus(v);
		Item nextItem = room.getItem(posPlus); // saber a pos do hero para ver o
											// item a seguir com posPlus

		// System.out.println("NextItem: " + nextItem.getName());
		// System.out.println("NextItem Attackable: " +
		// nextItem.isAttackable());

		// bater nas walls
		if (nextItem.isWalkable() == true) {

			this.position = posPlus;
			System.out.println("--step--");
			aim = dir; // shoot that fire

			if (nextItem.isPickable() == true) {
				addItem(nextItem.getName());
			}
		}

		else if (nextItem.isAttackable() == true) {
			System.out.println("--attack--");

			dealDamageToHero((Enemy) room.getItem(posPlus));
			dealDamageToEnemy(posPlus);

			System.out.println("Hero HP: " + getHp());
			System.out.println(nextItem.getName() + " - HP: " + ((Enemy) nextItem).getHp());
		}

		for (int i = 0; i < room.getEnemyList().size(); i++) {
			room.getEnemyList().get(i).moveEnemy();
			System.out.println(
					"Enemy: " + room.getEnemyList().get(i).getName() + room.getEnemyList().get(i).getPosition());
//			System.out.println("Walkable? :" + room.getEnemyList().get(i).isWalkable());

		}

		System.out.println("Hero: " + getPosition());

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Integer keyCode = (Integer) arg1;
		if (keyCode == KeyEvent.VK_DOWN) {
			// System.out.println("Arrow keys!");
			System.out.println(KeyEvent.getKeyText(keyCode) + " Key pressed ");
			move(Direction.DOWN);
		} else if (keyCode == KeyEvent.VK_UP) {
			// System.out.println("Arrow keys!");
			System.out.println(KeyEvent.getKeyText(keyCode) + " Key pressed ");
			move(Direction.UP);

		} else if (keyCode == KeyEvent.VK_LEFT) {
			// System.out.println("Arrow keys!");
			System.out.println(KeyEvent.getKeyText(keyCode) + " Key pressed ");
			move(Direction.LEFT);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			// System.out.println("Arrow keys!");
			System.out.println(KeyEvent.getKeyText(keyCode) + " Key pressed ");
			move(Direction.RIGHT);
		} else if (keyCode == KeyEvent.VK_SPACE) {
			// System.out.println("Arrow keys!");
			System.out.println(KeyEvent.getKeyText(keyCode) + " Key pressed ");
			castFireball();
			System.out.println("BURN!!!");
		}
		ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
		gui.update();
	}

	// ------- DANO --------

	public void dealDamageToEnemy(Position enemyPos) {
		int dmg = getAttack();

		for (int i = 0; i < room.getEnemyList().size(); i++) {
			if (room.getEnemyList().get(i).getPosition().equals(enemyPos))
				room.getEnemyList().get(i).setHp(room.getEnemyList().get(i).getHp() - dmg);

			if (room.getEnemyList().get(i).getHp() <= 0) {
				room.removeItem(room.getEnemyList().get(i).getName(), room.getEnemyList().get(i).getPosition());
				System.out.println(room.getEnemyList().get(i).getName() + " is dead.");
			}
		}
	}

	public void dealDamageToHero(Enemy enemy) {
		int dmg = enemy.getAttack();
		int heroHPafterAttack = getHp() - dmg;

		setHp(heroHPafterAttack);

		if (getHp() <= 0) {
			System.out.println("YOU DIED");
		}

	}

	public void castFireball() {

	}

	// -----StatusBar-----

	public void addStatusBar() {

		addBlack();
		addGreen();
		gui.newStatusImages(statusImages);
		gui.update();
	}

	public void addItem(String name) {
		if (name.equals("Fire")) {
			addFire();
		} else if (name.equals("Sword")) {
			addSword();
		} else if (name.equals("Hammer")) {
			addHammer();
		}

	}

	private void addBlack() {
		for (int i = 0; i < 10; i++) {
			Black black = new Black(new Position(i, 0));
			statusImages.add(black);
		}
	}

	public void addGreen() {
		for (int i = 3; i < 7; i++) {
			Green green = new Green(new Position(i, 0));
			statusImages.add(green);
		}
	}

	public void addFire() {

		if (spells < 3) {
			Fire fire = new Fire(new Position(spells, 0));
			statusImages.add(fire); // meter img status bar
			System.out.println(room.getItem(fire.getPosition()));
			gui.removeImage(room.getItem(getPosition())); // retirar img da grid
			room.removeItem("Fire", getPosition());
			System.out.println("Remove fire");
			gui.newStatusImages(statusImages);
			gui.update();
			spells++;
			System.out.println("New Object: Fireball");
		} else {
			System.out.println("No space!");
		}
	}

	public void addSword() {

		if (pocket < 10) {
			Sword sword = new Sword(new Position(pocket, 0));
			statusImages.add(sword);
			gui.removeImage(room.getItem(getPosition())); // retirar img da grid
			room.removeItem("Sword", getPosition());
			System.out.println("Remove sword");
			gui.newStatusImages(statusImages);
			gui.update();
			pocket++;
			System.out.println("New Object: Sword");
		} else {
			System.out.println("No space!");
		}
	}

	public void addHammer() {

		if (pocket < 10) {
			Hammer hammer = new Hammer(new Position(pocket, 0));
			statusImages.add(hammer);
			gui.removeImage(room.getItem(getPosition())); // retirar img da grid
			room.removeItem("Hammer", getPosition());
			System.out.println("Remove hammer");
			gui.newStatusImages(statusImages);
			gui.update();
			pocket++;
			System.out.println("New Object: Hammer");
		} else {
			System.out.println("No space!");
		}
	}

	// GETTERS AND SETTERS

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public String getName() {
		return "Hero";
	}

	public Direction getAim() {
		return aim;
	}

	public void setAim(Direction aim) {
		this.aim = aim;
	}

	public void setSpells(int spells) {
		this.spells = spells;
	}

	public int getSpells() {
		return spells;
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

	public ArrayList<Item> getWeapons() {
		return weapons;
	}

	public void setWeapons(ArrayList<Item> weapons) {
		this.weapons = weapons;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}