package org.example.server;

import org.example.common.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    private final Map<String, UndergraduateProgram> programs;
    private final Map<String, Student> studentRegistry;

    public StudentServiceImpl() throws RemoteException {
        super();
        this.programs = new HashMap<>();
        this.studentRegistry = new HashMap<>();

        // Exemplo inicial de programa
        UndergraduateProgram csProgram = new UndergraduateProgram("Ciência da Computação", "CC001", 4);
        programs.put(csProgram.getCode(), csProgram);
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        return new ArrayList<>(studentRegistry.values());
    }

    @Override
    public Student getStudentById(String studentId) throws RemoteException {
        return studentRegistry.get(studentId);
    }

    @Override
    public void addStudentToProgram(String programCode, Student student) throws RemoteException {
        UndergraduateProgram program = programs.get(programCode);
        if (program != null && student != null) {
            program.addStudent(student);
            studentRegistry.put(student.getStudentId(), student);
        } else {
            throw new IllegalArgumentException("Programa ou estudante inválido.");
        }
    }

    @Override
    public double calculateScholarship(String studentId) throws RemoteException {
        Student student = studentRegistry.get(studentId);
        if (student instanceof Remunerable remunerable) {
            return remunerable.calculatePayment();
        } else {
            throw new IllegalArgumentException("Estudante não participa de iniciação científica.");
        }
    }
}
