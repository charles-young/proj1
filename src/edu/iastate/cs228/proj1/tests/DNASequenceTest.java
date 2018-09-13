package edu.iastate.cs228.proj1.tests;

/*
 * @author Charles Young
 */

import edu.iastate.cs228.proj1.DNASequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class DNASequenceTest {
    private char[] testArr = {'a', 'c', 'g', 't'};
    private DNASequence a = new DNASequence(testArr);

    @Test
    public void testIsValidLetter() {
        char[] legalChars = "acgt".toCharArray();

        DNASequence DNA = new DNASequence(Character.toString('a').toCharArray());
        for (Character c : legalChars) {
            assertTrue(DNA.isValidLetter(c));
            assertTrue(DNA.isValidLetter(Character.toUpperCase(c)));
        }
        assertFalse(DNA.isValidLetter('b'));
        assertFalse(DNA.isValidLetter('b'));
        assertFalse(DNA.isValidLetter('9'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIAException() {
        char[] testArr2 = {'a', 'b', 'g', 'g', 'a', 'b', 'g', 'a'};
        new DNASequence(testArr2);
    }

}