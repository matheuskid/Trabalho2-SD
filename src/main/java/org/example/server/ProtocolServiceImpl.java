package org.example.server;

import org.example.common.*;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProtocolServiceImpl extends UnicastRemoteObject implements ProtocolService {

    private final StudentServiceImpl studentService;

    public ProtocolServiceImpl() throws RemoteException {
        super();
        studentService = new StudentServiceImpl();
    }

    @Override
    public byte[] doOperation(String objectRef, String methodId, byte[] arguments) throws IOException {
        try {
            if (!"StudentService".equalsIgnoreCase(objectRef)) {
                return serialize("Serviço '" + objectRef + "' não encontrado.");
            }

            switch (methodId) {
                case "addStudent":
                    Student s = (Student) deserialize(arguments);
                    studentService.addStudentToProgram("CC001", s);
                    return serialize("Aluno adicionado com sucesso.");
                case "calculateScholarship":
                    String id = (String) deserialize(arguments);
                    double value = studentService.calculateScholarship(id);
                    return serialize(value);
                case "getAllStudents":
                    List<Student> list = studentService.getAllStudents();
                    return serialize(list);
                default:
                    return serialize("Método '" + methodId + "' desconhecido.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return serialize("Erro interno no servidor: " + e.getMessage());
        }
    }

    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(obj);
        return baos.toByteArray();
    }

    private Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream in = new ObjectInputStream(bais);
        return in.readObject();
    }

}
