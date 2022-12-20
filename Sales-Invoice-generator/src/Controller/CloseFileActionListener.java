
package Controller;

import View.MyFrame;

public class CloseFileActionListener {
    private MyFrame Frame;

    public CloseFileActionListener(MyFrame frame) {this.Frame= frame;}

    public void closeFileMenuBar() {System.exit(0);}

}
