import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxValueTestBottomUp {
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
    public void maxValue() {
        Program program = new Program();
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        int value = program.maxValue(arr);
        assertEquals(value,3);
    }

    @Test(expected = NullPointerException.class)
    public void maxValueWithNullArray(){
        Program program = new Program();
        int[] arr = new int[0];
        arr = null;
        int temp = program.maxValue(arr);
        assertEquals(0,temp);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void minValueWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[0];
        int temp = program.maxValue(arr);
        assertEquals(0,temp);
    }
}
