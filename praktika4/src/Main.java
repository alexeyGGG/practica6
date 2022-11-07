import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    private static final String[] WORDS_ARRAY = new String[] {
            "APL", "PASCAL", "PHP", "APL", "ALGOL", "ADA", "SNOBOL", "PASCAL", "APL", "PHP"
    };

    private static int mResultArraySize;
    private static String[] mResultArray;

    public static void main (String[] args) throws java.lang.Exception
    {
        int minimalLength = WORDS_ARRAY[0].length();
        int maximalLength = minimalLength;

        for (int i = 0; i < WORDS_ARRAY.length; i++) {
            int currentWordLength = WORDS_ARRAY[i].length();
            minimalLength = currentWordLength < minimalLength ? currentWordLength : minimalLength;
            maximalLength = currentWordLength > maximalLength ? currentWordLength : maximalLength;
        }
        for (int i = 0; i < WORDS_ARRAY.length; i++) {
            int currentWordLength = WORDS_ARRAY[i].length();
            if ( (currentWordLength == minimalLength) || (currentWordLength == maximalLength) ) {
                mResultArraySize++;
            }
        }

        mResultArray = new String [mResultArraySize];

        mResultArraySize = 0;
        for (int i = 0; i < WORDS_ARRAY.length; i++) {
            int currentWordLength = WORDS_ARRAY[i].length();
            if ( (currentWordLength == minimalLength) || (currentWordLength == maximalLength) ) {
                boolean isContains = false;
                for (int j = 0; j < mResultArraySize; j++) {
                    if (WORDS_ARRAY[i].equals(mResultArray[j])) {
                        isContains = true;
                        break;
                    }
                }
                if (!isContains) mResultArray[mResultArraySize++] = WORDS_ARRAY[i];
            }
        }

        System.out.print("Result: " );
        for (int i = 0; i < mResultArraySize; i++) {
            System.out.print(mResultArray[i] + " ");
        }
    }
}
