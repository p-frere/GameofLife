//Graphics Controller
import javax.swing.*;
import java.awt.*;

public class GUI {

    public JFrame frame;
    public JPanel panel;


    public GUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(600,600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(Main.gridsize, Main.gridsize));

        frame.add(panel);
        frame.pack();
    }

    //adds a the blob to the main panel
    public  void addPanel(Blob miniPanel){
        panel.add(miniPanel);
        panel.setVisible(true);
    }
}

