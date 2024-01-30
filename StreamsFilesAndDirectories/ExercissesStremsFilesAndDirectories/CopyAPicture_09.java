package ExercissesStreamFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture_09 {
    public static void main(String[] args) {
        String pathInput = "C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\изтеглен файл.jpg";
        String pathOutput = "C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\copy-picture.jpg";

        try (FileInputStream fis = new FileInputStream(pathInput);
             FileOutputStream fos = new FileOutputStream(pathOutput)){
            int oneByte = fis.read();
            while (oneByte >= 0) {
              fos.write(oneByte);

               oneByte = fis.read();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
