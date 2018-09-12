package edu.iastate.cs228.proj1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GenomicDNASequenceTest {

    public String tMessage = "Should be true"; //String used throughout the class representing that the statement should be true.
    public String fMessage = "Should be false"; //String used throughout the class representing that the statement should be false.

    char [] testArr = {'a', 'c', 'g', 't', 'a', 'c', 'g', 't', 'a', 'c', 'g', 't'}; //Test char array used for testing multiple things.
    int [] exonPosArr = {0, 1, 3, 5, 6, 8}; //Int array used for testing extractexons,

    GenomicDNASequence a = new GenomicDNASequence(testArr); //Constructing a new GenomicDNASequence from testArr.

    @Test
    public void testExtractExons(){
        char[] testExtractedExons = {'a', 't', 'a', 'g', 't'}; //Char arr of what should happen when extractExons is called.
        assertArrayEquals(a.extractExons(exonPosArr), testExtractedExons); //Testing extractExons against what it should be.
        testExtractedExons[0] = 'c';
        assertEquals(fMessage, false, Arrays.equals(a.extractExons(exonPosArr), testExtractedExons)); //Testing again, with an altered test array.

    }

    @Test(expected=IllegalArgumentException.class)
    public void testIAException()
    {
        char [] testArr2 = {'a', 'b', 'c', 'd', 'e', 'f', 'h', 'i'};
        GenomicDNASequence c = new GenomicDNASequence(testArr2); //Testing construction of a GenomicDNASequence with some invalid characters, should throw an exception.
    }



    @Test(expected=IllegalArgumentException.class)
    public void testIAException2()
    {
        char [] testArr = {'a', 't', 'g', 'a', 't', 'g'};
        int [] exonPosArr = {};
        GenomicDNASequence c = new GenomicDNASequence(testArr); //Creating a valid GenomicDNASequence, should not throw anything.
        c.extractExons(exonPosArr); //Extracting exons with an empty exon array, should throw IllegalArgumentException.
    }

    @Test(expected=IllegalArgumentException.class)
    public void testIAException3()
    {
        char [] testArr = {'a', 't', 'g', 'a', 't', 'g'};
        int [] exonPosArr2 = {0, 1, 2, 75};
        GenomicDNASequence c = new GenomicDNASequence(testArr); //Creating a valid GenomicDNASequence, should not throw anything.
        c.extractExons(exonPosArr2); //Extracting exons with an array that has an invalid position integer, should throw IllegalArgumentException.
    }


    @Test(expected=IllegalStateException.class)
    public void testIAException4()
    {
        char [] testArr = {'a', 't', 'g', 'a', 't', 'g'};
        int [] exonPosArr = {4,3,2,1};
        GenomicDNASequence a = new GenomicDNASequence(testArr); //Creating a valid GenomicDNASequence, should not throw anything.
        a.extractExons(exonPosArr); //Extracting exons with an out of order array. Should throw IllegalArgumentException.
    }


}