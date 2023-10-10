package sew9.worttrainer.lriffer;
import java.io.*;
import java.util.Scanner;

public class SpeichernLadenTxT implements SpeichernUndLadenInterface{

    private WortTrainer trainer;
	private String filename = "Worttrainer.txt";
    
    /**
     * Konstruktor
     * @param t Trainer was übernommen wird
     */
    public SpeichernLadenTxT(WortTrainer t){
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
		writer.write(trainer.getQuestions() + System.lineSeparator() +trainer.getRight() + System.lineSeparator() +trainer.getWrong() + System.lineSeparator());
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
