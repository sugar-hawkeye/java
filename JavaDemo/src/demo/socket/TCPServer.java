package demo.socket;

import java.io.*;
import java.net.*;

/**
 * Created by wim on 2017/9/7.
 */
public class TCPServer {
    private final int PORT = 9527;
    private Socket socket = null;
    private boolean flag = true;

    public ServerSocket server() {
        ServerSocket serverSocket = null;
        try {
            serverSocket  = new ServerSocket(PORT);
            if (!serverSocket.isBound()){
                SocketAddress address = new InetSocketAddress("127.0.0.1", PORT);
                serverSocket.bind(address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket;
    }

    public void openListener() {
        try {
            socket = server().accept();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputStreamReader);

            OutputStream outputStream = socket.getOutputStream();
            PrintStream out = new PrintStream(outputStream);


            while (flag) {
                String receiveMsg = input.readLine();
                System.out.println("client : " + receiveMsg);
                if (receiveMsg.equals("quit")) {
                    flag = false;
                }

//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                String sendMsg = bufferedReader.readLine();
                out.println("server 已收到");
            }

            System.out.println("服务器关闭");
            input.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException {
        TCPServer tcpServer = new TCPServer();
        tcpServer.openListener();
    }

}
