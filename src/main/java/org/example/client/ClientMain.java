package org.example.client;

import org.example.common.*;

import java.rmi.Naming;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Localiza o serviço remoto registrado
            StudentService service = (StudentService) Naming.lookup("rmi://localhost/StudentService");

            // Cria um estudante de iniciação científica
            ScientificInitiationStudent student = new ScientificInitiationStudent(
                    "Ana Clara", 21, "S123", "Ciência da Computação", 20, 50.0
            );

            // Adiciona o estudante ao programa
            System.out.println("Adicionando estudante ao programa...");
            service.addStudentToProgram("CC001", student);

            PostGraduateStudent postGrad = new PostGraduateStudent(
                    "Carlos Eduardo", 28, "P456", "IA Aplicada na Saúde", "Dr. João", 15, 100.0
            );

            service.addStudentToProgram("CC001", postGrad);

            double bolsaPos = service.calculateScholarship("P456");
            System.out.println("Bolsa do aluno de pós: R$ " + bolsaPos);

            // Lista todos os estudantes
            System.out.println("\nEstudantes cadastrados:");
            List<Student> students = service.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }

            // Calcula a bolsa do estudante
            System.out.println("\nCalculando bolsa do estudante S123...");
            double totalPayment = service.calculateScholarship("S123");
            System.out.println("Valor total da bolsa: R$ " + totalPayment);

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
