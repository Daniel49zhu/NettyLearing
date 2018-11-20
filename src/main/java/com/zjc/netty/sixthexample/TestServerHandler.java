package com.zjc.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }
}
