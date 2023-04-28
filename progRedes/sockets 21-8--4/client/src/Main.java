import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {
        try {

            Socket sock;
            PrintWriter sockout;

            sock = new Socket("localhost", 8080);
            sockout = new PrintWriter(sock.getOutputStream());

            sockout.println("get real");
            sockout.flush();


        } catch (IOException e){throw new RuntimeException(e);}

    }
}