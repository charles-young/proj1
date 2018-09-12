package edu.iastate.cs228.proj1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProteinSequenceTest {

    @Test
    public void isValidLetterTest() {
        Set<Character> illegalChars = new HashSet<>();
        illegalChars.add('b');
        illegalChars.add('j');
        illegalChars.add('o');
        illegalChars.add('u');
        illegalChars.add('x');
        illegalChars.add('z');

        for (Character illegalChar : illegalChars) {
            ProteinSequence ps = new ProteinSequence(Character.toString('a').toCharArray());
            assertFalse(ps.isValidLetter(illegalChar));
            assertFalse(ps.isValidLetter(Character.toUpperCase(illegalChar)));
        }
        ProteinSequence ps = new ProteinSequence(Character.toString('a').toCharArray());
        assertTrue(ps.isValidLetter('a'));
        assertTrue(ps.isValidLetter('A'));
        assertFalse(ps.isValidLetter(';'));
    }
}