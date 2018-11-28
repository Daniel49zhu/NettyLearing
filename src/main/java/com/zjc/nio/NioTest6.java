package com.zjc.nio;

import java.nio.ByteBuffer;

public class NioTest6 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);


        for(int i = 0 ; i< buffer.capacity();i++) {
            buffer.put((byte)i);
        }

        buffer.position(2);
        buffer.limit(6);

        ByteBuffer sliceBuffer=  buffer.slice();//对原Buffer的一个快照，从p到l

        for(int i = 0 ; i <sliceBuffer.capacity();++i) {
            byte b = sliceBuffer.get(i);
            b *= 2;
            sliceBuffer.put(i,b);
        }

        buffer.position(0);
        buffer.limit(sliceBuffer.capacity());

        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
