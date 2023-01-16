import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Scene extends Frame{
    private int width;
    private int height;

    private ArrayList<Component> items;

    public Scene(int width, int height)
    {
        items = new ArrayList<>();
        setSize(width, height);
        setTitle("Rysowanki cacanki");
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we) {System.exit(0);}});
    }

    public void addItem(Component item){
        item.setGraphics(this.getGraphics());
        items.add(item);
    }

    public void draw(){
        for(int i=0;i<items.size();i++)
        {
            items.get(i).draw();
        }
    }

    public void paint(Graphics g)
    {
        draw();
    }
}

