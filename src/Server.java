import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
    private static String result = null;
    private static Blockchain blockchain;

    public static void main(String[] args) {
        // write your code here

        blockchain = new Blockchain(3);

        blockchain.addBlock(blockchain.newBlock(new String[]{"Apple = $120.000", "Google - $140,000"}));
        blockchain.addBlock(blockchain.newBlock(new String[]{"Amazon = $120.000", "Facebook - $140,000"}));
        blockchain.addBlock(blockchain.newBlock(new String[]{"Netflix = $120.000", "Microsoft - $140,000"}));

        System.out.println("Is Blockchain valid?: " + blockchain.isBlockChainValid());

        System.out.println(blockchain);

        try {
            DatagramSocket socket = new DatagramSocket(5000);


            byte[] receiver = new byte[1024];
            DatagramPacket packetReceiver = new DatagramPacket(receiver, receiver.length);

            socket.receive(packetReceiver);
            String data = new String(packetReceiver.getData());
            result += " - PROCESSED SUCCESSFULLY!!!";

            byte[] sender = String.valueOf(result).getBytes();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packetSender = new DatagramPacket(sender, sender.length, address, packetReceiver.getPort());
            socket.send(packetSender);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
