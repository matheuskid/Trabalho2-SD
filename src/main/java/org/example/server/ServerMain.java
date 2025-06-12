package org.example.server;

import org.example.common.ProtocolService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Porta padrão do RMI
            ProtocolService protocol = new ProtocolServiceImpl();
            Naming.rebind("ProtocolService", protocol);
            System.out.println("Servidor RMI pronto em: rmi://localhost/ProtocolService");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

