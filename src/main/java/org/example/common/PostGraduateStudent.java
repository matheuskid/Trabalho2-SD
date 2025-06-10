package org.example.common;

public class PostGraduateStudent extends Student implements Remunerable {

    private String thesisTitle;
    private String supervisor;
    private int workedDays;
    private double scholarshipAmount;

    public PostGraduateStudent(
            String name, int age, String studentId, String thesisTitle,
            String supervisor, int workedDays, double scholarshipAmount
    ) {
        super(name, age, studentId);
        this.thesisTitle = thesisTitle;
        this.supervisor = supervisor;
        this.workedDays = workedDays;
        this.scholarshipAmount = scholarshipAmount;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public String getSupervisor() {
        return supervisor;
    }

    @Override
    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    @Override
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public double calculatePayment() {
        return workedDays * scholarshipAmount;
    }

    @Override
    public String toString() {
        return "PostgraduateStudent{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", studentId='" + getStudentId() + '\'' +
                ", thesisTitle='" + thesisTitle + '\'' +
                ", supervisor='" + supervisor + '\'' +
                '}';
    }

}

