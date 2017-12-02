import javax.swing.*;
import java.awt.*;

public class Blob extends JPanel{
    //If current state is 1 it is alive
    //else the panel is dead
    private int currentState;
    private int nextState;
    private int x;
    private int y;
    private int neighbourCount;

    //Sets colour of the blobs panel
    public void setColor(){
        if (currentState == 1) {
            setBackground(Color.black);
        } else {
            setBackground(Color.white);
        }
    }


    //----------Getteres and Setters---------------
    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getNextState() {
        return nextState;
    }

    public Blob(int x, int y, int currentState) {
        this.x = x;
        this.y = y;
        this.currentState = currentState;
        this.setColor();

    }

    //Checks the surrounding areas for neighbours
    //The edges of the map array have to be dealt with separately
    public void getMiniMap() {
        neighbourCount = 0;
        int offsetx;
        int offsety;

        if(x == 0){
            if(y == 0) {
                //10
                //00
                offsetx = 0;
                offsety = 0;
                for (int yi = 0; yi < 2; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = 0;
                    offsety++;
                }
            } else if (y == Main.gridsize-1){
                //00
                //10
                offsetx = 0;
                offsety = -1;
                for (int yi = 0; yi < 2; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = 0;
                    offsety++;
                }
            } else {
                //00
                //10
                //00
                offsetx = 0;
                offsety = 1;
                for (int yi = 0; yi < 3; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = 0;
                    offsety--;
                }
            }
        } else if (x == Main.gridMax) {
            if (y == 0) {
                //01
                //00
                offsetx = -1;
                offsety = 0;
                for (int yi = 0; yi < 2; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = -1;
                    offsety++;
                }
            } else if (y == Main.gridsize - 1) {
                //00
                //01
                offsetx = -1;
                offsety = -1;
                for (int yi = 0; yi < 2; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = -1;
                    offsety++;
                }
            } else {
                //00
                //01
                //00
                offsetx = -1;
                offsety = -1;
                for (int yi = 0; yi < 3; yi++) {
                    for (int xi = 0; xi < 2; xi++) {
                        if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                            neighbourCount++;
                        }
                        offsetx++;
                    }
                    offsetx = -1;
                    offsety++;
                }
            }
        } else if (y == 0) {
            //010
            //000
            offsetx = -1;
            offsety = 0;
            for (int yi = 0; yi < 2; yi++) {
                for (int xi = 0; xi < 3; xi++) {
                    if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                        neighbourCount++;
                    }
                    offsetx++;
                }
                offsetx = -1;
                offsety++;
            }
        } else if(y == Main.gridMax) {
            //000
            //010
            offsetx = -1;
            offsety = -1;
            for (int yi = 0; yi < 2; yi++) {
                for (int xi = 0; xi < 3; xi++) {
                    if (Main.map[x + offsetx][y + offsety].getCurrentState() == 1) {
                        neighbourCount++;
                    }
                    offsetx++;
                }
                offsetx = -1;
                offsety++;
            }

        } else {
            //000
            //010
            //000
            offsetx = -1;
            offsety = -1;
            for(int yi = 0; yi < 3; yi++) {
                for (int xi = 0; xi < 3; xi++ ) {
                    if (Main.map[x+offsetx][y+offsety].getCurrentState() == 1){
                        neighbourCount++;
                    }
                    offsetx++;
                }
                offsetx = -1;
                offsety++;
            }
        }
    }

    //kills or spawns the blob
    public void newState(){
        if(currentState == 1 ){
            neighbourCount--;
            if((neighbourCount > 1) && (neighbourCount < 4)){
                nextState = 1;
            } else {
                nextState = 0;
            }
        } else {
            if(neighbourCount == 3){
                nextState = 1;
            } else {
                nextState = 0;
            }
        }
    }


}
