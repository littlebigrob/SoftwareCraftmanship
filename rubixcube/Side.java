package Rubix;

import java.util.Arrays;

/**
 * Created by Robert on 11/15/2016.
 */
public class Side {

    Cube partOf;
    Color[][] face;
    Position position;

    public Position getposition() {
        return position;
    }

    public Color[][] getFace() {
        return face;
    }
    public void setFace(Color[][] face) {
        this.face = face;
    }

    public Side(Position position, Color color, int height, int width,Cube cube){
        partOf=cube;
        this.position=position;
        face=new Color[height][width];
        for (int i=0; i<height; i++){
            for (int index=0; index<width;index++){
                face[i][index]=color;
            }
        }
    }

    public Side (Position position, Color[] color,int height, int width,Cube cube){
        partOf=cube;
        this.position=position;
        face=new Color[height][width];
        for (int i=0; i<height; i++){
            for (int index=0; index<width;index++){
                face[i][index]=color[(i)*3+(index)];
            }
        }
    }

    public Color[] getLeft(){
        return face[0];
    }

    public Color[] getRight(){
        return face[2];
    }

    public Color[] getTop(){
        Color[] tempArray=new Color[3];
        for(int i=0; i<tempArray.length; i++){
            tempArray[i]=face[i][0];
        }
        return tempArray;
    }

    public Color[] getBottom(){
        Color[] tempArray=new Color[3];
        for(int i=0; i<tempArray.length; i++){
            tempArray[i]=face[i][2];
        }
        return tempArray;
    }

    public void setLeft(Color[] colors){
        face[0]=colors;
    }

    public void setRight(Color[] colors){
        face[2]=colors;
    }

    public void setTop(Color[] colors){
        for(int i=0; i<colors.length; i++){
            face[i][0]=colors[i];
        }
    }

    public void setBottom(Color[] colors){
        for(int i=0; i<colors.length; i++){
            face[i][2]=colors[i];
        }
    }

    @Override
    public String toString(){
       return prettyToString(face);
    }

    private String prettyToString(Color [][] side){
        String arrayString=(Arrays.deepToString(side));
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(' ');
        for (int i=1; i<arrayString.length()-1;i++){
            if (arrayString.charAt(i)==','&&arrayString.charAt(i-1)==']'){
                stringBuilder.append('\n');
            }
            else{
                stringBuilder.append(arrayString.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String backAndRightToString(){
        Color reverseFace[][]=new Color[3][3];
        for (int i=0; i<reverseFace.length;i++){
            for (int index=0; index<reverseFace.length;index++){
                reverseFace[i][index]=face[i][2-index];
            }
        }
       return prettyToString(reverseFace);
    }

    public String bottomToString(){
        Color reverseFace[][]=new Color[3][3];
        for (int i=0; i<reverseFace.length;i++){
            for (int index=0; index<reverseFace.length;index++){
                reverseFace[i][index]=face[2-i][index];
            }
        }
        return prettyToString(reverseFace);
    }

}
