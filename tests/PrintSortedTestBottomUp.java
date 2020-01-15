import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrintSortedTestBottomUp {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        Program program = new Program();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void printSortedNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = null;
        program.printSorted(arr);
        assertEquals("No array\n", outContent.toString());
    }

    @Test
    public void printSorted(){
        Program program = new Program();
        int[] arr = new int[4];
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = i * 2;
        }
        int temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
        program.printSorted(arr);
        assertEquals("6 2 4 0 \n0 2 4 6 \n6 2 4 0 \n", outContent.toString());
    }

    @Test
    public void printSortedWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        program.printSorted(arr);
        assertEquals("0 0 0 0 \n0 0 0 0 \n0 0 0 0 \n",outContent.toString());
    }
}
