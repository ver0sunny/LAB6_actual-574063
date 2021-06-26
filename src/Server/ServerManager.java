package Server;

import Common.DataObjectToSend;
import Common.Serializer;
import Common.exceptions.NoSuchCommandException;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerManager {
    private DatagramSocket serverSocket;
    private InetAddress senderAddress;
    private int senderPort;
    private byte[] receivingDataBuffer = new byte[65000];
    private final int SERVICE_PORT = 50001;
    private CommandManager commandManager;
    private Serializer serializer;
    private ConnectionBlock connectionBlock;
    private byte[] toSend;

    public ServerManager(CommandManager commandManager, Serializer serializer, ConnectionBlock connectionBlock) {
        this.commandManager = commandManager;
        this.serializer = serializer;
        this.connectionBlock = connectionBlock;
    }

    public DataObjectToSend receive() {
        byte[] inputPacket = connectionBlock.receive();
        DataObjectToSend receivedObject;
        receivedObject = serializer.deserializeDataObjectToSend(inputPacket);
        return receivedObject;
    }

    public void send(DataObjectToSend dataObjectToSend) {
        connectionBlock.send(serializer.serializeDataObjectToSend(dataObjectToSend));
    }

    public void sendMes(String mesToSend) {
        connectionBlock.send(serializer.serializeString(mesToSend));
    }

}
