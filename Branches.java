import java.awt.*;
public class Branches{
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public int parent;
    public int direction;
    public double angle;
    public Branches(int parent){
        this.parent = parent;
        //System.out.println("PARENT: " + this.parent);
        if(PanelStuff.branch.size()%2 == 0){
                direction = 0;
            } else {
                direction = 1;
            }
        setCordinates();
    }
    public int getX(){
        return endX;
    }
    public int getY(){
        return endY;
    }
    public void setCordinates(){
        if(parent != -1){
            startX = PanelStuff.branch.get(parent).getX();
            startY = PanelStuff.branch.get(parent).getY();
            calculateEndCordinates(direction);
        } else {
            startX = PanelStuff.middle;
            startY = PanelStuff.screenHeight-50;
            endX = PanelStuff.middle;
            if(PanelStuff.branchLength > 50){
                endY = PanelStuff.screenHeight- (int)PanelStuff.branchLength;
            } else {
                endY = PanelStuff.screenHeight-100;
            }
            angle = 90.0;
        }
    }
    public double getAngle(){
        return angle;
    }
    public void setAngle(double newValue){
        angle = newValue;
    }
    public void calculateEndCordinates(int direction){
        switch(direction){
            case(0):
                //System.out.println("LEFT");
                angle = PanelStuff.branch.get(parent).getAngle() + PanelStuff.angle;
                break;
            case(1):
                //System.out.println("RIGHT");
                angle = PanelStuff.branch.get(parent).getAngle() - PanelStuff.angle;
                break;
            default:
                break;
        }
        double radians = Math.toRadians(angle);
        endX = (int)(startX + PanelStuff.branchLength*Math.cos(radians));
        endY = (int)(startY - PanelStuff.branchLength*Math.sin(radians));
    }
    public void paint(Graphics g){
        g.drawLine(startX,startY,endX,endY);
        //System.out.println("CORDS: " + startX + " " + startY + " " + endX + " " + endY);
    }
}