import java.awt.*;
import java.util.ArrayList;

public class ComplexItem extends Item{
    private ArrayList<Item> children;

    public ComplexItem()
    {
        children=new ArrayList<>();
    }

    public void addChild(Item child)
    {
        children.add(child);
    }

    public ArrayList<Item> getChildren()
    {
        return children;
    }

    @Override
    public void translate(Point p) {
        for(int i=0;i<children.size();i++)
        {
            children.get(i).translate(p);
        }
    }

    public ArrayList<Point> getBoundingBox() {
        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(mostL(),mostHigh()));
        box.add(new Point(mostL(),mostLow()));
        box.add(new Point(mostR(),mostLow()));
        box.add(new Point(mostR(),mostHigh()));
        return box;
    }

    private int mostHigh()
    {
       int first = getChildren().get(0).getBoundingBox().get(0).getY();
       int min=first;
       for(int i=1;i<getChildren().size();i++)
       {
           min=Math.min(getChildren().get(i).getBoundingBox().get(0).getY(),min);
       }
       return min;
    }

    private int mostLow()
    {
        int first = getChildren().get(0).getBoundingBox().get(1).getY();
        int max=first;
        for(int i=1;i<getChildren().size();i++)
        {
            max=Math.max(getChildren().get(i).getBoundingBox().get(1).getY(),max);
        }
        return max;
    }

    private int mostR()
    {
        int first = getChildren().get(0).getBoundingBox().get(3).getX();
        int max=first;
        for(int i=1;i<getChildren().size();i++)
        {
            max=Math.max(getChildren().get(i).getBoundingBox().get(3).getX(),max);
        }
        return max;
    }

    private int mostL()
    {
        int first = getChildren().get(0).getBoundingBox().get(0).getX();
        int min=first;
        for(int i=1;i<getChildren().size();i++)
        {
            min=Math.min(getChildren().get(i).getBoundingBox().get(0).getX(),min);
        }
        return min;
    }

    public void draw()
    {
        for(int i=0;i<getChildren().size();i++)
        {
            getChildren().get(i).draw();
        }
        getChildren().get(0).getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }

    public void setGraphics(Graphics graphics) {
        for(int i=0;i<children.size();i++)
        {
            children.get(i).setGraphics(graphics);
        }
    }
}
