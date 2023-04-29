import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {

            ServerSocket srvsock;
            Socket sock;
            PrintWriter sockout;
            BufferedReader sockin;
            Console console= System.console();

            String[][] mat;
            int xpos;
            int ypos;

            srvsock = new ServerSocket(8080);
            sock = srvsock.accept();
            sockout=new PrintWriter(sock.getOutputStream(), true);
            sockin = new BufferedReader(new InputStreamReader(sock.getInputStream()));


            while (true){
                System.out.println(sockin.readLine());
                sockout.println(console.readLine());
            }

            /*
            xpos=4;
            ypos=4;
            mat = new String[9][9];
            for (int j=0;j<9;j++) {
                for (int i = 0; i < 9; i++) {
                    mat[j][i]= (j==4 && i==4) ? "o" : " ";
                }
            }
/*
            while (true){
                switch (buffer.readLine()){
                    case "u":
                        ypos--;
                        break;
                    case "d":
                        ypos++;
                        break;
                    case "l":
                        ypos--;
                        break;
                    case "r":
                        ypos--;
                        break;
                    ///case default:
                    //    ypos--;
                    //    break;

                }
            }*/




        } catch (IOException e){throw new RuntimeException(e);}

    }
}