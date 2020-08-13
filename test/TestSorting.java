import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSorting  {

    //testing the StringBuilder.toString
    @Test
    public void stringBuildertoStringTest()  {
        String stringBuilder = "String" +
                "Builder" +
                "Test";
        assertEquals("StringBuilderTest", stringBuilder);
    }

    //testing Reading File inputPath
    @Test
    public void testingReadingFileinputPathTest() {
        String path = "./input.txt";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        assertTrue(absolutePath.endsWith("./input.txt"));
    }

    //testing the sorted list of letters
    @Test
    public void sortedlistoflettersTest() throws Exception {
        String sorted = "popular".chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        assertEquals("aloppru", sorted);
    }

    //testing the punctuation
    @Test
    public void punctuationTest() throws Exception {
        String str = "Contrary to popular belief, the pink unicorn flies east.";
        str = str.replaceAll("\\p{Punct}","");
        assertEquals("Contrary to popular belief the pink unicorn flies east", str);
    }

    //testing Convert To Lowercase
    @Test
    public void convertToLowercaseTest() throws Exception {
        String str = "CONTRARY";
        str = str.toLowerCase().replaceAll(" ", "");
        Assert.assertEquals( "contrary",str);

    }

}






