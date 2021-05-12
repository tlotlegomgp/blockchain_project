import java.io.IOException;
import java.net.*;

public class Client {

    private static DatagramSocket socket;
    private static InetAddress address;
    private static DatagramPacket packetSender;
    private static DatagramPacket packetReceiver;
    private static byte[] sender;
    private static byte[] receiver;
    private static String result;

    public static void main(String[] args) {
        // write your code here
        try {
            socket = new DatagramSocket();
            address = InetAddress.getLocalHost();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static String processData(String data){
        main(null);
        byte[] sender = String.valueOf(data).getBytes();
        byte[] receiver = new byte[1024];
        String result = null;

        try {
            address = InetAddress.getLocalHost();
            packetSender = new DatagramPacket(sender, sender.length, address, 5000);
            socket.send(packetSender);

            packetReceiver = new DatagramPacket(receiver, receiver.length);
            socket.receive(packetReceiver);
            socket.close();

            result = new String(packetReceiver.getData());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        catch (SocketException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            return result;
        }

    }
}
