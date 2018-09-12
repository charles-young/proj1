package edu.iastate.cs228.proj1;

/*
 * @author
 */

public class CodingDNASequence extends DNASequence {
    /**
     * If the character array argument has a character on which the method {@link #isValidLetter(char)} returns {@code
     * false}, then it throws an {@link IllegalArgumentException} with the message {@code "Invalid sequence letter for
     * class edu.iastate.cs228.proj1.CodingDNASequence"}. Otherwise, the constructor saves a copy of the character array
     * argument in the field of its superclass {@code Sequence}.
     *
     * @param cdnaarr See {@link #CodingDNASequence(char[])}.
     * @throws IllegalArgumentException See {@link #CodingDNASequence(char[])}.
     * @see Sequence
     */
    public CodingDNASequence(char[] cdnaarr) {
        super(cdnaarr);
    }


    /**
     * If the length of the field character array {@code seqarr} is less than 3, then the method returns {@code false}.
     * Otherwise, if the first three characters in the array {@code seqarr} are {@code A/a, T/t, G/g} in this order
     * (case insensitive), then the method returns {@code true}. Otherwise, it returns {@code false}.
     *
     * @return See {@link #checkStartCodon()}.
     */
    public boolean checkStartCodon() {
        if (seqLength() < 3) return false;
        else return toString().substring(0, 3).toLowerCase().equals("atg");
    }

    /**
     * The method throws a {@link RuntimeException} exception with the {@code "No start codon"} if a call to the method
     * {@link #checkStartCodon()} returns {@code false}. Otherwise, the method translates the coding sequence in the
     * character array {@code seqarr} into a protein sequence by calling the private method {@link #getAminoAcid(String)}
     * on every codon in the coding sequence. The translation stops if the method {@link #getAminoAcid(String)} returns
     * the character {@code '$'}, which is not part of the protein sequence. Otherwise, the translation stops when the
     * end of the array {@code seqarr} is reached. The method returns the protein sequence in a new character array,
     * where the length of the protein sequence is equal to the length of the array. Note that the first codon is a
     * string consisting of the three characters in {@code seqarr[0]}, {@code seqarr[1]}, and {@code seqarr[2]}; the
     * second codon is made of {@code seqarr[3]}, {@code seqarr[4]}, and {@code seqarr[5]}; and so on. The last codon
     * may contain one or two characters if the length of the array {@code seqarr} is not a multiple of 3.
     *
     * @return See {@link #translate()}.
     * @throws RuntimeException See {@link #translate()}.
     */
    public char[] translate() {
        StringBuilder temp = new StringBuilder();

        assert checkStartCodon()
                : "No Start codon";
        int i = 0;
        int j = 3;
        while (j < seqLength() + 1) {
            if ('$' == getAminoAcid(toString().substring(i, j))) {
                break;
            } else {
                temp.append(getAminoAcid(toString().substring(i, j)));
            }
            i += 3;
            j += 3;
        }

        return temp.toString().toCharArray();
    }


    /**
     * If the string argument {@code codon} encodes an amino acid, then the method returns the character representing
     * the amino acid. Otherwise, it returns the character {@code '$'}. This method should be used as it is provided
     * without any changes to the code.
     *
     * @param codon See {@link #getAminoAcid(String)}.
     * @return See {@link #getAminoAcid(String)}.
     */
    private char getAminoAcid(String codon) {
        if (codon == null) return '$';
        char aa = '$';
        switch (codon.toUpperCase()) {
            case "AAA":
                aa = 'K';
                break;
            case "AAC":
                aa = 'N';
                break;
            case "AAG":
                aa = 'K';
                break;
            case "AAT":
                aa = 'N';
                break;

            case "ACA":
                aa = 'T';
                break;
            case "ACC":
                aa = 'T';
                break;
            case "ACG":
                aa = 'T';
                break;
            case "ACT":
                aa = 'T';
                break;

            case "AGA":
                aa = 'R';
                break;
            case "AGC":
                aa = 'S';
                break;
            case "AGG":
                aa = 'R';
                break;
            case "AGT":
                aa = 'S';
                break;

            case "ATA":
                aa = 'I';
                break;
            case "ATC":
                aa = 'I';
                break;
            case "ATG":
                aa = 'M';
                break;
            case "ATT":
                aa = 'I';
                break;

            case "CAA":
                aa = 'Q';
                break;
            case "CAC":
                aa = 'H';
                break;
            case "CAG":
                aa = 'Q';
                break;
            case "CAT":
                aa = 'H';
                break;

            case "CCA":
                aa = 'P';
                break;
            case "CCC":
                aa = 'P';
                break;
            case "CCG":
                aa = 'P';
                break;
            case "CCT":
                aa = 'P';
                break;

            case "CGA":
                aa = 'R';
                break;
            case "CGC":
                aa = 'R';
                break;
            case "CGG":
                aa = 'R';
                break;
            case "CGT":
                aa = 'R';
                break;

            case "CTA":
                aa = 'L';
                break;
            case "CTC":
                aa = 'L';
                break;
            case "CTG":
                aa = 'L';
                break;
            case "CTT":
                aa = 'L';
                break;

            case "GAA":
                aa = 'E';
                break;
            case "GAC":
                aa = 'D';
                break;
            case "GAG":
                aa = 'E';
                break;
            case "GAT":
                aa = 'D';
                break;

            case "GCA":
                aa = 'A';
                break;
            case "GCC":
                aa = 'A';
                break;
            case "GCG":
                aa = 'A';
                break;
            case "GCT":
                aa = 'A';
                break;

            case "GGA":
                aa = 'G';
                break;
            case "GGC":
                aa = 'G';
                break;
            case "GGG":
                aa = 'G';
                break;
            case "GGT":
                aa = 'G';
                break;

            case "GTA":
                aa = 'V';
                break;
            case "GTC":
                aa = 'V';
                break;
            case "GTG":
                aa = 'V';
                break;
            case "GTT":
                aa = 'V';
                break;

            case "TAA":
                aa = '$';
                break;
            case "TAC":
                aa = 'Y';
                break;
            case "TAG":
                aa = '$';
                break;
            case "TAT":
                aa = 'Y';
                break;

            case "TCA":
                aa = 'S';
                break;
            case "TCC":
                aa = 'S';
                break;
            case "TCG":
                aa = 'S';
                break;
            case "TCT":
                aa = 'S';
                break;

            case "TGA":
                aa = '$';
                break;
            case "TGC":
                aa = 'C';
                break;
            case "TGG":
                aa = 'W';
                break;
            case "TGT":
                aa = 'C';
                break;

            case "TTA":
                aa = 'L';
                break;
            case "TTC":
                aa = 'F';
                break;
            case "TTG":
                aa = 'L';
                break;
            case "TTT":
                aa = 'F';
                break;
            default:
                aa = '$';
                break;
        }
        return aa;
    }
}
