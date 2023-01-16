import java.util.ArrayList;

public class Segment extends Primitive{
    private Point start,end;

    public Segment()
    {
        start=null;
        end=null;
    }

    public Segment(Point p1, Point p2)
    {
        start=p1;
        end=p2;
    }

    public Point getStart()
    {
        return start;
    }

    public Point getEnd()
    {
        return end;
    }

    public int getLength()
    {
        return (int) Math.sqrt(Math.pow(start.getX()-end.getX(),2)+Math.pow(start.getY()-end.getY(),2));
    }

    private int mostHigh()
    {
        return Math.max(start.getY(),end.getY());
    }

    private int mostLow()
    {
        return Math.min(start.getY(),end.getY());
    }

    private int mostR()
    {
        return Math.max(start.getX(),end.getX());
    }

    private int mostL()
    {
        return Math.min(start.getX(),end.getX());
    }


    public ArrayList<Point> getBoundingBox() {
        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(mostL(),mostHigh()));
        box.add(new Point(mostL(),mostLow()));
        box.add(new Point(mostR(),mostLow()));
        box.add(new Point(mostR(),mostHigh()));
        return box;
    }

    public void translate(Point p)
    {
        super.translate(p);
        start.translate(p);
        end.translate(p);
    }

    public void draw()
    {
        getGraphics().drawLine(start.getX(),start.getY(),end.getX(),end.getY());
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }
}
