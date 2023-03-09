import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SnakeBastionsReader {
    public static Problem readProblemFromFile(String fileName) throws IOException {
        Path path = Paths.get("src/resources/" + fileName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.stream().forEach(System.out::println);
        String first = lines.get(0);
        String[] split = first.split(" ");

        String second = lines.get(1);
        for (int i = 2; i < lines.size(); i++) {

        }
        return null;
    }
}
/*
    String[] split = line.split(" ");
p.setInitialStamina(Integer.parseInt(split[0]));
p.setMaxStamina(Integer.parseInt(split[1]));
p.setTurns(Integer.parseInt(split[2]));
    p.setDemonsCount(Integer.parseInt(split[3]));
    List<Demon> demons = new ArrayList<>(p.getDemonsCount());*/
