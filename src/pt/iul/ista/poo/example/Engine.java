package pt.iul.ista.poo.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;

public class Engine {

	public Engine() {

	}

	public void Start() {

		ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
		gui.setName("Rogue Game");

		List<ImageTile> tiles = new ArrayList<ImageTile>();

		Room r = new Room(0, gui);
		try {
			tiles = r.scanTextFile(new File(""));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Hero hero = new Hero(r.getPosicaoInicial(), r, gui);

		gui.addObserver(hero);

		tiles.add(hero);
		hero.addStatusBar();
		gui.newImages(tiles);
		gui.go();
	}
}
