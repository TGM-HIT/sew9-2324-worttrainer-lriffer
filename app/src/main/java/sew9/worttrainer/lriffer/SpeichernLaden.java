package sew9.worttrainer.lriffer;
import java.io.*;
import java.util.Scanner;

/**
 * Klasse für zum Speichern und Laden vom Worttrainer
 * @author Lili Riffer
 * @version 04-10-2023
 */
public class SpeichernLaden {

    public final String file = "Worttrainer.txt";
	private WortTrainer trainer;

	
	/**
	 * Konstruktor mit parameter
	 * @param l liste
	 * @param v versuche
	 * @param wvr wie viele richtig sind
	 */
	public SpeichernLaden(WortTrainer t) {
		this.trainer = t;
	}
	
	/**
	 * speichert das ergebnis in einem file, wessen name angegeben werden kann
	 * @param filename wie der file heißen soll
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern(String filename) throws IOException{
		File f = new File(filename);
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		writer.write(System.lineSeparator());
		writer.close();
	}
	/**
	 * speichert das ergebnis in einem file, hat aber schon einen namen und kann nicht angegeben werden
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern() throws IOException{
		speichern(file);
	}
	
	
	/**
	 * Lädt die datei mit einem übernommenen speicherort
	 * @param filename Filename wird übergeben
	 * @throws IOException
	 */
	public void laden(String filename) throws IOException {
		Scanner reader = new Scanner(new BufferedReader(new FileReader(file)));
        try {
            int right = Integer.parseInt(reader.nextLine());
            int wrong = Integer.parseInt(reader.nextLine());
            this.trainer.setRight(right);
            this.trainer.setWrong(wrong);
        } finally {
            reader.close();
        }
	}
	/**
	 * Lädt die datei mit einem angegebenen speicherort
	 * @throws IOException
	 */
	public void laden() throws IOException {
		laden(this.file);
	}
	
}
