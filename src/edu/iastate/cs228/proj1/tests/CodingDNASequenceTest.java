package edu.iastate.cs228.proj1.tests;

/*
 * @author Charles Young
 */

import edu.iastate.cs228.proj1.CodingDNASequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodingDNASequenceTest {
    char[] testArr = {'a', 't', 'g', 't', 'a', 'c', 'g', 't', 'a', 'c', 'g', 't'};
    CodingDNASequence a = new CodingDNASequence(testArr); //Construction of a new CodingDNASequence using the test array.

    @Test
    public void startCodonTest() {
        assertTrue(a.checkStartCodon());
        char[] testArr2 = "at".toCharArray();
        CodingDNASequence b = new CodingDNASequence(testArr2);
        assertFalse(b.checkStartCodon());
        char[] testArr3 = "aatg".toCharArray();
        CodingDNASequence c = new CodingDNASequence(testArr3);
        assertFalse(c.checkStartCodon());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest() {
        char[] testArr2 = {'a', 'b', 'g', 'g', 'a', 'b', 'g', 'a'};
        new CodingDNASequence(testArr2);
    }

    @Test(expected = RuntimeException.class)
    public void runTimeExceptionTest() {
        char[] testArr2 = {'a', 'a', 'g', 'g', 'a', 'a', 'g', 'a'};
        CodingDNASequence c = new CodingDNASequence(testArr2);
        c.translate();
    }
}