import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame{
    public static PanelStuff panel;
    public Frame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setTitle("TREE");
        setLocationRelativeTo(null);
        panel = new PanelStuff(screenSize.width, screenSize.height,25);
        add(panel);
        setVisible(true);
    }
    public static void reset(){
        panel = new PanelStuff(500,500,25);
    }
    
    
    
}