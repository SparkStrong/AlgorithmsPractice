package swordRefersOffer;

import com.sun.corba.se.impl.ior.ByteBuffer;

import java.nio.channels.ServerSocketChannel;

/**
 * Created by Nack on 2017/12/25.
 */
public class Test26 {
    public static void main(String[] args) {
        Question26 tmp = new Question26();
        System.out.println("test 1");
        tmp.test1();

        System.out.println("test 2");
        tmp.test2();

        System.out.println("test 3");
        tmp.test3();
        ByteBuffer byteBuffer = new ByteBuffer();
        byteBuffer.append("c");
    }
}
