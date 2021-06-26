package Client;

import Common.DataObjectToSend;
import Common.Serializer;

import java.net.*;

public class ClientManager {

    private Serializer serializer;
    private ConnectionBlock connectionBlock;
    private byte[] toSend;

    private DatagramSocket clientSocket;
    private final int SERVICE_PORT = 50001;
    InetAddress IPAddress;
    private byte[] receivingDataBuffer = new byte[65000];

    public ClientManager(Serializer serializer, ConnectionBlock connectionBlock) {
        this.serializer = serializer;
        this.connectionBlock = connectionBlock;
    }

    public DataObjectToSend receive() {
        byte[] receivingPacket = connectionBlock.receive();
        DataObjectToSend receivedObject;
        receivedObject = serializer.deserializeDataObjectToSend(receivingPacket);
        return receivedObject;
    }

    public void send(DataObjectToSend dataObjectToSend) {
        byte[] toSend = serializer.serializeDataObjectToSend(dataObjectToSend);
        connectionBlock.send(toSend);
    }
}

