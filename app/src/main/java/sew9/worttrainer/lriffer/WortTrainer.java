package sew9.worttrainer.lriffer;
import java.util.*;

/**
 * Klasse für einen Worttrainer
 * @author Lili Riffer
 * @version 08-10-2023
 */
public class WortTrainer {
    
	//Attribute
	private WortListe list;
	private int questions;
    private int right;
    private int wrong;

	/**
	 * konstruktor 
	 * @param l die liste die man trainieren will
	 */
	public WortTrainer(WortListe l) {
		this.list = l;
        this.questions = 0;
        this.right = 0;
        this.wrong = 0;
	}
	
    /**
     * Getter für Fragen
     * @return wie viele fragen beantwortet wurden
     */
    public int getQuestions(){
        return this.questions;
    }
    /**
     * Getter für Fragen
     * @return wie viele fragen beantwortet wurden
     */
    public void addQuestions(int i){
        this.questions += i;
    }
    /**
     * Getter für Fragen
     * @return wie viele fragen beantwortet wurden
     */
    public void setQuestions(int i){
        this.questions = i;
    }

    /**
     * Getter für falsche antworten
     * @return wie viele falsche fragen beantwortet wurden
     */
    public int getWrong(){
        return this.wrong;
    }

    /**
     * Getter für richtige antworten
     * @return wie viele richtige fragen beantwortet wurden
     */
    public int getRight(){
        return this.right;
    }

    /**
     * Setter für richtige Antworten
     * @param zahl zahl, auf die gesettet werden soll
     */
    public void setRight(int zahl){
        this.right = zahl;
    }

    /**
     * Setter für falsche Antworten
     * @param zahl zahl, auf die gesettet werden soll
     */
    public void setWrong(int zahl){
        this.wrong = zahl;
    }

    /**
     * addiert zahl zu ergebnis
     * @param zahl zahl, die dazuaddiert werden soll
     */
    public void addRight(int zahl){
        this.right+=zahl;
    }

    /**
     * addiert zahl zu ergebnis
     * @param zahl zahl, die dazuaddiert werden soll
     */
    public void addWrong(int zahl){
        this.wrong+=zahl;
    }

    /**
     * Getter für richtige antworten
     * @return wie viele richtige fragen beantwortet wurden
     */
    public String getFehlerQuote(){
        return new String("Von "+questions+" Fragen waren "+right+" richtig und "+wrong+" falsch");
    }
    
	/**
	 * Zufälliger Worteintrag wird ausgewählt
	 * @return zufälliger worteintrag 
	 */
	public WortEintrag getZufallsWort() {
        Random random = new Random(this.list.getLength());
        int r = random.nextInt(this.list.getLength());
        for (int i = 0; i < this.list.getLength(); i++) {
            if(this.list.getEintrag(r)!=null){
                return this.list.getEintrag(r);
            }
        }
		return null;
	}

	/**
     * sucht sich ein bestimmtes wort mithilfe von index aus
	 * @param index entsprechender index für das gewollte wort
	 * @return worteintrag 
	 */
	public WortEintrag getWort(int index) {
		return this.list.getEintrag(index);
	}

    public WortListe getWortListe(){
        return this.list;
    }

	/**
	 * schaut ob die zwei wörter übereinstimmen
	 * @param w wort welches mit dem ausgewählten verglichen wird 
     * @param index womit wort ausgesucht wird
	 * @return ob übereinstimmt oder nicht
	 */
	public boolean check(String w, int index) {
        this.questions++;
		if(this.list.getEintrag(index).getWort().equals(w)) {
            this.right++;
			return true;
		}
        this.wrong++;
		return false;
	}

	/**
	 * schaut ob zwei wörter übereinstimmen wobei 
	 * groß/kleinschreibung ignoriert wird
	 * @param w das verglichen wird
	 * @return ob übereinstimmt oder nicht
	 */
	public boolean checkIgnoreCase(String w,int index) {
        this.questions++;
		if(this.list.getEintrag(index).getWort().toLowerCase().equals(w.toLowerCase())) {
            this.right++;
			return true;
		}
        this.wrong++;
		return false;
	}

    
}

