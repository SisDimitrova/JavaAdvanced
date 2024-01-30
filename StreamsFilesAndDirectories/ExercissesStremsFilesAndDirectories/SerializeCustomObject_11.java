package ExercissesStreamFilesAndDirectories;

import java.io.*;

public class SerializeCustomObject_11 {
    public static void main(String[] args) throws FileNotFoundException {

        Course course = new Course("Java Advanced", 100);

        String path = "C:\\Softuni SISE\\JavaAdvanced\\src\\ResourcesExerciseSFD\\course.ser";


        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            objectOutputStream.writeObject(course);
            Course deserializedCourse = (Course) objectInputStream.readObject();
            System.out.println();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
