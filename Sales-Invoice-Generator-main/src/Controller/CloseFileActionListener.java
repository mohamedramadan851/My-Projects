package Controller;

import View.MyFrame;


public class CloseFileActionListener {

    private MyFrame frame;

    public CloseFileActionListener(MyFrame frame) {this.frame = frame;}

    public void closeFileMenuBar() {System.exit(0);}

}
