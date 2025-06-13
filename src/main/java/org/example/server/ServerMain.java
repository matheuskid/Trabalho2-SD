package org.example.server;

import org.example.common.StudentService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;

public class ServerMain {
    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099 (padrão)
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry iniciado na porta 1099.");

            // Cria a instância do serviço
            StudentService studentService = new StudentServiceImpl();

            // Registra o serviço com um nome único
            Naming.rebind("rmi://localhost/StudentService", studentService);

            System.out.println("StudentService registrado e pronto para receber requisições.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
