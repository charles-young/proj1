package edu.iastate.cs228.proj1.tests;

/*
 * @author Charles Young
 */

import edu.iastate.cs228.proj1.CodingDNASequence;
import edu.iastate.cs228.proj1.GenomicDNASequence;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GenomicDNASequenceTest {
    @Test
    public void markCodingTest() {
        String demodna = "AATGCCAGTCAGCATAGCGTAGACT";
        int[] ardemo = {1, 5, 8, 10, 13, 16};
        GenomicDNASequence gdemo = new GenomicDNASequence(demodna.toCharArray());
        gdemo.markCoding(1, 16);
        CodingDNASequence cdemo = new CodingDNASequence(gdemo.extractExons(ardemo));
        assertEquals(cdemo.toString(), "ATGCCTCAATAG");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyExtractExons() {
        char[] empty = {};
        new GenomicDNASequence(empty);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testnullExtractExons() {
        char[] testArr = "abcd".toCharArray();
        GenomicDNASequence g = new GenomicDNASequence(testArr);
        int[] exonPos = null;
        g.extractExons(exonPos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundsExtractExons() {
        char[] testArr = "abcd".toCharArray();
        GenomicDNASequence g = new GenomicDNASequence(testArr);
        int[] exonPos = {-1};
        g.extractExons(exonPos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractExons() {
        char[] testArr = "abcd".toCharArray();
        GenomicDNASequence g = new GenomicDNASequence(testArr);
        int[] exonPos = {-1};
        g.extractExons(exonPos);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest() {
        char[] testArr = {'a', 'b', 'c', 'd', 'e', 'f', 'h', 'i'};
        new GenomicDNASequence(testArr);
    }


    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest2() {
        char[] testArr = {'a', 't', 'g', 'a', 't', 'g'};
        int[] exonPosArr = {};
        GenomicDNASequence c = new GenomicDNASequence(testArr);
        c.extractExons(exonPosArr);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionTest3() {
        char[] testArr = {'a', 't', 'g', 'a', 't', 'g'};
        int[] exonPosArr2 = {0, 1, 2, 75};
        GenomicDNASequence c = new GenomicDNASequence(testArr);
        c.extractExons(exonPosArr2);
    }
}