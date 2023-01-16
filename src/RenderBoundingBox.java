import java.awt.*;
import java.util.ArrayList;

public class RenderBoundingBox extends Decorator{

    public RenderBoundingBox(Item i)
    {
        super(i);
    }

    public ArrayList<Point> getBoundingBox() {
        return item.getBoundingBox();
    }

    public void drawBoundingBox()
    {
        item.getGraphics().drawPolygon(
                new int[] {
                        item.getBoundingBox().get(0).getX(),
                        item.getBoundingBox().get(1).getX(),
                        item.getBoundingBox().get(2).getX(),
                        item.getBoundingBox().get(3).getX()
                },
                new int[] {
                        item.getBoundingBox().get(0).getY(),
                        item.getBoundingBox().get(1).getY(),
                        item.getBoundingBox().get(2).getY(),
                        item.getBoundingBox().get(3).getY()
                },
                4);
    }

    public void draw()
    {
        item.draw();
    }

    public Graphics getGraphics()
    {
        return item.getGraphics();
    }

    public void setGraphics(Graphics graphics)
    {
        item.setGraphics(graphics);
    }


    public Point getPosition()
    {
        return item.getPosition();
    }

    public void setPosition(Point pos)
    {
        item.setPosition(pos);
    }

    public void translate(Point p)
    {
        item.translate(p);
    }


}