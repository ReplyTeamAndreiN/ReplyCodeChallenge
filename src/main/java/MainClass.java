import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {

    public static void main(String[]args) throws IOException {
        String fileName0 = "00-example.txt";
        String fileName1 = "01-chilling-cat.txt";
        String fileName2 = "02-swarming-ant.txt";
        String fileName3 = "03-input-anti-greedy.txt";
        String fileName4 = "04-input-low-points.txt";
        String fileName5 = "05-input-opposite-points-holes.txt";

        String fileName = fileName2;

        Problem p = SnakeBastionsReader.readProblemFromFile(fileName);

        //System.out.println(p);

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


        System.out.println("==========  "+p.score);

        writeToFile(fileName, p);

    }

    private static void writeToFile(String fileName, Problem p) throws IOException {
        StringBuilder str = new StringBuilder();
        for(String s:p.result){
            str.append(s).append(System.lineSeparator());
        }
        Path path = Paths.get("src/main/resources/sol"+"_"+fileName);
        Files.write(path, str.toString().getBytes());

    }
}
