package sew9.worttrainer.lriffer;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Speichert und Lädt Worttrainer
 * @author Lili Riffer
 * @version 08-10-23
 */
public class SpeichernUndLaden {
	private WortTrainer trainer;
	private String filename = "Worttrainer.txt";
	
	/**
	 * Konstruktor mit parameter
	 * @param t der Worttrainer
	 */
	public SpeichernUndLaden(WortTrainer t) {
		this.trainer = t;
	}
	
	/**
	 * getter methode für versuch
	 * @return wie viele versuche man noch hat
	 */
	public WortEintrag getWort(int index) {
		return this.trainer.getWort(index);
	}

    /**
     * getter für die richtig beantworteten fragen 
     * @return wie viele fragen richtig beantwortet wurden
     */
	public int getTrue(){
        return this.trainer.getRight();
    }
	
    /**
     * getter für die falsch beantworteten fragen 
     * @return wie viele fragen falsch beantwortet wurden
     */
	public int getFalse(){
        return this.trainer.getWrong();
    }

    /**
     * getter für die Anzahl der fragen 
     * @return wie viele fragen beantwortet wurden
     */
	public int getTries(){
        return this.trainer.getQuestions();
    }

	/**
	 * speichert das ergebnis in einem file, wessen name angegeben werden kann
	 * @param filename wie der file heißen soll
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern(String filename) throws IOException{
		File f = new File(filename);
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(f));
		writer.write("Anzahl der Fragen: "+trainer.getQuestions() + System.lineSeparator() + "Richtige Antworten: "+trainer.getRight() + System.lineSeparator() + "Falsche Antworten: "+trainer.getWrong() + System.lineSeparator());
		writer.close();
	}
	/**
	 * speichert das ergebnis in einem file, hat aber schon einen namen und kann nicht angegeben werden
	 * @throws IOException falls etwas nicht gespeichert werden kann
	 */
	public void speichern() throws IOException{
		speichern(this.filename);
	}
	
	
	/**
	 * Lädt die datei mit einem übernommenen speicherort
	 * @param filename Filename wird übergeben
	 * @throws IOException
	 */
	public void laden(String filename) throws IOException {
		Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
		try {
			int richtige = Integer.parseInt(reader.nextLine());
			int falsche = Integer.parseInt(reader.nextLine());
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
