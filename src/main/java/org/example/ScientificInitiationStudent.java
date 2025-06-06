package org.example;

public class ScientificInitiationStudent extends UndergraduateStudent implements Remunerable {

    private int workedDays;
    private double scholarshipAmount;

    public ScientificInitiationStudent(String name, int age, String studentId, String course, int workedDays, double scholarshipAmount) {
        super(name, age, studentId, course);
        this.workedDays = workedDays;
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public int getWorkedDays() {
        return workedDays;
    }

    @Override
    public void setWorkedDays(int days) {
        this.workedDays = days;
    }

    @Override
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    @Override
    public void setScholarshipAmount(double amount) {
        this.scholarshipAmount = amount;
    }

    @Override
    public double calculatePayment() {
        return workedDays * scholarshipAmount;
    }

    @Override
    public String toString() {
        return "ScientificInitiationStudent{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", studentId='" + getStudentId() + '\'' +
                ", workedDays=" + workedDays +
                ", scholarshipAmount=" + scholarshipAmount +
                '}';
    }

}

