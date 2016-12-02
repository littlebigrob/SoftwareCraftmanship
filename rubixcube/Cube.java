package Rubix;

import java.util.HashMap;

/**
 * Created by Robert on 11/25/2016.
 */
public class Cube {

    public static Cube getINSTANCE() {
        return INSTANCE;
    }

    private static final Cube INSTANCE=new Cube();

    HashMap<Position, Side> cubeSides=new HashMap<>();
//prints out the cube
    public void printOutCube(){
        StringBuilder stringBuilder=new StringBuilder();
        //this adds the strings for the top side;
        stringBuilder.append(addTopAndBottom(cubeSides.get(Position.Top).toString()));
        stringBuilder.append('\n');
        //adds the four middle sides, Front, Left, Back, Right
        String strings;
        StringBuilder [] stringsArray=new StringBuilder[12];
        StringBuilder stringsBuilder= new StringBuilder();
        //sets up the strings to always have a new line after the "row" ends
        stringsBuilder.append(cubeSides.get(Position.Front).toString());
        stringsBuilder.append('\n');
        stringsBuilder.append(cubeSides.get(Position.Left).toString());
        stringsBuilder.append('\n');
        stringsBuilder.append(cubeSides.get(Position.Back).backAndRightToString());
        stringsBuilder.append('\n');
        stringsBuilder.append(cubeSides.get(Position.Right).backAndRightToString());
        strings=stringsBuilder.toString();
        int newLineCounter=0;
        //takes out all new line char
        for (int i=0;i<stringsArray.length;i++){
            stringsArray[i]=new StringBuilder();
        }
        for (int i=0; i<strings.length();i++){
            if (strings.charAt(i)=='\n'){
                newLineCounter++;
            }
            else{
                stringsArray[newLineCounter].append(strings.charAt(i));
            }
        }
        //adds new lines at the end of right
        stringsArray[9].append('\n');
        stringsArray[10].append('\n');
        stringsArray[11].append('\n');
        for (int i=0; i<3;i++){
            stringBuilder.append(stringsArray[i]);
            stringBuilder.append(stringsArray[3+i]);
            stringBuilder.append(stringsArray[6+i]);
            stringBuilder.append(stringsArray[9+i]);
        }
        //puts in the bottom arrays
        stringBuilder.append(addTopAndBottom(cubeSides.get(Position.Bottom).bottomToString()));
        System.out.print(stringBuilder.toString());
    }

    public String addTopAndBottom (String topSide){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("                    ");
        for (int i=0; i<topSide.length();i++){
            stringBuilder.append(topSide.charAt(i));
            if (topSide.charAt(i)=='\n'){
                //the length of a single line of side.toString is 10 spaces and since i am replacing 2 sides i use 20
                    stringBuilder.append("                    ");

            }
        }
        return stringBuilder.toString();
    }

    public Cube(){
        cubeSides.put(Position.Front,new Side(Position.Front,Color.W,3,3,this));
        cubeSides.put(Position.Left,new Side(Position.Left,Color.R,3,3,this));
        cubeSides.put(Position.Right,new Side(Position.Right,Color.B,3,3,this));
        cubeSides.put(Position.Back,new Side(Position.Back,Color.G,3,3,this));
        cubeSides.put(Position.Top,new Side(Position.Top,Color.O,3,3,this));
        cubeSides.put(Position.Bottom,new Side(Position.Bottom,Color.Y,3,3,this));
    }


    public Cube(Color[][] colors){
        validateCube(colors);
        Side front=new Side(Position.Front,colors[0],3,3,this);
        Side left=new Side(Position.Left,colors[1],3,3,this);
        Side right=new Side(Position.Right,colors[2],3,3,this);
        Side back=new Side(Position.Back,colors[3],3,3,this);
        Side top=new Side(Position.Top,colors[4],3,3,this);
        Side bottom=new Side(Position.Bottom,colors[5],3,3,this);
        cubeSides.put(Position.Front,front);
        cubeSides.put(Position.Left,left);
        cubeSides.put(Position.Right,right);
        cubeSides.put(Position.Back,back);
        cubeSides.put(Position.Top,top);
        cubeSides.put(Position.Bottom,bottom);
    }

    public void rotateCube(Position position, Direction direction){
        Side side=cubeSides.get(position);
        Rotator.getINSTANCE().rotate(this,side,direction);
    }

    private void validateCube(Color[][] colors) {
        correctSides(colors);
        correctDementions(colors);
        areCentersUnique(colors);
        colorCount(colors);
    }

    private void colorCount(Color[][] colors) {
        HashMap<Color,Integer> colorCounter=new HashMap<>();
        for (int i=0; i<colors.length;i++) {
            for (int index = 0; index < colors[i].length; index++) {
                if (colorCounter.containsKey(colors[i][index])) {
                    colorCounter.put(colors[i][index], colorCounter.get(colors[i][index]) + 1);
                }
                else{
                    colorCounter.put(colors[i][index], 1);
                }
            }
        }
        for (int i: colorCounter.values()) {
            if (i!=9){
                ErrorLogger error=new ErrorLogger("there are not enough of a given color \n");
            }
        }
    }

    private void areCentersUnique(Color[][] colors) {
        HashMap<Color,Integer> centerColortoSide=new HashMap<>();
        for (int i=0; i<colors.length;i++){
            centerColortoSide.put(colors[i][4],i);
        }
        if (centerColortoSide.size()!=6){
            ErrorLogger error=new ErrorLogger("there are non distinct center sides for this cube\n");
        }
    }

    private void correctDementions(Color[][] colors) {
        for (int i=0; i<colors.length;i++){
            if (colors[i].length!=9){
                ErrorLogger error=new ErrorLogger("side "+i+" does not have enough colors\n");
            }
        }
    }

    private void correctSides(Color[][] colors) {
        if (colors.length!=6){
            ErrorLogger error=new ErrorLogger("not enough sides in this cube\n");
        }
    }

    public class Tester{
       public void correctSides(Color[][] colors){
           Cube.getINSTANCE().correctSides(colors);
       }
       public void correctDementions(Color[][] colors){
           Cube.getINSTANCE().correctDementions(colors);
        }
       public void areCentersUnique(Color[][]  colors){
           Cube.getINSTANCE().areCentersUnique(colors);
        }
       public void colorCount(Color[][]  colors){
           Cube.getINSTANCE().colorCount(colors);
       }
    }

}
