import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {
        // write your code here
        try {
            DatagramSocket socket = new DatagramSocket(5000);


            byte[] receiver = new byte[1024];
            DatagramPacket packetReceiver = new DatagramPacket(receiver, receiver.length);

            socket.receive(packetReceiver);
            String data = new String(packetReceiver.getData());

            byte[] sender = new byte[1024];
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket senderPacket = new DatagramPacket(sender, sender.length, address, packetReceiver.getPort());
            socket.send(senderPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
