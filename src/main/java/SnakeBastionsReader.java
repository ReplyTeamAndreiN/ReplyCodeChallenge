import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SnakeBastionsReader {
    public static void main(String[] args) throws IOException {
        Problem p = SnakeBastionsReader.readProblemFromFile("00-example.txt");
        System.out.println(p);


        Utils.checkSnake(p, 1, 1,3);
    }
    public static Problem readProblemFromFile(String fileName) throws IOException {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        //lines.stream().forEach(System.out::println);
        String first = lines.get(0);
        String[] split = first.split(" ");
        Problem p = new Problem();
        p.columns = Integer.parseInt(split[0]);
        p.rows = Integer.parseInt(split[1]);
        p.numberOfSnakes = Integer.parseInt(split[2]);


        String second = lines.get(1);
        String[] secondLine = second.split(" ");
        p.snakesLenght = new int[p.numberOfSnakes];
        for(int i =0; i < secondLine.length; i++){
            p.snakesLenght[i] = Integer.parseInt(secondLine[i]);
        }

        p.matrix = new int[p.rows][p.columns];
        for (int i = 2; i < lines.size(); i++) {
            String lin = lines.get(i);
            String[] values = lin.split(" ");
            for(int j=0;j<p.columns;j++){
                if(values[j].equals("*")){
                    p.matrix[i-2][j] = Integer.MAX_VALUE;
                }else{
                    p.matrix[i-2][j] = Integer.valueOf(values[j]);
                }

            }

        }
        p.result = new String[p.numberOfSnakes];
        return p;
    }
}
/*
    String[] split = line.split(" ");
p.setInitialStamina(Integer.parseInt(split[0]));
p.setMaxStamina(Integer.parseInt(split[1]));
p.setTurns(Integer.parseInt(split[2]));
    p.setDemonsCount(Integer.parseInt(split[3]));
    List<Demon> demons = new ArrayList<>(p.getDemonsCount());*/
