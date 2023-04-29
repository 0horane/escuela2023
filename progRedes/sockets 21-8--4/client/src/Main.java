import java.io.*;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        try {

            Socket sock;
            PrintWriter sockout;
            Console console= System.console();
            BufferedReader sockin;
            sock = new Socket("localhost", 8080);
            sockout = new PrintWriter(sock.getOutputStream(), true);
            sockin = new BufferedReader(new InputStreamReader(sock.getInputStream()) );


            while (true){
                sockout.println(console.readLine());
                System.out.println(sockin.readLine());
            }


            //sockout.flush(); ayutofluch true


        } catch (IOException e){throw new RuntimeException(e);}

    }
}