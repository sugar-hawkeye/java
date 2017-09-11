package demo.socket;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by wim on 2017/9/7.
 */
public class TCPClient {
    private final int PORT = 9527;
    private Socket socket = null;
    private boolean flag = true;




    public void connect() {
        try {
            socket = new Socket("127.0.0.1",PORT);
            socket.setSoTimeout(100000);

            OutputStream outputStream = socket.getOutputStream();
            PrintStream out = new PrintStream(outputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            InputStream inputStream = socket.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));

            while (flag){
                String msg = bufferedReader.readLine();
                out.println(msg);
                if (msg.equals("quit")) {
                    flag = false;
                }
                else {

                }
                String receiveMsg = input.readLine();
                System.out.println( receiveMsg);
            }



//            System.out.println("客户端关闭");
//            out.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) throws IOException {
        TCPClient tcpClient = new TCPClient();
        tcpClient.connect();
    }

}


