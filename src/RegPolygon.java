import java.util.ArrayList;

public class RegPolygon extends Shape{
    int nSides,radius;
    int[] X;
    int[] Y;

    public RegPolygon()
    {
        nSides=0;
        radius=0;
    }

    public RegPolygon(int nSides,int radius,Point position, Boolean filled)
    {
        super(filled,position);
        this.nSides=nSides;
        this.radius=radius;
        X = new int[nSides];
        Y = new int[nSides];

        double theta = 2*Math.PI/nSides;
        for (int i=0;i<nSides;i++)
        {
            X[i] = position.getX()+radius+(int) (Math.cos(i*theta)*radius);
            Y[i] = position.getY()+radius+(int) (Math.sin(i*theta)*radius);
        }
    }

    public int getnSides()
    {
        return nSides;
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
            getGraphics().drawPolygon(X,Y,nSides);
        else
            getGraphics().fillPolygon(X,Y,nSides);
        getGraphics().drawPolygon(new int[] {getBoundingBox().get(0).getX(),getBoundingBox().get(1).getX(),getBoundingBox().get(2).getX(),getBoundingBox().get(3).getX()},new int[] {getBoundingBox().get(0).getY(),getBoundingBox().get(1).getY(),getBoundingBox().get(2).getY(),getBoundingBox().get(3).getY()}, 4);
        System.out.println(getBoundingBox().get(0).getX()+" "+getBoundingBox().get(1).getX()+" "+getBoundingBox().get(2).getX()+" "+getBoundingBox().get(3).getX());
        System.out.println(getBoundingBox().get(0).getY()+" "+getBoundingBox().get(1).getY()+" "+getBoundingBox().get(2).getY()+" "+getBoundingBox().get(3).getY());
    }

    public void translate(Point p)
    {
        super.translate(p);
        for(int i=0;i<X.length;i++)
        {
            X[i]=X[i]+p.getX();
            Y[i]=Y[i]+p.getY();
        }
    }

    private int mostHigh()
    {
        int min = this.Y[0];
        for(int i=0;i<Y.length;i++)
        {
            min = Math.min(min, Y[i]);
        }
        return min;
    }

    private int mostLow()
    {
        int max = this.Y[0];
        for(int i=0;i<Y.length;i++)
        {
            max = Math.max(max, Y[i]);
        }
        return max;
    }

    private int mostR()
    {
        int max = this.X[0];
        for(int i=0;i<X.length;i++)
        {
            max = Math.max(max, X[i]);
        }
        return max;
    }

    private int mostL()
    {
        int min = this.X[0];
        for(int i=0;i<X.length;i++)
        {
            min = Math.min(min, X[i]);
        }
        return min;
    }
}
