package sew9.worttrainer.lriffer;

import java.io.IOException;

/**
 * Strategy-Pattern-Interface zum Laden und Speichern von Daten
 * @author Lili Riffer
 * @version 08-10-23
 */
public interface SpeichernUndLadenInterface {
	public void speichern(String filename) throws IOException;
	public void laden(String filename) throws IOException;
	public void speichern() throws IOException;
	public void laden() throws IOException;
	
}
