public abstract class Decorator implements Component {
    Item item;
    public Decorator(Item item)
    {
        this.item = item;
    }
}
