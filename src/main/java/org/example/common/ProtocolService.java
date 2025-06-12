package org.example.common;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProtocolService extends Remote {
    byte[] doOperation(String objectRef, String methodId, byte[] arguments) throws IOException;
}
