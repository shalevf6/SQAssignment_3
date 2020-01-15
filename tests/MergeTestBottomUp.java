import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MergeTestBottomUp {
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
    public void mergeSizeCheck(){

        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
        }
        arr = program.merge(arr,arr2);
        assertTrue(arr.length== 8 );
    }
    @Test
    public void merge(){
        boolean ans = true;
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = i * (-1);
        }
        arr = program.merge(arr,arr2);
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        assertEquals("-3 -2 -1 0 0 1 2 3 ", outContent.toString());

    }

    @Test
    public void mergeWithEmptyArray(){
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];

        arr = program.merge(arr,arr2);
        assertTrue(arr.length== 8 );
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void mergeWithNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        arr = null;
        arr2 = null;
        arr = program.merge(arr,arr2);
        assertTrue(arr.length== 8 );
    }

    @Test()
    public void mergeWithOneNullArraySizeCheck(){
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        arr2 = null;
        arr = program.merge(arr,arr2);
        assertTrue(arr.length== 4 );
    }

    @Test()
    public void mergeWithOneNullArray(){
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (+1);
        }
        arr2 = null;
        arr = program.merge(arr,arr2);
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        assertEquals("0 1 2 3 ", outContent.toString());
    }
}
