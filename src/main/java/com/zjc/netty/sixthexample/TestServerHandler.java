package com.zjc.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {
        //因为已经添加了Decoder和Encoder 所以已经进行了反序列化
        System.out.println(msg.getAddress());
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
    }
}
