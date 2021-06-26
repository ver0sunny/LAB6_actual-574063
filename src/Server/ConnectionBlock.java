package Server;

import Common.Serializer;

import java.io.*;
import java.net.*;

public class ConnectionBlock {
    private DatagramSocket serverSocket;
    private InetAddress senderAddress;
    private int senderPort;
    private byte[] receivingDataBuffer = new byte[65000];
    private final int SERVICE_PORT = 50001;
    private Serializer serializer;
    private byte[] toSend;

    public ConnectionBlock(Serializer serializer) {
        setUp();
        this.serializer = serializer;
    }

    public void setUp() {
        try {
            serverSocket = new DatagramSocket(SERVICE_PORT);
        } catch (
                SocketException socketException) {
            socketException.printStackTrace();
        }
        //создаю пустой пакет для получения сообщения
        DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
        ServerConsole.println("Waiting for a client to connect...");
        //получаю пакет
        try {
            serverSocket.receive(inputPacket);
            ServerConsole.println("SetUp successfull!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //из пакета вытягиваю данные о клиенте его адрес и порт, по которому идет связь
        senderAddress = inputPacket.getAddress();
        senderPort = inputPacket.getPort();
    }

    public byte[] receive() {
        //создаю пустой пакет для получения сообщения
        DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
        try {
            serverSocket.receive(inputPacket);
            return inputPacket.getData();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    public void send(byte[] toSend) {
        //заготовка пакета для отправки
        DatagramPacket PacketToSend = new DatagramPacket(
                toSend, toSend.length,
                senderAddress, senderPort);
        //отправка пакета
        try {
            serverSocket.send(PacketToSend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
