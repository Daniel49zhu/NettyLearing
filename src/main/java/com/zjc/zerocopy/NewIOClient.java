package com.zjc.zerocopy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));

        String fileName = "D:\\书籍\\TypeScript Language Specification.pdf";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        //零拷贝
        long transferCount = fileChannel.transferTo(0,fileChannel.size(),socketChannel);

        System.out.println("发送总字节数： " + transferCount + ", 耗时： " + (System.currentTimeMillis() - startTime));
        //output:发送总字节数： 1695961, 耗时： 13
        fileChannel.close();
    }
}
