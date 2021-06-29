

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse BeispielbildTest.
 *
 * @author  S. Gebert
 * @version 06.2021
 */
public class Beispielzustand
{
    private Picture p1;
    private GeometrischeBildoperationen sHori;
    private GeometrischeBildoperationen sVerti;
    private GeometrischeBildoperationen dLinks;

    /**
     * Konstruktor fuer die Test-Klasse Beispielzustand
     */
    public Beispielzustand()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        p1 = new Picture("iris.jpg");
        p1.display();
        sHori = new GeometrischeBildoperationen();
        sHori.setOperation(1);
        sVerti = new GeometrischeBildoperationen();
        sVerti.setOperation(2);
        dLinks = new GeometrischeBildoperationen();
        dLinks.setOperation(3);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
}
