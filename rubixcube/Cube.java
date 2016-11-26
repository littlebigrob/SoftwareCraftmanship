package Rubix;

import java.util.HashMap;

/**
 * Created by Robert on 11/25/2016.
 */
public class Cube {

    HashMap<Position, Side> cubeSides;

    public HashMap<Position, Side> getCubeSides() {
        return cubeSides;
    }

    private void printOutCube(){

    }
    public Cube(){
        Side front=new Side(Position.Front,Color.White,3,3,this);
        Side left=new Side(Position.Left,Color.Red,3,3,this);
        Side right=new Side(Position.Right,Color.Blue,3,3,this);
        Side back=new Side(Position.Back,Color.Green,3,3,this);
        Side top=new Side(Position.Top,Color.Orange,3,3,this);
        Side bottom=new Side(Position.Bottom,Color.Yellow,3,3,this);
        cubeSides.put(Position.Front,front);
        cubeSides.put(Position.Left,left);
        cubeSides.put(Position.Right,right);
        cubeSides.put(Position.Back,back);
        cubeSides.put(Position.Top,top);
        cubeSides.put(Position.Bottom,bottom);

    }
    public Cube(Side front, Side left, Side back, Side right, Side top, Side bottom){

    }

    public void rotateCube(Side side, Direction direction){

        Rotator.rotate(this,side,direction);
    }

}
