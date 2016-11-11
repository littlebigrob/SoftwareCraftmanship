package Project10;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;

import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by Robert on 11/10/2016.
 */
public class WriterTest {

    private FileReader fileReader;
    private CharArrayReader reader;
    private ArrayList<Character> charListHelloWorld;
    private ArrayList<Character> charListEmpty;

    @Before
    public void setUp(){
        charListHelloWorld=new ArrayList<Character>();
        charListHelloWorld.add('h');
        charListHelloWorld.add('e');
        charListHelloWorld.add('l');
        charListHelloWorld.add('l');
        charListHelloWorld.add('o');
        charListHelloWorld.add(' ');
        charListHelloWorld.add('w');
        charListHelloWorld.add('o');
        charListHelloWorld.add('r');
        charListHelloWorld.add('l');
        charListHelloWorld.add('d');
        charListEmpty=new ArrayList<Character>();
    }

    @Test
    public void writeSolutionTestHelloWorld() throws Exception{
        Writer.getInstance().writeSolution(charListHelloWorld);
        fileReader=new FileReader("hw10out.txt");
        reader=new CharArrayReader(charListHelloWorld.toString().toCharArray());
        int fileReaderChar;
        int readerChar;
        while (fileReader.ready()&&reader.ready()){
            fileReaderChar=fileReader.read();
            readerChar=reader.read();
            System.out.print(fileReaderChar);
            System.out.print('\n');
            System.out.print(readerChar);
            System.out.print('\n');
            assertTrue(readerChar==fileReaderChar);
        }
    }

    @Test
    public void writeSolutionTestEmpty() throws Exception{
        Writer.getInstance().writeSolution(charListEmpty);
        fileReader=new FileReader("hw10out.txt");
        reader=new CharArrayReader(charListEmpty.toString().toCharArray());
        while (fileReader.ready()&&reader.ready()){
            assertTrue(fileReader.read()==(reader.read()));
        }
    }

    @Test
    public void writeErrorTest()throws Exception{
        Writer.getInstance().writeError();
        fileReader=new FileReader("hw10out.txt");
        reader=new CharArrayReader("Error".toCharArray());
        while (fileReader.ready()&&reader.ready()){
            assertTrue(fileReader.read()==(reader.read()));
        }
    }

}