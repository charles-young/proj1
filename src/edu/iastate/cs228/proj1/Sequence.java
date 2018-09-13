package edu.iastate.cs228.proj1;
/*
 * @author Charles Young
 */

public class Sequence {
    protected char[] seqarr;

    /**
     * The constructor first uses the {@link #isValidLetter(char)} method to check
     * if every character in the array {@code sarr} is valid. If so, it makes and
     * keeps a copy of the array {@code sarr} in the field {@code seqarr} of type {@code char[]} with {@code protected} access. Otherwise, it throws an   {@link IllegalArgumentException} with the message {@code "Invalid sequence letter for class X"} where {@code X} denotes {@code  'edu.iastate.cs228.proj1.Sequence'} or the name of a subclass of which an object is created. Examples are given in the project description page to
     * illustrate what exactly is denoted by {@code X} after the subclasses of class
     * {@code Sequence} are defined. Note that the length of the field {@code seqarr} is equal to the length of the array {@code sarr}. This constructor should be implemented in such a way that it is unnecessary to have more than one line of code in the body of the constructor of any subclass of this class.
     *
     * @param sarr See {@link #Sequence(char[])}.
     * @throws IllegalArgumentException See {@link #Sequence(char[])}.
     */
    public Sequence(char[] sarr) {
        String objName = this.getClass().getName();
        boolean isValid = false;
        for (char c : sarr) {
            if (isValidLetter(c)) isValid = true;
            else {
                isValid = false;
                break;
            }
        }

        if(!isValid) throw new IllegalArgumentException("Invalid sequence letter for class " + objName);
        seqarr = new char[sarr.length];
        System.arraycopy(sarr, 0, seqarr, 0, sarr.length);
    }


    /**
     * The method returns the length of the character array {@code seqarr}.
     *
     * @return See {@link #seqLength()}.
     */
    public int seqLength() {
        return seqarr.length;
    }

    /**
     * The method creates and returns a copy of {@code char} array {@code seqarr}.
     *
     * @return See {@link #getSeq()}.
     */
    public char[] getSeq() {
        char[] temp = new char[seqarr.length];
        System.arraycopy(seqarr, 0, temp, 0, seqarr.length);
        return temp;
    }

    /**
     * The method returns the string representation of the {@code char} arrar {@code seqarr}.
     *
     * @return See {@link #toString()}.
     */
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (char c : seqarr) temp.append(c);
        return temp.toString();
    }

    /**
     * The method returns {@code true} if the arguments {@code obj} is not {@code null} and is of the same type as this object such that both objects represent the identical sequence of characters in a case insensitive mode ("ACgt" is identical to "AcGt"). The {@link #equals(Object)} method should be defined in such a way that there is no need to define it again in any subclass of class {@code Sequence}. In other words, when an object of the subclass calls the {@link #equals(Object)} method, it should return the right answer.
     *
     * @return See {@link #equals(Object)}
     */
    public boolean equals(Object obj) {
        return obj != null && getClass().getName().equals(obj.getClass().getName()) && toString().equalsIgnoreCase(obj.toString());
    }


    /**
     * The method returns {@code true} if the character {@code let} is an
     * uppercase (e.g., invoking {@link Character#isUpperCase(char)} with {@code let} is {@code true}) or lowercase ((e.g., invoking {@link Character#isLowerCase(char)} with {@code let} is {@code true})). Otherwise,
     * it returns {@code false}.
     *
     * @param let See {@link #isValidLetter(char)}.
     * @return See {@link #isValidLetter(char)}.
     */
    public boolean isValidLetter(char let) {
        return Character.isUpperCase(let) || Character.isLowerCase(let);
    }

}
