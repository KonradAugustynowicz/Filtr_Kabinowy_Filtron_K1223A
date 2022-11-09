import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame extends JFrame {
    public Frame() throws HeadlessException, IOException {
        setSize(new Dimension(1000, 1000));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        PicturePanel pp =new PicturePanel();//kekw
        add(pp);
        MenuBar menuBar = new MenuBar(pp,this);
        this.setJMenuBar(menuBar);

        System.out.println(menuBar.pp == pp);
    }
}
