package Rubix;

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
                face[i][index]=color[(i+1)*(index+1)];
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

}
