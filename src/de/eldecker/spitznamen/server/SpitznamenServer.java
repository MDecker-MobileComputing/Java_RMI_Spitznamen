package de.eldecker.spitznamen.server;

import static de.eldecker.spitznamen.ISpitznamenGenerator.SPITZNAMEN_SERVICE_NAME;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import de.eldecker.spitznamen.ISpitznamenGenerator;


/**
 * Klasse mit Startmethode für Server.
 */
public class SpitznamenServer {

	private static final int RMI_REGISTRY_PORT = 1099;
	
	
	/**
	 * Einstiegsmethode.
	 * 
	 * @param args Kommandozeilenargumente, werden nicht ausgewertet.
	 * 
	 * @throws RemoteException Fehler bei RMI-Übertragung
	 * 
	 * @throws AlreadyBoundException Fehler wenn Port schon belegt
	 */
	public static void main( String[] args ) throws RemoteException, 
	                                                AlreadyBoundException { 			
						
		final SpitznamenGeneratorImpl serviceImpl = new SpitznamenGeneratorImpl();		
		final ISpitznamenGenerator stub= (ISpitznamenGenerator) UnicastRemoteObject.exportObject( serviceImpl, 0 );
		
		final Registry registry = LocateRegistry.createRegistry( RMI_REGISTRY_PORT );
		registry.bind( SPITZNAMEN_SERVICE_NAME, stub );
		
		System.out.println( "\nSpitznamen-Server gestartet ..." );
	}
	
}
