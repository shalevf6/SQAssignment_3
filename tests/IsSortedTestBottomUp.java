import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class IsSortedTestBottomUp {
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
    public void isSorted(){
        Program program = new Program();
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        boolean check = program.isSorted(arr);
        assertTrue(check);
    }


    @Test
    public void isSortedFalse(){
        Program program = new Program();
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        int temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
        boolean check = program.isSorted(arr);
        assertFalse(check);
    }

    @Test
    public void isSortedWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        boolean check = program.isSorted(arr);
        assertTrue(check);
    }

    @Test
    public void isSortedWithNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = null;
        boolean check = program.isSorted(arr);
        assertTrue(check);
    }
}
