package de.eldecker.spitznamen.client;

import static de.eldecker.spitznamen.ISpitznamenGenerator.SPITZNAMEN_SERVICE_NAME;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.eldecker.spitznamen.ISpitznamenGenerator;
import de.eldecker.spitznamen.model.SpitznamenException;
import de.eldecker.spitznamen.model.SpitznamenRecord;


public class SpitznamenClient {

	public static void main(String[] args) 
			throws RemoteException, NotBoundException, SpitznamenException {
		
		System.out.println();
		
		final Registry registry = LocateRegistry.getRegistry();
		
		final ISpitznamenGenerator stub = 
					(ISpitznamenGenerator) registry.lookup( SPITZNAMEN_SERVICE_NAME );
		
		System.out.println( "Entfernten SpitznamenGenerator gefunden\n" );
				  
		final SpitznamenRecord[] spitznamenRecord = stub.holeSpitznamen( 3 );
		
		for ( int i = 0; i < spitznamenRecord.length; i++ ) {
			
			System.out.println( "\tSpitzname erhalten: " + spitznamenRecord[i] );
		}
		
		System.out.println();
	}
	
}
