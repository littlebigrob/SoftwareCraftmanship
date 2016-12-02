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
        Color[] array={Color.W,Color.O,Color.R,Color.O,Color.B,Color.O,Color.G,Color.O,Color.Y};
        side=new Side(Position.Bottom, array, 3,3,cube);
    }

    @Test
    public void testToString(){
        System.out.print(side.toString());
        System.out.print('\n');
        System.out.print('\n');
        System.out.print(side.backAndRightToString());
        System.out.print('\n');
        System.out.print('\n');
        System.out.print(side.bottomToString());
    }

}