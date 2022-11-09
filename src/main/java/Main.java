import javax.swing.*;
import java.io.IOException;

public class Main {
    public ClassLoader classLoader = getClass().getClassLoader();
    static Frame frame;

    public static void main(String[] args) throws IOException, InterruptedException {
        frame = new Frame();

        frame.setVisible (true);
    }
}
