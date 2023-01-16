import java.awt.*;
import java.util.ArrayList;

public class Circle extends Shape{
    private int radius;

    public Circle()
    {
        radius=0;
    }

    public Circle(int radius, Point position, Boolean filled)
    {
        super(filled, position);
        this.radius=radius;
    }

    public int getRadius()
    {
        return radius;
    }

    public ArrayList<Point> getBoundingBox() {
        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(this.getPosition().getX(),this.getPosition().getY()));
        box.add(new Point(this.getPosition().getX(),this.getPosition().getY()+(radius*2)));
        box.add(new Point(this.getPosition().getX()+(radius*2),this.getPosition().getY()+(radius*2)));
        box.add(new Point(this.getPosition().getX()+(radius*2),this.getPosition().getY()));
        return box;
    }

    public void draw()
    {
        if(!getFilled())
            getGraphics().drawOval(getPosition().getX(),getPosition().getY(),radius*2,radius*2);
        else
            getGraphics().fillOval(getPosition().getX(),getPosition().getY(),radius*2,radius*2);
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }
}
