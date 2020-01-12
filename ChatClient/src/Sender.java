import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Sender {
    public static void main(String args[]) throws UnknownHostException, SocketException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //InetAddress toAdr = InetAddress.getLocalHost();

        InetAddress toAdr = InetAddress.getByName("172.20.201.68");
        int toport = 5555;

        DatagramSocket socket = new DatagramSocket();
        String message = JOptionPane.showInputDialog(null, "city");
        System.out.println("?: ");

        while((message = in.readLine()) !=  null){
            if(message.equals("bye")) System.exit(0);
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toport);
            socket.send(packet);
            System.out.println("?: ");
        } System.exit(0);

    }

}
