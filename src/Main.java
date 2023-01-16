import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        Scene s1 = new Scene(600,600);
        RenderBoundingBox rsc1 = new RenderBoundingBox(new Circle(100,new Point(100,100),true));
        RenderBoundingBox rt1 = new RenderBoundingBox(new Triangle(new Point(400,200), new Point(500,200), new Point(450,300),true));
        RenderBoundingBox text = new RenderBoundingBox(new TextItem("cos", new Point(50,50)));
        s1.addItem(rsc1);
        s1.addItem(rt1);
        s1.addItem(text);
        rsc1.drawBoundingBox();
        rt1.drawBoundingBox();
        text.drawBoundingBox();
    }
}