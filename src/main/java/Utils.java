import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static boolean checkSnake(Problem p, int snakeIdx, int startX, int startY){
        int x = startX;
        int y = startY;
        int snakeLenght = p.snakesLenght[snakeIdx];
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
        while(crtLen<=snakeLenght){

            List<PointD> points = new ArrayList<>();
            points.add(new PointD(x,y+1,p.rows, p.columns, "R", m));
            points.add(new PointD(x,y-1,p.rows, p.columns, "L", m));
            points.add(new PointD(x-1,y,p.rows, p.columns, "U", m));
            points.add(new PointD(x+1,y,p.rows, p.columns, "D",m));

            String move = null;
            int max = Integer.MIN_VALUE;
            PointD pmax = null;
            for(PointD point:points){
                if(point.score==Integer.MIN_VALUE || point.score==Integer.MAX_VALUE){
                    continue;
                }
                if(point.score>max){
                    pmax = point;
                    max = pmax.score;
                }
            }


            if(pmax!=null){

                snakeLine.add(pmax.val);
                x = pmax.x;
                y = pmax.y;
                score = score + pmax.score;
                m[x][y] = Integer.MIN_VALUE;
                crtLen++;
            }else{
                break;
            }

        }

//        System.out.println(score);
//        System.out.println(p.result[snakeIdx]);

        if(crtLen!=(snakeLenght+1)){
//            System.out.println("no sol");
        }else{
            if(score>0){
                for(int i =0;i<p.rows;i++){
                    for(int j=0;j<p.columns;j++){
                        p.matrix[i][j] = m[i][j];
                    }
                }
                p.result[snakeIdx]=snakeLine.stream().collect(Collectors.joining(" "));
                p.score = p.score + score;
                return true;
            }
        }

        return false;
    }



}
