package sew9.worttrainer.lriffer;
import java.util.Arrays;
/**
 * Klasse für eine wortliste
 * @author Lili Riffer
 * @version 04-10-2023
 */

public class WortListe {
    
	private WortEintrag[] eintraege;

	/**
	 * Konstruktor ohne parameter
	 */
	public WortListe() {
		this.eintraege = new WortEintrag[0];
	}

	/**
	 * Konstruktor mit parameter
	 * @param maxWoerter maximale 
	 * wörter die gespeichert werden können
	 */
	public WortListe(int maxWoerter) {
		this.eintraege= new WortEintrag[maxWoerter];
	}

	/**
	 * fügt ein worteintrag dazu
	 * @param a das neue wort
	 * @return true/false, ob es zugefügt wurde
	 */
	public boolean addWort(WortEintrag w) {
		boolean added = false;
		for(int i = 0; i<eintraege.length && added==false; i++) {
			if(this.eintraege[i] == null) {
				this.eintraege[i] = w;
				added = true;
			}
		}
		if(added==false) {
			this.eintraege= Arrays.copyOf(this.eintraege, this.eintraege.length+1);
			this.eintraege[this.eintraege.length-1] = w; 
		}
		return added;
	}

	/**
	 * gibt den entsprechenden worteintrag zurück
	 * @param index index der übernommen wird um
	 * den worteintrag auszugeben
	 * @return den entsprechenden worteintrag 
	 */
	public WortEintrag getEintrag(int index) {
		for(int i=0; i<eintraege.length ; i++) {
			if(eintraege[i]!=null) {
				if(i == index) {
					return this.eintraege[i];
				}
			}
		}
		return this.eintraege[0];
		
	}
    /**
     * Getter für die ganze Liste
     * @return die Liste
     */
    public WortEintrag[] getEintragArray(){
        return this.eintraege;
    }

    /**
	 * zeigt die länge
	 * @return länge des arrays
	 */
	public int getLength() {
		return eintraege.length;
	}

	/**
	 * toString methode, sodass der WortEintrag
	 * als eigene Zeile ausgegeben wird
	 * @return zeile
	 */
	@Override
	public String toString() {
		String list="";
		for(int i = 0 ; i<eintraege.length ; i++) {
			list= list+ "\n" + this.eintraege[i];
		}
		return list;
	}

	/**
	 * löscht ein wort
	 * @param w das gelöscht wird
	 * @return ob funktioniert hat
	 */
	public boolean WortDelete(String w) {
		for(int i = 0 ; i<eintraege.length; i++) {
			if(eintraege[i]!=null) {
				if(eintraege[i].getWort().equals(w)) {
					eintraege[i] = null;
					return true;
				}
			}
		}
		return false;
	}
}

