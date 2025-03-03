package de.eldecker.spitznamen.server;

import java.rmi.RemoteException;
import java.util.Random;

import de.eldecker.spitznamen.ISpitznamenGenerator;
import de.eldecker.spitznamen.model.SpitznamenException;
import de.eldecker.spitznamen.model.SpitznamenRecord;


public class SpitznamenGeneratorImpl implements ISpitznamenGenerator {

    private static final String[] ADJEKTIVE_ARRAY = {
            "Awesome", "Brave", "Clever", "Daring", "Eager", "Fantastic",
            "Gentle", "Happy", "Intelligent", "Jolly", "Kind", "Lively",
            "Magnificent", "Nice", "Optimistic", "Pleasant", "Quirky",
            "Radiant", "Silly", "Thoughtful", "Unique", "Vibrant", "Witty",
            "Xenial", "Youthful", "Zealous"
        };
    
    private static final String[] SUBSTANTIVE_ARRAY = {
            "Ant", "Bear", "Cat", "Dog", "Elephant", "Frog", "Giraffe",
            "Horse", "Iguana", "Jaguar", "Kangaroo", "Lion", "Monkey",
            "Narwhal", "Owl", "Penguin", "Quokka", "Rabbit", "Snake",
            "Turtle", "Unicorn", "Vulture", "Whale",
            "Xylophone", "Yak", "Zebra"
        };
	
    
    private static final Random _zufallsGenerator = new Random();
    
    
    private static String getZufallsElement( String[] stringArray ) {
    
    	final int arrayLaenge  = stringArray.length;
    	final int zufallsIndex = _zufallsGenerator.nextInt( arrayLaenge );
    	
    	return stringArray[ zufallsIndex ];
    }
    
    
    private static SpitznamenRecord holeSpitzname() {
    	
    	final String adjektiv   = getZufallsElement( ADJEKTIVE_ARRAY   );
    	final String substantiv = getZufallsElement( SUBSTANTIVE_ARRAY );
    	
    	final SpitznamenRecord spitzname = new SpitznamenRecord( adjektiv, substantiv );
    	
    	System.out.println( "Spitzname erzeugt: " + spitzname );
    	
    	return spitzname;
    }
    

    /**
     * Implementierung Methode aus Remote Interface.
     * 
     * @param anzahl Anzahl der zu erzeugenden Spitznamen, muss im Bereich von
     *               1..100 sein
     *               
     * @return Array mit den erzeugten Spitznamen
     * 
     * @throws RemoteException RMI-Fehler
     * 
     * @throws SpitznamenException Unzulässiger Wert für Argument {@code anzahl}
     */
	@Override
	public SpitznamenRecord[] holeSpitznamen( int anzahl ) 
					throws RemoteException, SpitznamenException {

		System.out.println( "\nAnfrage für " + anzahl + " Spitznamen erhalten." );
		
		if ( anzahl < 1 ) {
			
			throw new SpitznamenException( "Anzahl der angeforderten Spitznamen zu klein." );
		}
		if ( anzahl > 100 ) {
			
			throw new SpitznamenException( "Anzahl der angeforderten Spitznamen zu gross." );
		}
		
		
		final SpitznamenRecord[] ergebnisArray = new SpitznamenRecord[ anzahl ];
		for ( int i = 0; i < ergebnisArray.length; i++ ) {
			
			ergebnisArray[ i ] = holeSpitzname();
		}
				
		return ergebnisArray;
	}

}
