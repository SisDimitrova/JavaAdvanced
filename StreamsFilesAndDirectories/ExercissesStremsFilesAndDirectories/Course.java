package ExercissesStreamFilesAndDirectories;

import java.io.Serializable;

public class Course implements Serializable {

    private String name;
    private int student;

    public Course(String name, int student) {
        this.name = name;
        this.student = student;
    }
}
