package org.example;

import java.util.List;
import java.util.ArrayList;

public class UndergraduateProgram {

    private String name;
    private String code;
    private int durationInYears; // in years
    private List<Student> students;

    public UndergraduateProgram(String name, String code, int durationInYears) {
        this.name = name;
        this.code = code;
        this.durationInYears = durationInYears;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getDurationInYears() {
        return durationInYears;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Student cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UndergraduateProgram{")
                .append("name='").append(name).append('\'')
                .append(", code='").append(code).append('\'')
                .append(", durationInYears=").append(durationInYears)
                .append(", students=").append(students)
                .append('}');
        return sb.toString();
    }
}
