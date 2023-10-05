package pt.iul.ista.poo.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.itens.BadGuy;
import pt.iul.ista.poo.itens.Bat;
import pt.iul.ista.poo.itens.DoorClosed;
import pt.iul.ista.poo.itens.DoorOpen;
import pt.iul.ista.poo.itens.DoorWay;
import pt.iul.ista.poo.itens.Enemy;
import pt.iul.ista.poo.itens.Fire;
import pt.iul.ista.poo.itens.Floor;
import pt.iul.ista.poo.itens.Hammer;
import pt.iul.ista.poo.itens.Item;
import pt.iul.ista.poo.itens.Skeleton;
import pt.iul.ista.poo.itens.Sword;
import pt.iul.ista.poo.itens.Wall;
import pt.iul.ista.poo.rogue.utils.Position;

public class Room {

	private ArrayList<ImageTile> tela = new ArrayList<ImageTile>();
	private ImageMatrixGUI gui;

	private Position posicaoInicial;
	private int id;

	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Item> weapons = new ArrayList<Item>();

	public Room(int id, ImageMatrixGUI gui) {
		this.id = id;
		this.gui = gui;
	}

	public List<ImageTile> scanTextFile(File f) throws FileNotFoundException {

		File g = new File("./rooms/room0.txt");
		Scanner scanner = new Scanner(g);
		ArrayList<String> auxiliar = new ArrayList<String>();

		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();
			System.out.println("Li" + line);

			if (line.trim().startsWith("#")) {

			} else {
				String[] vetorLinha = line.split("");
				for (String e : vetorLinha) {
					auxiliar.add(e);
				}
			}
		}
		scanner.close();
		int a = 0;
		int aux = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				Position pos = new Position(i, j);
				System.out.println(aux);
				aux++;

				// add floor em tudo
				Floor floor = new Floor(pos);
				tela.add(floor);

				if (auxiliar.get(a).equals("W")) {
					Wall wall = new Wall(pos);
					tela.add(wall);
					System.out.println("Add wall");
				} else if (auxiliar.get(a).equals("0")) {
					DoorClosed dclosed = new DoorClosed(pos);
					tela.add(dclosed);
					System.out.println("Add dclosed");
				} else if (auxiliar.get(a).equals("1")) {
					DoorOpen dopen = new DoorOpen(pos);
					tela.add(dopen);
					posicaoInicial = pos;
					System.out.println("Add dopen");
				} else if (auxiliar.get(a).equals("2")) {
					DoorWay dway = new DoorWay(pos);
					tela.add(dway);
					System.out.println("Add dway");
				}
				if (auxiliar.get(a).equals("s")) {
					Sword sword = new Sword(pos);
					tela.add(sword);
					System.out.println("Add sword");
				} else if (auxiliar.get(a).equals("h")) {
					Hammer hammer = new Hammer(pos);
					tela.add(hammer);
					System.out.println("Add hammer");
				} else if (auxiliar.get(a).equals("f")) {
					Fire fire = new Fire(pos);
					tela.add(fire);
					System.out.println("Add fireball");
				} else if (auxiliar.get(a).equals("S")) {
					Skeleton skeleton = new Skeleton(pos, this);
					enemyList.add(skeleton);
					tela.add(skeleton);
					System.out.println("Add Skeleton");
				} else if (auxiliar.get(a).equals("B")) {
					Bat bat = new Bat(pos, this);
					enemyList.add(bat);
					tela.add(bat);
					System.out.println("Add Bat");
				} else if (auxiliar.get(a).equals("G")) {
					BadGuy badguy = new BadGuy(pos, this);
					enemyList.add(badguy);
					tela.add(badguy);
					System.out.println("Add BadGuy");
				}
				a++;
			}
		}
		return tela;

	}

	// --------------------------------------------

	public Item getItem(Position pos) {

		Item item = new Item();

		for (int i = 0; i < tela.size(); i++) {
			if (((Item) tela.get(i)).getPosition().equals(pos)) {
				item = (Item) tela.get(i);
				System.out.println(item.getName());
				if (item.getName().equals("Floor")) {
				} else
					return item;
			}
		}
		return item;
	}

	public void removeItem(String name, Position pos) {
		Iterator<ImageTile> itr = tela.iterator();
		System.out.println(name + pos);

		while (itr.hasNext()) {
			ImageTile nextImg = itr.next();
			// System.out.println(nextImg.getName() + nextImg.getPosition());
			if (nextImg.getName().equals(name) && nextImg.getPosition().equals(pos)) {
				tela.remove(nextImg);
				break;
			}

		}
		// System.out.println(tela);
		gui.clearImages();
		gui.newImages(tela);
		gui.update();
	}

	// GETTERS AND SETTERS

	public ArrayList<ImageTile> getTela() {
		return tela;
	}

	public void setTela(ArrayList<ImageTile> tela) {
		this.tela = tela;
	}

	public Position getPosicaoInicial() {
		return posicaoInicial;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public void setEnemyList(ArrayList<Enemy> enemyList) {
		this.enemyList = enemyList;
	}

	public ImageMatrixGUI getGui() {
		return gui;
	}

	public void setGui(ImageMatrixGUI gui) {
		this.gui = gui;
	}

}
