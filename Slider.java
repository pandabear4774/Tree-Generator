
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Slider extends JPanel implements ChangeListener{
    private JSlider slider;
    private JLabel sliderLabel;
    private int[] startingValue;
    private JSlider branchLength;
    private JLabel lengthLabel;
    private JSlider number;
    private JLabel numberLabel;
    private JButton comfirm;
    public Slider(){
        startingValue = new int[3];
        startingValue[0] = 90;
        startingValue[1] = 30;
        startingValue[2] = 5;
        
        sliderLabel = new JLabel("Angle: " + String.valueOf(startingValue[0]));
        sliderLabel.setPreferredSize(new Dimension(80,30));
        add(sliderLabel, BorderLayout.WEST);
        
        slider = new JSlider(JSlider.HORIZONTAL, 0, 90, startingValue[0]); 
        slider.setPreferredSize(new Dimension(100,80));
        add(slider, BorderLayout.NORTH);
        slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setMajorTickSpacing(90); 
        slider.setMinorTickSpacing(15); 
        slider.addChangeListener(this);
        
        lengthLabel = new JLabel("Length: " + String.valueOf(startingValue[1]));
        lengthLabel.setPreferredSize(new Dimension(80,30));
        add(lengthLabel);
        
        branchLength = new JSlider(JSlider.HORIZONTAL, 0, 100, startingValue[1]); 
        branchLength.setPreferredSize(new Dimension(100,80));
        add(branchLength);
        branchLength.setPaintTrack(true); 
        branchLength.setPaintTicks(true); 
        branchLength.setMajorTickSpacing(50); 
        branchLength.setMinorTickSpacing(5); 
        branchLength.addChangeListener(this);
        
        numberLabel = new JLabel("Splits: " + String.valueOf(startingValue[2]));
        numberLabel.setPreferredSize(new Dimension(80,60));
        add(numberLabel);
        
        number = new JSlider(JSlider.HORIZONTAL, 0, 10, startingValue[2]); 
        number.setPreferredSize(new Dimension(100,80));
        add(number);
        number.setPaintTrack(true); 
        number.setPaintTicks(true); 
        number.setMajorTickSpacing(10); 
        number.setMinorTickSpacing(1); 
        number.addChangeListener(this);
        number.setSnapToTicks(true);
        
    }
    public void stateChanged(ChangeEvent e){
        if(e.getSource() == slider){
            sliderLabel.setText("Angle: " + String.valueOf(slider.getValue()));
            PanelStuff.angle = slider.getValue();
            Frame.panel.update2();
        } else if (e.getSource() == branchLength){
            lengthLabel.setText("Length: " + String.valueOf(branchLength.getValue()));
            //PanelStuff.branchLength = Double.valueOf(slider.getValue());
            PanelStuff.branchLength = branchLength.getValue();
            Frame.panel.update2();
        } else if (e.getSource() == number){
            numberLabel.setText("Split: " + String.valueOf(number.getValue()));
            Frame.panel.extensions = number.getValue();
            Frame.panel.update();
        }
        
    }
    
}