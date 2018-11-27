package com.zjc.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws IOException {
        InputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel fileChannel = ((FileInputStream) fileInputStream).getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining()>0) {
            byte b = byteBuffer.get();
            System.out.print( (char)b);
        }
        fileInputStream.close();
    }
}
