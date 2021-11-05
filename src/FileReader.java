import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {
    public FileReader(){}

    public List<String> readFile(String fileName){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + fileName + ".txt";
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Please enter the correct filepath");
            e.printStackTrace();
        }
        return lines;
    }
}
