public class Location {
    public int row;
    public int column;
    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public String terrain() {

    }
    public String toString() {
        String s = "(" + row + ", " + column + ")";
        return s;
    }
}
