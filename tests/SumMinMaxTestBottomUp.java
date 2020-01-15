import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class SumMinMaxTestBottomUp {
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
    public void sumMinMax(){
        Program program = new Program();
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+2);
        }
        int ans = program.sumMinMax(arr);
        assertEquals(ans,6);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void sumMinMaxNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = null;
        int ans = program.sumMinMax(arr);
    }

    @Test
    public void sumMinMaxWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        int ans = program.sumMinMax(arr);
        assertEquals(ans,0);
    }

}
