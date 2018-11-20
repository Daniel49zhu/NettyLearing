package com.zjc.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        com.zjc.netty.protobuf.DataInfo.Student student =
                com.zjc.netty.protobuf.DataInfo.Student.newBuilder()
                        .setName("张三")
                        .setAge(20)
                        .setAddress("芜湖")
                        .build();

        ctx.channel().writeAndFlush(student);
    }
}
