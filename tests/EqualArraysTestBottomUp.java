import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class EqualArraysTestBottomUp {

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
    public void equalArraysNotEqual() {
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        int[] arr3 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
            arr2[i] = i + 1;
            arr3[i] = i + 1;
        }
        assertFalse(program.equalArrays(arr,arr2));

    }
    @Test
    public void equalArraysEqual() {
        Program program = new Program();
        int[] arr = new int[4];
        int[] arr2 = new int[4];
        int[] arr3 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
            arr2[i] = i + 1;
            arr3[i] = i + 1;
        }
        assertTrue(program.equalArrays(arr2,arr3));
    }
    @Test
    public void equalArrayWithDiffSizeArray(){
        Program program = new Program();
        int[] arr = new int[5];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * (-1);
        }
        //two arrays with different size should assert false
        assertFalse(program.equalArrays(arr2,arr));
    }
    @Test
    public void equalArrayWithDiffSizeArray2(){
        Program program = new Program();
        int[] arr = new int[5];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * (-1);
        }
        //two arrays with different size should assert false
        assertFalse(program.equalArrays(arr,arr2));
    }

    @Test
    public void equalArrayWithOneArrayAsNull(){
        Program program = new Program();
        int[] arr = new int[5];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * (-1);
        }
        arr2 = null;
        //two arrays with different size should assert false
        assertFalse(program.equalArrays(arr2,arr));
    }

    @Test
    public void equalArraysWithSizeZero(){
        Program program = new Program();
        int[] arr = new int[0];
        int[] arr2 = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * (-1);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * (-1);
        }
        //two arrays with different size should assert false
        assertFalse(program.equalArrays(arr2,arr));
    }

}


