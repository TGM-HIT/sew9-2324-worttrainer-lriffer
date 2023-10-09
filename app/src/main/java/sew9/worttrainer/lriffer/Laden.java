package sew9.worttrainer.lriffer;
import java.io.*;
import java.util.Scanner;


public class Laden {
    private WortTrainer trainer;
	private String filename = "Worttrainer.txt";

    /**
     * Konstruktor
     * @param t Trainer was übergeben wird
     */
    public Laden(WortTrainer t){
        this.trainer = t;
    }

	/**
	 * Lädt die datei mit einem übernommenen speicherort
	 * @param filename Filename wird übergeben
	 * @throws IOException
	 */
	public void laden(String filename) throws IOException {
		Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
		try {
			int fragen = Integer.parseInt(reader.nextLine());
			int richtige = Integer.parseInt(reader.nextLine());
			int falsche = Integer.parseInt(reader.nextLine());
			trainer.addQuestions(fragen);
			trainer.addRight(richtige);
			trainer.addWrong(falsche);		
		} finally {
			reader.close();
		}
	}
	/**
	 * Lädt die datei mit einem angegebenen speicherort
	 * @throws IOException
	 */
	public void laden() throws IOException {
		laden(this.filename);
	}
}
