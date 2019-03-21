package cs2114.mazesolver;

/**
 * @author HJ
 * @version 4/13/2018
 */
public class Location implements ILocation {

    private int x;
    private int y;

    /**
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param h
     * return something
     * @return two location is equal or not
     */
    public boolean equals(Object h) {
        if (h instanceof Location) {
            return this.x == ((Location) h).x && this.y == ((Location) h).y;
        }
        return false;
    }
    /**
     
     * @return two location is equal or not
     */

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int x() {
        return this.x;
    }

    @Override
    public int y() {
        return this.y;
    }

    @Override
    public ILocation north() {
        Location h = new Location(this.x, this.y - 1);
        return h;
    }

    @Override
    public ILocation south() {
        Location h = new Location(this.x, this.y + 1);
        return h;
    }

    @Override
    public ILocation west() {
        Location h = new Location(this.x - 1, this.y);
        return h;
    }

    @Override
    public ILocation east() {
        Location h = new Location(this.x + 1, this.y);
        return h;
    }
}
