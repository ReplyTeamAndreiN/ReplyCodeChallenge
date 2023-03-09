import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

   private static Map<Integer, String> MAP;
    static {
        MAP = new HashMap<>();
        MAP.put(0,"R");
        MAP.put(1,"L");
        MAP.put(2,"U");
        MAP.put(3,"D");
    }

    public static void test(Problem p, int snakeLenght, int startX, int startY){
        int x = startX;
        int y = startY;
        int[][] m = new int[p.rows][p.columns]; // make a copy of the p.matrix
        for(int i =0;i<p.rows;i++){
            for(int j=0;j<p.columns;j++){
                m[i][j] = p.matrix[i][j];
            }
        }


        List<String> snakeLine = new ArrayList<>();
        long score = 0L + m[x][y];
        snakeLine.add(Integer.toString(x));
        snakeLine.add(Integer.toString(y));
        m[x][y] = Integer.MIN_VALUE;

        int nextx =0;
        int nexty=0;


        int crtLen = 1;
        while(crtLen<snakeLenght){

            Integer[] ints = new Integer[4];
            ints[0] = isPositionAvailable(m, p.rows, p.columns, x ,y+1)? m[x][y+1] : null; //R
            ints[1] = isPositionAvailable(m, p.rows, p.columns, x ,y-1)? m[x][y-1] : null;//L
            ints[2] = isPositionAvailable(m, p.rows, p.columns, x-1 ,y)? m[x-1][y] : null;//U
            ints[3] = isPositionAvailable(m, p.rows, p.columns, x+1 ,y)? m[x+1][y] : null;//D

            String move = null;
            int max = Integer.MIN_VALUE;
            for(int i =0;i<4;i++){
                if(ints[i]!=null){
                    if(ints[i]>max){
                        max = ints[i];
                        move = MAP.get(Integer.valueOf(i));
                    }
                }
            }

            if(move!=null){
                switch (move) {
                    case "R":
                        nextx = x;
                        nexty = y+1;
                        break;
                    case "L":
                        nextx = x;
                        nexty = y-1;
                        break;
                    case "U":
                        nextx = x-1;
                        nexty = y;
                        break;
                    case "D":
                        nextx = x+1;
                        nexty = y;
                        break;
                }

                snakeLine.add(move);
                x = nextx;
                y = nexty;
                score = score + m[x][y];
                m[x][y] = Integer.MIN_VALUE;
                crtLen++;
            }else{
                break;
            }

        }

        if(crtLen!=snakeLenght){
            System.out.println("no sol");
        }else{

        }
        System.out.println(score);
        System.out.println(snakeLine);

    }

    public static boolean isPositionAvailable(int[][] m, int rows, int columns,int x, int y){
//        x = x ==-1? rows-1 : x;
//        y = y ==-1? columns-1 : y;
        if(x<0 || y<0 || (x>rows-1) || (y>columns-1)){
            return false;
        }
        if(m[x][y]==Integer.MIN_VALUE || m[x][y]==Integer.MAX_VALUE){
            return false;
        }
        return true;

        /*
         if(x<0 || y<0 || (x>rows-1) || (y>columns-1)){
            return false;
        }
        if(m[x][y]==Integer.MIN_VALUE || m[x][y]==Integer.MAX_VALUE){
            return false;
        }
        return true;
         */
    }

}
