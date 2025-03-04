package de.eldecker.spitznamen.model;

import java.io.Serializable;


/**
 * Die Record-Klasse muss das Interface {@code Serializable} implementieren,
 * damit Objekte dieser Klasse über RMI übertragen werden können.
 * 
 * @param adjektiv Adjektiv als erstes Wort von Spitzname
 * 
 * @param substantiv Substantiv als zweites Wort von Spitzname
 */
public record SpitznamenRecord( String adjektiv, 
		                        String substantiv ) 
		implements Serializable {
	
	/**
	 * Methode gibt ganzen Spitznamen zurück.
	 * 
	 * @return Ganzer Spitzname (Adjektiv und Substantiv mit Leerzeichen dazwischen)
	 *         Beispiel: Awesome Bear
	 */
	@Override
	public String toString() {
		
		return adjektiv + " " + substantiv;
	}
}
