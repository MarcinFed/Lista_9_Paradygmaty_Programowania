import java.util.ArrayList;

public class CircleSingleton extends Shape implements Singleton{
    private int radius;
    private static CircleSingleton single_instance = null;

    public CircleSingleton()
    {
        radius=0;
    }

    public CircleSingleton(int radius, Point position, Boolean filled)
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
//            getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }

    public static CircleSingleton getInstance(int radius, Point position, Boolean filled){
        if(single_instance == null)
            single_instance = new CircleSingleton(radius, position, filled);
        else{
            single_instance.radius = radius;
            single_instance.setPosition(position);
            single_instance.setFilled(filled);
        }
        return single_instance;
    }
}

