package Rubix;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Robert on 12/1/2016.
 */
public class SideTest {
    Cube cube;
    Side side;
    @Before
    public void setUp(){
        side=new Side(Position.Bottom, Color.R, 3,3,cube);
    }

    @Test
    public void testToString(){
        System.out.print(side.toString());
    }

}