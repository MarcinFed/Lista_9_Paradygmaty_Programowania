import java.util.ArrayList;

public class Triangle extends Shape{
    private Point p1,p2,p3;

    public Triangle()
    {
        p1=null;
        p2=null;
        p3=null;
    }

    public Triangle(Point p1, Point p2, Point p3, Boolean filled)
    {
        super();
        if(((p2.getX()-p1.getX())*(p3.getY()-p1.getY()))!=((p2.getY()-p1.getY())*(p3.getX()-p1.getX()))) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.setFilled(filled);
            this.setPosition(getBoundingBox().get(0));
        }
        else
            System.out.println("Blad");
    }

    public Point getP1()
    {
        return p1;
    }

    public Point getP2()
    {
        return p2;
    }

    public Point getP3()
    {
        return p3;
    }

    private int mostHigh()
    {
        return Math.min(Math.min(p1.getY(),p2.getY()),p3.getY());
    }

    private int mostLow()
    {
        return Math.max(Math.max(p1.getY(),p2.getY()),p3.getY());
    }

    private int mostR()
    {
        return Math.max(Math.max(p1.getX(),p2.getX()),p3.getX());
    }

    private int mostL()
    {
        return Math.min(Math.min(p1.getX(),p2.getX()),p3.getX());
    }

    public ArrayList<Point> getBoundingBox() {
        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(mostL(),mostHigh()));
        box.add(new Point(mostL(),mostLow()));
        box.add(new Point(mostR(),mostLow()));
        box.add(new Point(mostR(),mostHigh()));
        return box;
    }

    public void draw()
    {
        if(!getFilled())
            getGraphics().drawPolygon(new int[] {p1.getX(), p2.getX(), p3.getX()}, new int[] {p1.getY(), p2.getY(), p3.getY()}, 3);
        else
            getGraphics().fillPolygon(new int[] {p1.getX(), p2.getX(), p3.getX()}, new int[] {p1.getY(), p2.getY(), p3.getY()}, 3);
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }

    public void translate(Point p)
    {
        super.translate(p);
        p1.translate(p);
        p2.translate(p);
        p3.translate(p);
    }
}
