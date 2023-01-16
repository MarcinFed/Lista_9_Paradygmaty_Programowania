import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
        Scene s2 = new Scene(800,800);
        //CircleSingleton c1 = Singleton.getInstance(50,new Point(100,100),true);
        CircleSingleton c2 = Singleton.getInstance(100,new Point(200,200),false);
        CircleSingleton c1 = Singleton.getInstance(50,new Point(100,100),true);
        Triangle t1 = new Triangle(new Point(400,200), new Point(500,200), new Point(450,300),true);
        TextItem ti1 = new TextItem("Swieta swieta i po swietach",new Point(300,500));
        RegPolygon star1 = new RegPolygon(7,100,new Point(400,400),false);
        ComplexItem ci = new ComplexItem();
        ci.addChild(c1);
        ci.addChild(c2);
        ci.addChild(t1);
        ci.addChild(ti1);
        ci.addChild(star1);

        s2.addItem(ci);
    }
}