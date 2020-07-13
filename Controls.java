import javax.swing.*;
public class Controls extends JFrame{
    public static Slider slider;
    public Controls(){
        setTitle("Controls");
        setSize(200,275);
        slider = new Slider();
        add(slider);
        setVisible(true);
    }
}