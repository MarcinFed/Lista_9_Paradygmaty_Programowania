public abstract class Shape extends Primitive{

    private boolean filled;

    public Shape()
    {
        super(new Point());
        filled=false;
    }

    public Shape(boolean filled, Point position)
    {
        super(position);
        this.filled=filled;
    }

    public boolean getFilled()
    {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
