import java.awt.*;

public class Main {

    public static void main(String[] args)
    {
//        Scene s1 = new Scene(600,600);
//        Circle c = new Circle(50,new Point(0,0),false);
//        Triangle t = new Triangle(new Point(110,50), new Point(310,80), new Point(160,100),true);
//        TextItem ti = new TextItem("Siemanko",new Point(250,250));
//        Oval o = new Oval(100,50,new Point(300,300),false);
//        Rect r = new Rect(50,80,new Point(100,300),false);
//        Segment s = new Segment(new Point(200,300), new Point(300,100));


        Scene s2 = new Scene(800,800);
        Circle c1 = new Circle(50,new Point(100,100),true);
        Circle c2 = new Circle(100,new Point(200,200),false);
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

        Scene s3 = new Scene(800,800);
        Circle c3 = new Circle(50,new Point(100,100),false);
        Circle c4 = new Circle(100,new Point(200,200),true);
        Triangle t2 = new Triangle(new Point(400,200), new Point(500,200), new Point(450,300),false);
        TextItem ti2 = new TextItem("Swieta swieta i po swietach",new Point(300,500));
        RegPolygon star2 = new RegPolygon(7,100,new Point(400,400),true);
        ComplexItem ci2 = new ComplexItem();
        ci2.addChild(c3);
        ci2.addChild(c4);
        ci2.addChild(t2);
        ci2.addChild(ti2);
        ci2.addChild(star2);

        //c3.translate(new Point(0,50));
        ci2.translate(new Point(0,100));

        s3.addItem(ci2);

//        s1.addItem(c);
//        s1.addItem(t);
//        s1.addItem(ti);
//        s1.addItem(o);
//        s1.addItem(r);
//        s1.addItem(s);
    }
}