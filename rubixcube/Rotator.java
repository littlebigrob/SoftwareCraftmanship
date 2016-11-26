package Rubix;

/**
 * Created by Robert on 11/25/2016.
 */
public class Rotator {

    Cube partOf;

    private void rotate(Cube cube,Side side, Direction direction){
        setBlocksAfterRotation(rotateSide(getBlocksToBeRotated(cube,side),direction),side);
    }

    private Color[] rotateSide(Color[] neighbors, Direction direction){
        Color[] tempArray=neighbors;
        int turns;
        if (direction.equals(Direction.Clockwise)){
            turns=1;
        }
        else{
            turns=3;}
        for (int index=0; index<turns; index++) {
            Color tempBlock1 = tempArray[1];
            Color tempBlock2 = tempArray[2];
            Color tempBlock3 = tempArray[3];
            for (int i=0; i<tempArray.length-3;i++){
                tempArray[i]=tempArray[i+3];
            }
            tempArray[9]=tempBlock1;
            tempArray[10]=tempBlock2;
            tempArray[11]=tempBlock3;
        }
        return tempArray;
    }

    private Color[] getBlocksToBeRotated(Cube cube, Side side){
        Color[] tempArray=Neighbors.getNeighbors(cube,side);
        return tempArray;
    }

    private void setBlocksAfterRotation(Color[] neighbors,Side side){

    }

}
