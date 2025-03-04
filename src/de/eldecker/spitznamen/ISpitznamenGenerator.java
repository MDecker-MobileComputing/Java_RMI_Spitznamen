package de.eldecker.spitznamen;

import java.rmi.Remote;
import java.rmi.RemoteException;

import de.eldecker.spitznamen.model.SpitznamenException;
import de.eldecker.spitznamen.model.SpitznamenRecord;


/**
 * Dieses Interface muss vom entfernten Objekt implementiert werden.
 */
public interface ISpitznamenGenerator extends Remote {
    
	/** Name, unter dem der Service an die RMI-Registry gebunden wird. */
	public static final String SPITZNAMEN_SERVICE_NAME = "SpitznamenGenerator";
	
	/**
	 * Methode, die eine bestimmte Anzahl an zufällig erzeugten Spitznamen 
	 * zurückliefert.
	 * 
	 * @param anzahl Anzahl der zu erzeugenden Spitznamen, muss im Bereich
	 *               1..100 sein
	 *               
	 * @return Array mit {@code anzahl} Spitzennamen
	 * 
	 * @throws RemoteException RMI-Fehler
	 * 
	 * @throws SpitznamenException Applikations-spezifischer Fehler
	 */
	public SpitznamenRecord[] holeSpitznamen( int anzahl ) 
	                          throws RemoteException, 
	                                 SpitznamenException;    
}