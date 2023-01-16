import java.awt.*;
import java.util.ArrayList;

public interface Component {
    public Graphics getGraphics();

    public void setGraphics(Graphics graphics);

    public Point getPosition();

    public void setPosition(Point pos);

    public void translate(Point p);

    public abstract ArrayList<Point> getBoundingBox();

    public abstract void draw();
}
