package org.example;

public class UndergraduateStudent extends Student {

    private String major;

    public UndergraduateStudent(String name, int age, String studentId, String major) {
        super(name, age, studentId);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "UndergraduateStudent{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", studentId='" + getStudentId() + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
