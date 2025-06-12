package org.example.client;

import org.example.common.*;

import java.io.*;
import java.rmi.Naming;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        try {
            ProtocolService protocol = (ProtocolService) Naming.lookup("rmi://localhost/ProtocolService");

            // Envia aluno
            PostGraduateStudent aluno = new PostGraduateStudent("Carlos", 27, "P123", "IA", "Prof. X", 10, 100);
            byte[] addReq = serialize(aluno);
            byte[] addResp = protocol.doOperation("StudentService", "addStudent", addReq);
            System.out.println("Resposta: " + deserialize(addResp));

            // Calcula bolsa
            byte[] idReq = serialize("P123");
            byte[] resp = protocol.doOperation("StudentService", "calculateScholarship", idReq);
            System.out.println("Bolsa: " + deserialize(resp));

            // Lista alunos
            byte[] alunosResp = protocol.doOperation("StudentService", "getAllStudents", new byte[0]);
            List<Student> alunos = (List<Student>) deserialize(alunosResp);
            alunos.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(obj);
        return baos.toByteArray();
    }

    private static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream in = new ObjectInputStream(bais);
        return in.readObject();
    }
}
