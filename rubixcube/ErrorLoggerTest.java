package Rubix;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Robert on 12/1/2016.
 */
public class ErrorLoggerTest {

    ByteArrayOutputStream error = new ByteArrayOutputStream();

    @Before
    public void SetUp() {
        System.setErr(new PrintStream(error));
    }

    @Test(expected = RuntimeException.class)
    public void printError() {
        ErrorLogger errorLogger=new ErrorLogger("hello World");
        assertEquals("hello World", error.toString());
    }

    @Test(expected = RuntimeException.class)
    public void printNullError() {
        ErrorLogger errorLogger=new ErrorLogger(null);
        assertEquals(null, error.toString());
    }

}