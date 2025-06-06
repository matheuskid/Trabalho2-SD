package org.example;

public interface Remunerable {
    int getWorkedDays();
    void setWorkedDays(int days);
    double getScholarshipAmount();
    void setScholarshipAmount(double amount);
    double calculatePayment();
}
