package Rubix;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Robert on 12/1/2016.
 */
public class CubeTest {
    private Cube cube=Cube.getINSTANCE();
    private Cube.Tester tester=cube. new Tester();

    Color [][] nullColors;
    Color [][] notBigEnough;
    Color [][] defualtCube;
    Color [][] monochromaticCube;
    @Before
    public void setUp(){
        nullColors=new Color[6][9];
        notBigEnough=new Color[5][8];
        Color colors[]={Color.R,Color.W,Color.B,Color.G,Color.O,Color.Y};
        defualtCube=new Color[6][9];
        for (int i=0; i<defualtCube.length;i++){
            for (int index=0; index<defualtCube[i].length;index++){
                defualtCube[i][index]=colors[i];
            }
        }
        monochromaticCube=new Color[6][9];
        for (int i=0; i<monochromaticCube.length;i++){
            for (int index=0; index<monochromaticCube[i].length;index++){
                monochromaticCube[i][index]=Color.R;
            }
        }
    }

    @Test
    public void printer(){
        Color[] array=new Color[10];
        cube.printOutCube();
    }

    @Test
    public void rotate(){
        cube.printOutCube();
        cube.rotateCube(Position.Back,Direction.Clockwise);
        System.out.print('\n');
        System.out.print('\n');
        cube.printOutCube();
    }

    @Test
    public void goodcolorCount(){
        tester.colorCount(defualtCube);
    }

    @Test(expected = RuntimeException.class)
    public void badcolorCount(){
        tester.colorCount(monochromaticCube);
    }

    @Test
    public void goodareCentersUnique(){
        tester.areCentersUnique(defualtCube);
    }

    @Test(expected = RuntimeException.class)
    public void badareCentersUnique(){
        tester.areCentersUnique(monochromaticCube);
    }

    @Test
    public void goodCorrectSides(){
        tester.correctSides(nullColors);
    }

    @Test(expected = RuntimeException.class)
    public void badCorrectSides(){
        tester.correctSides(notBigEnough);
    }

    @Test
    public void goodCorrectDimensions(){
        tester.correctDementions(nullColors);
    }

    @Test(expected = RuntimeException.class)
    public void badCorrectDimensions(){
        tester.correctDementions(notBigEnough);
    }

}