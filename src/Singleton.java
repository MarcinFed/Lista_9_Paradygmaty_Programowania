public interface Singleton {
    static CircleSingleton getInstance(int radius , Point position, Boolean filled)
    {
        CircleSingleton circle = CircleSingleton.getInstance(radius, position, filled);
        return circle;
    }
}
