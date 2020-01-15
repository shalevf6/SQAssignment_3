import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PrintArrTestBottomUp {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @Test

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
    public void printArr() {
        //checking regular printArr content
        Program program = new Program();
        int[] arr = new int[4];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i]=i+1;
        }
        program.printArr(arr);
        assertEquals("1 2 3 4 \n", outContent.toString());
    }
    @Test(expected = NullPointerException.class)
    public void printEmptyArr(){
        //checking if arr will print empty string when arr is null
        Program program = new Program();
        int[] arr = new int[0];
        arr = null;
        program.printArr(arr);
        assertEquals("\n",outContent.toString());
    }
}
