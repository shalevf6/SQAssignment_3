import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SortArrayTestBottomUp {
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
    public void sortArray(){
        Program program = new Program();
        boolean ans = true;
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (2);
            arr2[i] = i * (2);

        }
        int temp = arr[3];
        arr[3] = arr[0];
        arr[0] = temp;
        arr = program.sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] !=arr2[i])
                ans = false;
        }
        assertTrue(ans);
    }

    @Test
    public void sortArrayWithNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = null;
        arr = program.sortArray(arr);
        assertEquals(arr,null);

    }

    @Test()
    public void sortArrayWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        arr = program.sortArray(arr);
        assertTrue(arr[0]==0);
    }
}
