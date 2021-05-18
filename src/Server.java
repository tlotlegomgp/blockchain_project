import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.management.StringValueExp;
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

        blockchain.addBlock(blockchain.newBlock("Amazon - R140.000 \nFacebook - R640,000"));
        blockchain.addBlock(blockchain.newBlock("Netflix - R190.000 \nMicrosoft - R10,000"));
        blockchain.addBlock(blockchain.newBlock("Microsoft - R220.000 \nMicrosoft - R30,000"));

        System.out.println("Is Blockchain valid?: " + blockchain.isBlockChainValid());

        Block block3 = blockchain.recentBlock();
        Block block2 = blockchain.previousBlock(block3);
        Block block1 = blockchain.previousBlock(block2);
        Block block0 = blockchain.previousBlock(block1);

        System.out.println(blockchain);

        try {
            DatagramSocket socket = new DatagramSocket(5000);


            byte[] receiver = new byte[1024];
            byte[] sender;
            while(true){
                DatagramPacket packetReceiver = new DatagramPacket(receiver, receiver.length);

                socket.receive(packetReceiver);
                String data = null;
                data = new String(packetReceiver.getData());
                if (data.substring(0, 2).equals("B-")){
                    data = data.substring(0, Math.min(data.length(), 3));
                }

                System.out.println("Data - " + data.trim());

                // B-0 - Is the blockchain valid
                if (data.trim().equals("B-0")){
                    result = String.valueOf(blockchain.isBlockChainValid());
                }
                // B-1 - Is the genesis block valid
                else if (data.trim().equals("B-1")){
                    result = String.valueOf(blockchain.isGenesisBlockValid());
                }
                // B-2 - Is the second block valid
                else if (data.trim().equals("B-2")){
                    result = String.valueOf(blockchain.isNewBlockValid(block1, blockchain.previousBlock(block1)));
                }
                // B-3 - Is the third block valid
                else if (data.trim().equals("B-3")){
                    result = String.valueOf(blockchain.isNewBlockValid(block2, block1));
                }
                // B-3 - Is the fourth block valid
                else if (data.trim().equals("B-4")){
                    result = String.valueOf(blockchain.isNewBlockValid(block3, block2));
                }
                // B-5 - Get the blockchain blocks
                else if (data.trim().equals("B-5")){
                    result = block0 + "@" + block0.getRecords() + "@" + block1 + "@" + block1.getRecords() + "@" +
                            block2 + "@" + block2.getRecords() + "@" + block3 + "@" + block3.getRecords();
                }
                // B-6 - Validate the blockchain
                else if (data.trim().equals("B-6")){
                    blockchain.validateChain();
                    result = "Validated!";
                }
                else {
                    result = String.valueOf(blockchain.isBlockValid(data.trim()));
                }

                sender = String.valueOf(result).getBytes();
                InetAddress address = InetAddress.getLocalHost();
                DatagramPacket packetSender = new DatagramPacket(sender, sender.length, address, packetReceiver.getPort());
                socket.send(packetSender);
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
