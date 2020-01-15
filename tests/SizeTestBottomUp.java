import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;



public class SizeTestBottomUp {
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
    public void size() {
        //checking regular size with valid arr
        int[] arr = new int[4];
        Program program = new Program();
        int output = program.size(arr);
        assertEquals(4,output);
    }
    @Test(expected = NullPointerException.class)
    public void sizeWithNullArr(){
        int[] arr ;
        arr = null;
        Program program = new Program();
        int output = program.size(arr);
        assertEquals(0,output);
    }
}
