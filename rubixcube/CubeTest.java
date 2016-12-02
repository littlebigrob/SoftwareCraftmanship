package Rubix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Robert on 12/1/2016.
 */
public class CubeTest {
    Cube cube;
    @Before
    public void setUp(){
        cube=new Cube();
    }

    @Test
    public void printer(){
        Color[] array=new Color[10];
        cube.printOutCube();
    }

    @Test
    public void rotate(){
        cube.printOutCube();
        cube.rotateCube(Position.Front,Direction.Clockwise);
        System.out.print('\n');
        System.out.print('\n');
        cube.printOutCube();

    }

}