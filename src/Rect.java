import java.util.ArrayList;

public class Rect extends Shape{
    private int width,height;

    public Rect()
    {
        width=0;
        height=0;
    }

    public Rect(int width, int height, Point position, Boolean filled)
    {
        super(filled,position);
        this.width=width;
        this.height=height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    @Override
    public ArrayList<Point> getBoundingBox() {
        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(this.getPosition().getX(),this.getPosition().getY()));
        box.add(new Point(this.getPosition().getX(),this.getPosition().getY()+height));
        box.add(new Point(this.getPosition().getX()+width,this.getPosition().getY()+height));
        box.add(new Point(this.getPosition().getX()+width,this.getPosition().getY()));
        return box;
    }

    public void draw()
    {
        if(!getFilled())
            getGraphics().drawRect(getPosition().getX(),getPosition().getY(),width,height);
        else
            getGraphics().fillRect(getPosition().getX(),getPosition().getY(),width,height);
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }
}
