package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Softuni SISE\\JavaAdvanced\\src\\resurce\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));

        for (int i = 0; i < inputData.size() ; i++) {
            if ((i + 1) % 3 == 0) {
                Files.writeString(Paths.get(outputPath), inputData.get(i) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        }
    }
}
