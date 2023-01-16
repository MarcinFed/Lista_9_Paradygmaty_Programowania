import java.util.ArrayList;

public class TextItem extends Item {
    private String text;

    public TextItem()
    {
        text=null;
    }

    public TextItem(String text, Point position)
    {
        super(position);
        this.text=text;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public ArrayList<Point> getBoundingBox() {

        ArrayList<Point> box = new ArrayList<>();
        box.add(new Point(getPosition().getX()+getGraphics().getFontMetrics().stringWidth(this.getText()),getPosition().getY()-9));
        box.add(new Point(getPosition().getX()+getGraphics().getFontMetrics().stringWidth(this.getText()), getPosition().getY()));
        box.add(new Point(getPosition().getX(),getPosition().getY()));
        box.add(new Point(getPosition().getX(), getPosition().getY()-9));
        return box;
    }

    public void draw()
    {
        getGraphics().drawString(text, getPosition().getX(), getPosition().getY());
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
    }
}
