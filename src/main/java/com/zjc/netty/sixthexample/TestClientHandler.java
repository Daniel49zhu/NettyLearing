package com.zjc.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        System.out.println(randomInt);
        //随机发送一种类型的数据类型
        DataInfo.MyMessage myMessage;
        if (0 == randomInt) {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.PersonType)
                    .setStudent(DataInfo.Student.newBuilder().setName("张三").setAddress("芜湖").setAge(20).build()
                    ).build();
        } else if (1 == randomInt) {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.DogType)
                    .setDog(DataInfo.Dog.newBuilder().setName("阿黄").setAge(20).build()
                    ).build();
        } else {
            myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.CatType)
                    .setCat(DataInfo.Cat.newBuilder().setName("阿喵").setCity("芜湖").build()
                    ).build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }
}
