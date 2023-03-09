import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

    public static void main(String[]args) throws IOException {
       // Problem p = SnakeBastionsReader.readProblemFromFile("00-example.txt");

        //Problem p = SnakeBastionsReader.readProblemFromFile("01-chilling-cat.txt");
        //Problem p = SnakeBastionsReader.readProblemFromFile("02-swarming-ant.txt");
       Problem p = SnakeBastionsReader.readProblemFromFile("03-input-anti-greedy.txt");
       // Problem p = SnakeBastionsReader.readProblemFromFile("04-input-low-points.txt");
        // Problem p = SnakeBastionsReader.readProblemFromFile("05-input-opposite-points-holes.txt");
        System.out.println(p);

        int crtSnake = 0;
        while(crtSnake<p.numberOfSnakes){

            List<PointD> allPoints = new ArrayList<>();
            for(int i=0;i<p.rows;i++){
               for(int j=0;j<p.columns;j++){
                   if(p.matrix[i][j]==Integer.MIN_VALUE || p.matrix[i][j]==Integer.MAX_VALUE){
                       continue;
                   }
                   allPoints.add(new PointD(i,j,p.rows,p.columns, "", p.matrix));
               }
            }

            Collections.sort(allPoints);
            boolean found = false;
            for(PointD startingPoint : allPoints){
                System.out.println("Checking snake "+ crtSnake+ " point "+startingPoint.x + " "+ startingPoint.y);
                if(Utils.checkSnake(p, crtSnake, startingPoint.x, startingPoint.y)){
                    crtSnake++;
                    found = true;
                    break;
                }

            }
            if(!found){
                p.result[crtSnake] = "";
                crtSnake++;
            }



        }

        for(String ss:p.result){
            System.out.println(ss);
        }
        System.out.println("==========  "+p.score);



    }
}
