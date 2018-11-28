package com.zjc.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.limit(4);

        for(int i = 0 ; i< buffer.limit();++i) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        buffer.flip();

        while(buffer.hasRemaining()) {
            System.out.println(buffer.position()+":"+buffer.get());
        }
    }
}
