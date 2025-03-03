package de.eldecker.spitznamen;

import java.rmi.Remote;
import java.rmi.RemoteException;

import de.eldecker.spitznamen.model.SpitznamenException;
import de.eldecker.spitznamen.model.SpitznamenRecord;


public interface ISpitznamenGenerator extends Remote {
    
	public static final String SPITZNAMEN_SERVICE_NAME = "SpitznamenGenerator";
	
	public SpitznamenRecord[] holeSpitznamen( int anzahl ) 
						throws RemoteException, SpitznamenException;
    
}