package edu.iastate.cs228.proj1.tests;

/*
 * @author Charles Young
 */

import edu.iastate.cs228.proj1.ProteinSequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProteinSequenceTest {

    @Test
    public void isValidLetterTest() {
        char[] illegalChars = "bjouxz".toCharArray();

        for (Character c : illegalChars) {
            ProteinSequence ps = new ProteinSequence(Character.toString('a').toCharArray());
            assertTrue(ps.isValidLetter(c));
            assertTrue(ps.isValidLetter(Character.toUpperCase(c)));
        }
        ProteinSequence ps = new ProteinSequence(Character.toString('a').toCharArray());
        assertTrue(ps.isValidLetter('a'));
        assertTrue(ps.isValidLetter('A'));
        assertFalse(ps.isValidLetter(';'));
    }
}