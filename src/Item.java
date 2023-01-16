import java.awt.*;
import java.util.ArrayList;

public abstract class Item implements Component{

    private Point position;

    private Graphics graphics;

    public Item(Point position)
    {
        this.position=position;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Item()
    {
        this.position=null;
    }

    public Point getPosition()
    {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void translate(Point p)
    {
        this.position.setX(p.getX()+this.position.getX());
        this.position.setY(p.getY()+this.position.getY());
    }

    public abstract ArrayList<Point> getBoundingBox();

    public abstract void draw();
}
