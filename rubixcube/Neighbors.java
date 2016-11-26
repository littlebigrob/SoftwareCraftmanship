package Rubix;

import java.util.HashMap;

/**
 * Created by Robert on 11/25/2016.
 */
public class Neighbors {

    private static Cube partOf;

    public static Color[] getNeighbors(Cube cube, Side side) {
        partOf=cube;
        Color tempArray[]=new Color[12];
        if (side.getposition().equals(Position.Front)){
            tempArray=getFrontNeighbors();
        }
        else if (side.getposition().equals(Position.Left)){
            tempArray=getLeftNeighbors();
        }
        else if (side.getposition().equals(Position.Bottom)){
            tempArray=getBottomNeighbors();
        }
        else if (side.getposition().equals(Position.Back)){
            tempArray=getBackNeighbors();
        }
        else if (side.getposition().equals(Position.Right)){
            tempArray=getRightNeighbors();
        }
        else if (side.getposition().equals(Position.Top)){
            tempArray=getTopNeighbors();
        }
        return tempArray;
    }

    private static Color[] setSides(boolean reverse, Color[] tempArray,Color[] sideToAdd){
        int index=0;
        startFinderLoop:
        for(int i=0; i<tempArray.length; i++){
            if (tempArray[i].equals(0)){
                index=i;
                break startFinderLoop;
            }
        }
        if (reverse){
            tempArray[index]=sideToAdd[2];
            tempArray[index+1]=sideToAdd[1];
            tempArray[index+2]=sideToAdd[0];
        }
        else{
                tempArray[index]=sideToAdd[0];
                tempArray[index+1]=sideToAdd[1];
                tempArray[index+2]=sideToAdd[2];
        }
        return tempArray;
    }

    private static Color[] getFrontNeighbors() {
        Color tempArray[]=new Color[12];
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempLeftArray[]=leftSide.getLeft();
        Color tempBottomArray[]=bottomSide.getTop();
        Color tempRightArray []=rightSide.getLeft();
        Color tempTopArray[]=topSide.getTop();
        tempArray=setSides(false,tempArray,tempLeftArray);
        tempArray=setSides(true,tempArray,tempBottomArray);
        tempArray=setSides(true,tempArray,tempRightArray);
        tempArray=setSides(false,tempArray,tempTopArray);
        return tempArray;
    }

    private static Color[] getLeftNeighbors() {
        Color tempArray[]=new Color[12];
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempFrontArray[]=frontSide.getRight();
        Color tempBottomArray[]=bottomSide.getLeft();
        Color tempBackArray []=backSide.getRight();
        Color tempTopArray[]=topSide.getLeft();
        tempArray=setSides(false,tempArray,tempFrontArray);
        tempArray=setSides(false,tempArray,tempBottomArray);
        tempArray=setSides(true,tempArray,tempBackArray);
        tempArray=setSides(true,tempArray,tempTopArray);
        return tempArray;
    }

    private static Color[] getBackNeighbors() {
        Color tempArray[]=new Color[12];
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempLeftArray[]=leftSide.getRight();
        Color tempBottomArray[]=bottomSide.getBottom();
        Color tempRightArray []=rightSide.getRight();
        Color tempTopArray[]=topSide.getBottom();
        tempArray=setSides(false,tempArray,tempLeftArray);
        tempArray=setSides(false,tempArray,tempBottomArray);
        tempArray=setSides(true,tempArray,tempRightArray);
        tempArray=setSides(true,tempArray,tempTopArray);
        return tempArray;
    }

    private static Color[] getRightNeighbors() {
        Color tempArray[]=new Color[12];
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempBackArray[]=backSide.getLeft();
        Color tempBottomArray[]=bottomSide.getRight();
        Color tempFrontArray []=frontSide.getLeft();
        Color tempTopArray[]=topSide.getRight();
        tempArray=setSides(false,tempArray,tempBackArray);
        tempArray=setSides(true,tempArray,tempBottomArray);
        tempArray=setSides(true,tempArray,tempFrontArray);
        tempArray=setSides(false,tempArray,tempTopArray);
        return tempArray;
    }

    private static Color[] getBottomNeighbors() {
        Color tempArray[]=new Color[12];
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Color tempBackArray[]=backSide.getBottom();
        Color tempRightArray[]=rightSide.getBottom();
        Color tempFrontArray []=frontSide.getBottom();
        Color tempLeftArray[]=leftSide.getBottom();
        tempArray=setSides(false,tempArray,tempBackArray);
        tempArray=setSides(false,tempArray,tempRightArray);
        tempArray=setSides(true,tempArray,tempFrontArray);
        tempArray=setSides(true,tempArray,tempLeftArray);
        return tempArray;
    }

    private static Color[] getTopNeighbors() {
        Color tempArray[]=new Color[12];
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Color tempBackArray[]=backSide.getTop();
        Color tempRightArray[]=rightSide.getTop();
        Color tempFrontArray []=frontSide.getTop();
        Color tempLeftArray[]=leftSide.getTop();
        tempArray=setSides(true,tempArray,tempBackArray);
        tempArray=setSides(true,tempArray,tempRightArray);
        tempArray=setSides(false,tempArray,tempFrontArray);
        tempArray=setSides(false,tempArray,tempLeftArray);
        return tempArray;
    }

    public static void setNeighborhs(Color[] tempArray,Side side){
        if (side.getposition().equals(Position.Front)){
            setFrontNeighbors(tempArray);
        }
        else if (side.getposition().equals(Position.Left)){
            setLeftNeighbors(tempArray);
        }
        else if (side.getposition().equals(Position.Bottom)){
            setBottomNeighbors(tempArray);
        }
        else if (side.getposition().equals(Position.Back)){
            setBackNeighbors(tempArray);
        }
        else if (side.getposition().equals(Position.Right)){
            setRightNeighbors(tempArray);
        }
        else if (side.getposition().equals(Position.Top)){
            setTopNeighbors(tempArray);
        }
    }

    private static void setFrontNeighbors(Color[] tempArray) {
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempSideArray[]=new Color[3];
        leftSide.setLeft(distribute(false,tempArray,tempSideArray,0));
        bottomSide.setTop(distribute(true,tempArray,tempSideArray,3));
        rightSide.setLeft(distribute(true,tempArray,tempSideArray,6));
        topSide.setTop(distribute(false,tempArray,tempSideArray,9));
    }

    private static void setLeftNeighbors(Color[] tempArray) {
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempSideArray[]=new Color[3];
        frontSide.setLeft(distribute(false,tempArray,tempSideArray,0));
        bottomSide.setTop(distribute(false,tempArray,tempSideArray,3));
        backSide.setLeft(distribute(true,tempArray,tempSideArray,6));
        topSide.setTop(distribute(true,tempArray,tempSideArray,9));
    }

    private static void setBackNeighbors(Color [] tempArray) {
        Side leftSide = partOf.cubeSides.get(Position.Left);
        Side bottomSide = partOf.cubeSides.get(Position.Bottom);
        Side rightSide = partOf.cubeSides.get(Position.Right);
        Side topSide = partOf.cubeSides.get(Position.Top);
        Color tempSideArray[] = new Color[3];
        leftSide.setRight(distribute(false, tempArray, tempSideArray, 0));
        bottomSide.setBottom(distribute(false, tempArray, tempSideArray, 3));
        rightSide.setRight(distribute(true, tempArray, tempSideArray, 6));
        topSide.setBottom(distribute(true, tempArray, tempSideArray, 9));
    }

    private static void setRightNeighbors(Color[] tempArray) {
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side bottomSide=partOf.cubeSides.get(Position.Bottom);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side topSide=partOf.cubeSides.get(Position.Top);
        Color tempSideArray[] = new Color[3];
        backSide.setLeft(distribute(false, tempArray, tempSideArray, 0));
        bottomSide.setRight(distribute(true, tempArray, tempSideArray, 3));
        frontSide.setLeft(distribute(true, tempArray, tempSideArray, 6));
        topSide.setRight(distribute(false, tempArray, tempSideArray, 9));
    }

    private static void setBottomNeighbors(Color[] tempArray) {
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Color tempSideArray[] = new Color[3];
        backSide.setBottom(distribute(false, tempArray, tempSideArray, 0));
        rightSide.setBottom(distribute(false, tempArray, tempSideArray, 3));
        frontSide.setBottom(distribute(true, tempArray, tempSideArray, 6));
        leftSide.setBottom(distribute(true, tempArray, tempSideArray, 9));
    }

    private static void setTopNeighbors(Color[] tempArray) {
        Side backSide=partOf.cubeSides.get(Position.Back);
        Side rightSide=partOf.cubeSides.get(Position.Right);
        Side frontSide=partOf.cubeSides.get(Position.Front);
        Side leftSide=partOf.cubeSides.get(Position.Left);
        Color tempSideArray[] = new Color[3];
        backSide.setTop(distribute(true, tempArray, tempSideArray, 0));
        rightSide.setTop(distribute(true, tempArray, tempSideArray, 3));
        frontSide.setTop(distribute(false, tempArray, tempSideArray, 6));
        leftSide.setTop(distribute(false, tempArray, tempSideArray, 9));
    }

    private static Color[] distribute(boolean reverse, Color[] tempArray,Color[] sideToAdd, int index){
        if (reverse){
            sideToAdd[2]=tempArray[index];
            sideToAdd[1]=tempArray[index+1];
            sideToAdd[0]=tempArray[index+2];
        }
        else{
            sideToAdd[0]=tempArray[index];
            sideToAdd[1]=tempArray[index+1];
            sideToAdd[2]=tempArray[index+2];
            }
        return sideToAdd;
    }

}