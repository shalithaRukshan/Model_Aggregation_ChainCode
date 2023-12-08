package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class SocketTesting {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket soc = serverSocket.accept();
                System.out.println("Receive new connection: " + soc.getInetAddress());
                DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
                DataInputStream in = new DataInputStream(soc.getInputStream());
                dout.writeUTF("Thank You For Connecting.");
                String msg = (String) in.readUTF();
                System.out.println("Client: " + msg);

                String[] recArr = msg.split("\\|\\|");
                System.out.println(recArr[1]);
                if (recArr[0].equals("M1")) {
                    System.out.println("adding init point to ledger");
                    M1(recArr[1]);
                } else if (recArr[0].equals("M2")) {
                    System.out.println("getting points from ledger");
                    M2();
                } else if (recArr[0].equals("M3")) {
                    System.out.println("sending model to ledger");
                    M3();
                } else {
                    System.out.println("Getting final model from ledger");
                    M4();
                }

                dout.flush();
                dout.close();
                soc.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void M1(String filename) {
        try {
            File myObj = new File("D:\\ucd\\phd\\MyPapers\\MaskBasedFL\\codes\\pythoncodes\\impl\\"+filename);
            Scanner myReader = new Scanner(myObj);
            String content = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                content = content + data;
            }
            System.out.println("Content is :" + content);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void M2() {

    }

    public static void M3() {

    }

    public static void M4() {

    }
}
