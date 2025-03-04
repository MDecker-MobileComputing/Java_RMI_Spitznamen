package de.eldecker.spitznamen.model;


/**
 * Applikations-spezifische Exception-Klasse.
 */
@SuppressWarnings("serial")
public class SpitznamenException extends Exception {

	public SpitznamenException( String fehlerBeschreibung ) {
		
		super( fehlerBeschreibung );
	}
	
}
