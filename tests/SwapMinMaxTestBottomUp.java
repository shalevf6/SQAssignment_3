import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SwapMinMaxTestBottomUp {
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
    public void swapMinMax(){
        Program program = new Program();
        int[] arr = new int[4];
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+2);
        }
        arr =program.swapMinMax(arr);
        if(arr[0] == 6 && arr[3] == 0)
            check = true;
        else
            check = false;
        assertTrue(check);
    }

    @Test
    public void swapMinMaxNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = null;
        arr = program.swapMinMax(arr);
        assertTrue(arr==null);
    }

    @Test
    public void swapMinMaxEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr= program.swapMinMax(arr);
        assertTrue(arr[0]== 0);
    }
}
