import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuBar extends JMenuBar implements ActionListener {
    RgbInputPanel rgbInputPanel = new RgbInputPanel();
    Frame frame;
    JMenu filterMenu;
    JMenu menu;
    PicturePanel pp;

    int brightness = 0;

    JMenuItem i1, i2, i3, i4, i5, i6;
    JMenuItem i7, i8, i9, i10, i11, i12, i13,i14;

    public MenuBar(PicturePanel pp,Frame frame) {
        this.frame = frame;
        this.pp = pp;
        filterMenu = new JMenu("Filtr");
        i1 = new JMenuItem("Wygładzający");
        i2 = new JMenuItem("Medianowy");
        i3 = new JMenuItem("Sobela");
        i4 = new JMenuItem("Wyostrzący");
        i5 = new JMenuItem("Gaussa");
        i6 = new JMenuItem("Nasz");

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);

        filterMenu.add(i1);
        filterMenu.add(i2);
        filterMenu.add(i3);
        filterMenu.add(i4);
        filterMenu.add(i5);
        filterMenu.add(i6);

        this.add(filterMenu);

        menu = new JMenu("Przekształcenie punktowe");

        i7 = new JMenuItem("Dodawanie");
        i8 = new JMenuItem("Odejmowanie");
        i9 = new JMenuItem("Mnożenie");
        i10 = new JMenuItem("Dzielenie");
        i11 = new JMenuItem("Zmiana jasności(%)");
        i12 = new JMenuItem("GrayScaleAvg");
        i13 = new JMenuItem("GrayScaleR");

        i7.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        i12.addActionListener(this);
        i13.addActionListener(this);

        menu.add(i7);
        menu.add(i8);
        menu.add(i9);
        menu.add(i10);
        menu.add(i11);
        menu.add(i12);
        menu.add(i13);

        this.add(menu);

        i14 = new JMenuItem("Reset");

        i14.addActionListener(this);

        this.add(i14);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1)
            pp.smoothingFilter();
        else if (e.getSource() == i2)
            pp.medianaFilter();
        else if (e.getSource() == i3)
            pp.sopelFilter();
        else if (e.getSource() == i4)
            pp.sharpenerFilter();
        else if (e.getSource() == i5)
            pp.gaussFilter();
        else if (e.getSource() == i6)
            pp.customFilter();
        else if (e.getSource() == i7)
        {
            JOptionPane.showConfirmDialog(null, rgbInputPanel,
                    "Podaj wartości kolorów", JOptionPane.OK_CANCEL_OPTION);
            try {
                pp.additiveIncrease(
                        Integer.parseInt(rgbInputPanel.r.getText()),
                        Integer.parseInt(rgbInputPanel.g.getText()),
                        Integer.parseInt(rgbInputPanel.b.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i8){
            JOptionPane.showConfirmDialog(null, rgbInputPanel,
                    "Podaj wartości kolorów", JOptionPane.OK_CANCEL_OPTION);
            try {
                pp.subtractiveIncrease(
                        Integer.parseInt(rgbInputPanel.r.getText()),
                        Integer.parseInt(rgbInputPanel.g.getText()),
                        Integer.parseInt(rgbInputPanel.b.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i9){
            JOptionPane.showConfirmDialog(null, rgbInputPanel,
                    "Podaj wartości kolorów", JOptionPane.OK_CANCEL_OPTION);
            try {
                pp.multiplicativeIncrease(
                        Integer.parseInt(rgbInputPanel.r.getText()),
                        Integer.parseInt(rgbInputPanel.g.getText()),
                        Integer.parseInt(rgbInputPanel.b.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i10){
            JOptionPane.showConfirmDialog(null, rgbInputPanel,
                    "Podaj wartości kolorów", JOptionPane.OK_CANCEL_OPTION);
            try {
                pp.dividiveIncrease(
                        Integer.parseInt(rgbInputPanel.r.getText()),
                        Integer.parseInt(rgbInputPanel.g.getText()),
                        Integer.parseInt(rgbInputPanel.b.getText()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i11){
            brightness = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter your message"));
            try {
                pp.brightnessChange(brightness);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i12) {
            try {
                pp.grayScale();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == i13) {
            try {
                pp.grayScaleByRed();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //reset
        else if (e.getSource() == i14) {
            try {
                pp.reset();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
