package AWT_Intro;
/* For handling the closing of the window */
import java.awt.event.*;

public class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
