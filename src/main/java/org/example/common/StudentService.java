package org.example.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {

    // Retorna todos os estudantes cadastrados
    List<Student> getAllStudents() throws RemoteException;

    // Retorna um estudante específico pelo ID
    Student getStudentById(String studentId) throws RemoteException;

    // Adiciona um estudante a um programa de graduação
    void addStudentToProgram(String programCode, Student student) throws RemoteException;

    // Calcula o valor da bolsa para um aluno de iniciação científica
    double calculateScholarship(String studentId) throws RemoteException;
}
