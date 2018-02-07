package java8.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class WebServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
            SocketChannel socketChannel = ssc.accept();

            ByteBuffer readBuffer = ByteBuffer.allocate(256);
            socketChannel.read(readBuffer);

            readBuffer.flip();
            while (readBuffer.hasRemaining()) {
                System.out.print((char)readBuffer.get());
            }

            socketChannel.close();
            ssc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
