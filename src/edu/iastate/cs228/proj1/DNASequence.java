package edu.iastate.cs228.proj1;

/*
 * @author
 */

import java.util.HashSet;
import java.util.Set;

public class DNASequence extends Sequence {
    /**
     * If the character array argument has a character on which the method {@link #isValidLetter(char)} returns {@code false}, then it throws an {@link IllegalArgumentException} with the message {@code "Invalid sequence letter for class X"} where {@code X} denotes {@code "edu.iastate.cs228.proj1.DNASequence"} or the name of a subclass of which an object is created. Otherwise, the constructor saves a copy of the character array argument in the field of its superclass.
     *
     * @param dnaarr See {@link #DNASequence(char[])}.
     * @throws IllegalArgumentException See {@link #DNASequence(char[])}.
     */
    public DNASequence(char[] dnaarr) {
        super(dnaarr);
    }

    /**
     * The method returns {@code true} if the character argument is equal to one of the eight characters {@code 'a', 'A', 'c', 'C', 'g', 'G', 't', and 'T'}. Otherwise, it returns {@code false}. This method overrides the one in its superclass.
     *
     * @param let See {@link #isValidLetter(char)}.
     * @return {@link #isValidLetter(char)}.
     */
    @Override
    public boolean isValidLetter(char let) {
        Set<Character> illegalChars = new HashSet<>();
        illegalChars.add('a');
        illegalChars.add('c');
        illegalChars.add('g');
        illegalChars.add('t');

        return illegalChars.contains(Character.toLowerCase(let));
    }

}
