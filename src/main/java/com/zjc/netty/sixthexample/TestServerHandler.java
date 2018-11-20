package com.zjc.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {
        //因为已经添加了Decoder和Encoder 所以已经进行了反序列化
        DataInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == DataInfo.MyMessage.DataType.PersonType) {
            DataInfo.Student student =  msg.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddress());
        } else if (dataType == DataInfo.MyMessage.DataType.DogType) {
            DataInfo.Dog dog =  msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else {
            DataInfo.Cat cat =  msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }
    }
}
