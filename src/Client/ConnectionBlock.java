package Client;

import java.io.IOException;
import java.net.*;

public class ConnectionBlock {
    private DatagramSocket clientSocket;
    private final int SERVICE_PORT = 50001;
    InetAddress IPAddress;
    private byte[] receivingDataBuffer = new byte[65000];

    public ConnectionBlock() {
        setUp();
    }

    public void setUp() {
        try {
            clientSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        try {
            IPAddress = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        byte[] pack = new byte[1];
        send(pack);
        ClientConsole.println("..Client activated..");
    }

    public byte[] receive() {
        DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
        try {
            clientSocket.receive(receivingPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receivingPacket.getData();
    }

    public void send(byte[] toSend) {
        DatagramPacket sendingPacket = new DatagramPacket(toSend,toSend.length,IPAddress, SERVICE_PORT);
        try {
            clientSocket.send(sendingPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
