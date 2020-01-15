import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MaxValueIndexTestBottomUp {

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
    public void maxValueIndex() {
        Program program = new Program();
        int[] arr = new int[4];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = i *(- 1);
        }
        int output = program.maxValueIndex(arr);
        assertEquals(0,output);
    }
    @Test()
    public void maxValueIndexWithNullArray(){
        Program program = new Program();
        int[] arr = new int[0];
        arr =null;
        int output = program.maxValueIndex(arr);
        //inserted null array, excepted -1
        assertEquals(-1,output);
    }

    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void maxValueIndexEmptyArray(){
        Program program = new Program();
        int[] arr = new int[0];
        int output = program.maxValueIndex(arr);
        assertEquals(output,0);
    }
}
