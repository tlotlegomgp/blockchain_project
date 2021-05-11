import java.io.IOException;
import java.net.*;

public class Client {

    private static DatagramSocket socket;
    private static InetAddress address;
    private static DatagramPacket packetSender;
    private static DatagramPacket packetReceiver;

    public static void main(String[] args) {
        // write your code here
        try {
            socket = new DatagramSocket();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String processData(String data){
        byte[] sender = String.valueOf(data).getBytes();
        byte[] receiver = new byte[1024];
        String result = null;

        try {
            address = InetAddress.getLocalHost();
            packetSender = new DatagramPacket(sender, sender.length, address, 5000);
            socket.send(packetSender);

            packetReceiver = new DatagramPacket(receiver, receiver.length);
            socket.receive(packetReceiver);

            result = new String(packetReceiver.getData());
            System.out.println(result);


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
