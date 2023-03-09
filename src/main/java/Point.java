import java.util.ArrayList;
import java.util.List;

public class Point {

    public int row;
    public int column;
    public int value;
    public final static String WORM_HOLE = "*";
    public boolean isVisited;
    public boolean isWormHole;
    public int snakeId;
    public Point southPoint, northPoint, eastPoint, westPoint;

    public List<Point> getPointNeighbours(Point reference, Point down, Point up, Point right, Point left) {
        List<Point> neighbours = new ArrayList<>();
        down.row = reference.row + 1;
        down.column = reference.column;
        up.row = reference.row - 1;
        up.column = reference.column;
        right.row = reference.row;
        right.column = reference.column + 1;
        right.row = reference.row;
        left.row = reference.row;
        left.column = reference.column -1;
        neighbours.add(up);
        neighbours.add(down);
        neighbours.add(left);
        neighbours.add(right);

        return neighbours;
    }

}
