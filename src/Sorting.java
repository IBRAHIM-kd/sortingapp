import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


final public class Sorting
{

    public static void main(String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        //Reading File inputPath
        BufferedReader br;
        String inputPath = "./input.txt";
        br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inputPath)   )   );

        String strLine;
        while ((strLine = br.readLine()) != null)
        {
            sb.append(strLine);
        }

        //Clean String
        String cleanStr = clean(sb.toString());

        // Improved Count Sorting method
        String countStr = Count(cleanStr);
        System.out.println("Output: "+countStr+"\n");

        //Transform to String[]
        String[] transformStr = transform(cleanStr);
        System.exit(0);
    }

    //clean out Punctuation
    public static String clean(String str)
    {
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                'n','o','p','q','r','s','t','u','v','x','y','z'};

        StringBuilder sb = new StringBuilder();
        String temp;

        // Punctuation to Matcher.replaceAll
        str = str.replaceAll("\\p{Punct}","");

        //lowerCase
        temp = str.toLowerCase().replaceAll(" ", "");

        //filter against alphabet
        for(int i = 0; i < temp.length(); i++ )
            for(int j = 0; j < alphabet.length; j++ )
                if(temp.charAt(i) == alphabet[j])
                    sb.append(temp.charAt(i));

        return sb.toString();
    }

    //transform from String to String[]
    public static String[] transform(String str)
    {
        //instantiate String[]
        String strArr[] = new String[str.length()];

        //transform into String[]
        for(int i = 0; i < str.length(); i++ )
            strArr[i] = "" + str.charAt(i);

        return strArr;
    }

    public static String Count(String str)
    {
        final int alphabetLength = 26;
        final int alphabetAsciiStart = 97;
        final int alphabetAsciiEnd = 122;

        int[] alphaCount = new int[alphabetLength];
        StringBuilder sb = new StringBuilder();

        //count occurrences of alphabet letter
        for(int i = 0; i < str.length(); i++) {
            int val = (int) str.charAt(i);

            // Is letter
            if (val >= alphabetAsciiStart && val <= alphabetAsciiEnd) {
                alphaCount[val - alphabetAsciiStart]++;
            }
        }

        for(int i = 0; i < alphabetLength; i++)
        {
            char c =  (char) (i + alphabetAsciiStart);

            for (int j = 0; j < alphaCount[i]; j++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static int partition(String[] strArr, int p, int r) {

        String x = strArr[p];
        int i = p-1 ;
        int j = r+1 ;

        while (true)
        {
            i++;
            while ( i< r && strArr[i].compareTo(x) < 0)
                i++;
            j--;
            while (j>p && strArr[j].compareTo(x) > 0)
                j--;

            if (i < j)
                swap(strArr, i, j);
            else
                return j;
        }
    }

    private static void swap(String[] strArr, int i, int j)
    {
        String temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
    }

    public static void print_output(String[] strArr) throws IOException
    {
        String temp = "";

        for(int i=0; i < strArr.length; i++)
            temp+=""+strArr[i];

        System.out.println("Output: " + temp + "\n");
    }
}

