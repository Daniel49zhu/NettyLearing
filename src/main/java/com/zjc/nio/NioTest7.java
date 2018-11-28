package com.zjc.nio;

import java.nio.ByteBuffer;

public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for(int i = 0 ; i < buffer.capacity();++i) {
            buffer.put((byte)i);
        }

        ByteBuffer readOblyBuffer = buffer.asReadOnlyBuffer();

        readOblyBuffer.put((byte) 1);//会直接抛异常
    }
}
