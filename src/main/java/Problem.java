import java.util.Arrays;
import java.util.List;

public class Problem {
    int rows;
    int columns;
    int numberOfSnakes;
    int[] snakesLenght;
    int[][] matrix;

    String[] result;
    long score;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(columns).append(" ").append(rows).append(" ").append(numberOfSnakes).append("\n");
        for(int i = 0; i < snakesLenght.length; i++){
            str.append(snakesLenght[i]).append(" ");
        }
        str.append("\n");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                str.append(matrix[i][j] == Integer.MAX_VALUE ? "*" : matrix[i][j]).append(" ");
            }
            str.append("\n");
        }
        return str.toString();

    }
}
