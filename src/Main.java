import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int gridsize = 100;
    public static int gridMax = gridsize-1;
    public static Blob[][] map = new Blob[gridsize][gridsize];
    GUI gui;

    //Sets a probability
    public int getRand(){
        Random rand = new Random();
        if ((rand.nextInt(101)) < 10){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args){

        Main app = new Main();
        app.startGUI();
        app.fillMap();
        app.refresh();

        //Loops forever with a time delay
        while(true){

            try {
                TimeUnit.MILLISECONDS.sleep(100);
                app.update();
                app.refresh();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Fills map with a random selection of alive and dead blobs
    public void fillMap() {
        for (int i = 0; i < gridsize; i++) {
            for (int j = 0; j < gridsize; j++) {
                //create new blob
                map[j][i] = new Blob(j, i, getRand());
                //gives random state
                //adds it to the panel
                gui.addPanel(map[j][i]);
            }
        }
    }

    //Starts GUI
    public void startGUI(){
        try {
            gui = new GUI();
            gui.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //refreshes the GUI
    public void refresh(){
        gui.panel.repaint();
        gui.panel.revalidate();
    }

    //Updates the status of all the blobs
    public void update(){
        for (int i = 0; i < gridsize; i++) {
            for (int j = 0; j < gridsize; j++) {
                map[j][i].getMiniMap();
                map[j][i].newState();
                map[j][i].setCurrentState(map[j][i].getNextState());
                map[j][i].setColor();
            }
        }
    }
}
