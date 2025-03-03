package de.eldecker.spitznamen.model;

import java.io.Serializable;


/**
 * Die Record-Klasse muss das Interface {@code Serializable} implementieren,
 * damit Objekte dieser Klasse über RMI übertragen werden können.
 */
public record SpitznamenRecord( String adjektiv, 
		                        String substantiv ) 
		implements Serializable {
	
	@Override
	public String toString() {
		
		return adjektiv + " " + substantiv;
	}
}
