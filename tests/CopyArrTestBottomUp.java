import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CopyArrTestBottomUp {

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
    public void copyArr(){
        Program program = new Program();
        boolean toReturn = true;
        int[] arr = new int[4];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = i + 1;
        }
        int[] check = program.copyArr(arr);
        for(int i = 0 ; i < arr.length ; i++){
            //checking if the hole array values are the same
            if(arr[i]!=check[i])
                toReturn =false;
        }
        if(arr.length!= check.length)
            //checking oof the copied array size equals to the old array
            toReturn = false;
        assertTrue(toReturn);
    }
    @Test
    public void copyNullArr(){
        Program program = new Program();
        int[] arr = new int[0] ;
        arr = null;
        int[] check = program.copyArr(arr);
        assertEquals(check,null);

    }
}
