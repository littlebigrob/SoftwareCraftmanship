package Rubix;

/**
 * Created by Robert on 11/25/2016.
 */
public class Rotator {

    public static Rotator getINSTANCE() {
        return INSTANCE;
    }

    private static final Rotator INSTANCE=new Rotator();

    public void rotate(Cube cube,Side side, Direction direction){
        setBlocksAfterRotation(rotateSide(side, getBlocksToBeRotated(cube,side),direction),side);
    }

    private Color[] rotateSide(Side side, Color[] neighbors, Direction direction){
        Color[] tempArray=neighbors;
        int turns;
        if (direction.equals(Direction.Clockwise)){
            turns=1;
        }
        else{
            turns=3;}
        for (int index=0; index<turns; index++) {
            spinFace(side);
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

    private void spinFace(Side side) {
        Color tempMatrix[][]=new Color[3][3];
        for (int i=0; i<tempMatrix.length;i++){
            for (int index=0; index<tempMatrix.length;index++){
                tempMatrix[i][index]=side.getFace()[2-index][i];
            }
        }
        side.setFace(tempMatrix);
    }

    private Color[] getBlocksToBeRotated(Cube cube, Side side){
        Color[] tempArray=Neighbors.getNeighbors(cube,side);
        return tempArray;
    }

    private void setBlocksAfterRotation(Color[] neighbors,Side side){
        Neighbors.setNeighborhs(neighbors,side);
    }

    public class Instance {
        public void rotator (Cube cube,Side side, Direction direction){
            Rotator.this.rotate(cube,side,direction);
        }
        public Color[] rotateSide(Side side, Color[] neighbors, Direction direction) {
            return Rotator.this.rotateSide(side, neighbors, direction);
        }

        public void spinFace(Side side){
            Rotator.this.spinFace( side);
        }

        public Color[] getBlocksToBeRotated(Cube cube, Side side){
            return Rotator.this.getBlocksToBeRotated(cube, side);
        }

        public void setBlocksAfterRotation(Color[] neighbors,Side side){
            Rotator.this.setBlocksAfterRotation(neighbors, side);
        }

    }

}
