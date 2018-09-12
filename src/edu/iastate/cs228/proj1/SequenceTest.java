package edu.iastate.cs228.proj1;

import org.junit.Test;
import java.util.stream.IntStream;
import static org.junit.Assert.*;

public class SequenceTest {
    private final char[] testArr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'};
    private final char[] testArr2 = {'a', 'c', 'b', 'e', 'd', 'g', 'f', 'i', 'h', 'k', 'j', 'm', 'l'};

    private final Sequence a = new Sequence(testArr1);
    private final Sequence b = new Sequence(testArr1);
    private final Sequence c = new Sequence(testArr2);

    @Test(expected = IllegalArgumentException.class)
    public void initTest() {
        final char[] testArr2 = {'1', 'a', '2', 'b', '3', 'c'};
        Sequence b = new Sequence(testArr2);
        assertNotEquals("1a2b3c", b.toString());
    }

    @Test
    public void seqLengthTest() {
        assertEquals(13, a.seqLength());
        assertNotEquals(14, a.seqLength());
    }

    @Test
    public void getSeqTest() {
        IntStream.range(0, testArr1.length).forEach(i -> assertEquals(testArr1[i], a.getSeq()[i]));
        assertNotEquals(testArr1[1], a.getSeq()[0]);
    }

    @Test
    public void toStringTest() {
        assertEquals(a.toString(), "abcdefghijklm");
        assertNotEquals("abcd", a.toString());
    }

    @Test
    public void equalsTest() {
        assertEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    public void isValidLetterTest() {
        assertTrue(a.isValidLetter('A'));
        assertTrue(a.isValidLetter('a'));
        assertFalse(a.isValidLetter('1'));
        assertFalse(a.isValidLetter(';'));
    }
}