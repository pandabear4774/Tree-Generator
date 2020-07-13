import javax.swing.*;
import java.awt.*;
import java.util.*;
public class PanelStuff extends JPanel{
    public static ArrayList<Branches> branch = new ArrayList<Branches>();
    public static int numberOfBranches;
    public static double branchLength;
    public static double angle;
    public static int extensions = 5;
    public static int middle;
    public static int screenHeight;
    public static int[] checkPoints = {2,4,8,16,32,64,128,256,512,1024,2048};
    public PanelStuff(int x, int y, int angle){
        middle = x/2;
        screenHeight = y-200;
        setSize(x,y);
        numberOfBranches = calcNumberOfBranches(extensions);
        branchLength = 20;
        this.angle = Double.valueOf(angle);
        addBranch();
    }
    public int calcNumberOfBranches(int splits){
        int counter = 0;
        for(int i = 1; i <= splits; i++){
            counter += (int)Math.pow(2,i);
        }
        System.out.println(counter);
        return counter;
    }
    public void update(){
        branch.clear();
        numberOfBranches = calcNumberOfBranches(extensions);
        System.out.println(extensions);
        addBranch();
        for(int i = 0; i < branch.size(); i++){
            branch.get(i).setCordinates();
        }
        repaint();
        
    }
    public void update2(){
        for(int i = 0; i < branch.size(); i++){
            branch.get(i).setCordinates();
        }
        repaint();
        
    }
    public void addBranch(){
        if(branch.size() > 0){
            branch.add(new Branches((branch.size()-1)/2));
        } else {
            branch.add(new Branches(-1));
        }
        if(branch.size()<=numberOfBranches){
            //System.out.println(branch.size());
            addBranch();    
        } else {
            System.out.println("TREE GENERATED " + branch.size());
        }
    }
    public void paint(Graphics g){
        //g.drawLine(250,500,250,450);
        for(int i = 0; i < branch.size(); i++){
            branch.get(i).paint(g);
        }
    }
}