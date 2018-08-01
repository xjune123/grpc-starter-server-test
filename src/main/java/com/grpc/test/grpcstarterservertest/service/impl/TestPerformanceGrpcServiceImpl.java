package com.grpc.test.grpcstarterservertest.service.impl;

import com.google.protobuf.util.Timestamps;
import com.grpc.test.grpcstarterservertest.interceptor.LogGrpcInterceptor;
import com.test.grpc.performance.*;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

import java.util.ArrayList;
import java.util.List;

/**
 * Grpc 测试响应
 *
 * @author junqiang.xiao@hand-china.com
 * @date 2018/5/7
 */
@GrpcService(TestPerformanceGrpc.class)
public class TestPerformanceGrpcServiceImpl extends TestPerformanceGrpc.TestPerformanceImplBase {
    @Override
    public void sayHello(TestRequest req, StreamObserver<TestReply> responseObserver) {
        System.out.println(LogGrpcInterceptor.TENANT_ID.get());
        List<LineReply> lineReplyList = new ArrayList<LineReply>();
        for (int i = 0; i < 10; i++) {
            List<DistributionReply> distributionReplyList = new ArrayList<DistributionReply>();
            DistributionReply distributionReply = null;
            for (int j = 0; j < 10; j++) {
                distributionReply = DistributionReply.newBuilder().setField1("我是第一列").setField2(2).
                        setField3(Timestamps.fromMillis(System.currentTimeMillis())).setField4("我是第四列").setField5(5).setField6("我是第六列").
                        setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                        setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                        setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").
                        build();
                distributionReplyList.add(distributionReply);
            }
            LineReply lineReply = LineReply.newBuilder().addAllField1(distributionReplyList).setField2(2).
                    setField3(Timestamps.fromMillis(System.currentTimeMillis())).setField4("我是第四列").setField5(5).setField6("我是第六列").
                    setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                    setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                    setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").build();
            lineReplyList.add(lineReply);

        }
        HeaderReply headerReply = HeaderReply.newBuilder().addAllField1(lineReplyList).setField2(2).setField3(Timestamps.fromMillis(System.currentTimeMillis()))
                .setField4("我是第四列").setField5(5).setField6("我是第六列").
                        setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                        setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                        setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").build();

        TestReply reply = TestReply.newBuilder().setField1(headerReply).setName(req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onNext(reply);

        responseObserver.onCompleted();
    }
    @Override
    public void sayHelloB(TestRequest req, StreamObserver<TestReply> responseObserver) {
        System.out.println("我是请求B，客户化"+LogGrpcInterceptor.TENANT_ID.get());
        List<LineReply> lineReplyList = new ArrayList<LineReply>();
        for (int i = 0; i < 10; i++) {
            List<DistributionReply> distributionReplyList = new ArrayList<DistributionReply>();
            DistributionReply distributionReply = null;
            for (int j = 0; j < 10; j++) {
                distributionReply = DistributionReply.newBuilder().setField1("我是第一列").setField2(2).
                        setField3(Timestamps.fromMillis(System.currentTimeMillis())).setField4("我是第四列").setField5(5).setField6("我是第六列").
                        setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                        setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                        setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").
                        build();
                distributionReplyList.add(distributionReply);
            }
            LineReply lineReply = LineReply.newBuilder().addAllField1(distributionReplyList).setField2(2).
                    setField3(Timestamps.fromMillis(System.currentTimeMillis())).setField4("我是第四列").setField5(5).setField6("我是第六列").
                    setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                    setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                    setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").build();
            lineReplyList.add(lineReply);

        }
        HeaderReply headerReply = HeaderReply.newBuilder().addAllField1(lineReplyList).setField2(2).setField3(Timestamps.fromMillis(System.currentTimeMillis()))
                .setField4("我是第四列").setField5(5).setField6("我是第六列").
                        setField7(7).setField8("我是第八列").setField9(9).setField10("我是第十列").
                        setField11(11).setField12("我是第十二列").setField13(13).setField14("我是第十四列").
                        setField15(15).setField16("我是第十六列").setField17(17).setField18("我是第十八列").build();

        TestReply reply = TestReply.newBuilder().setField1(headerReply).setName(req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloC(TestRequest req, StreamObserver<TestReply> responseObserver) {
        System.out.println("我是请求C，客户化" + LogGrpcInterceptor.TENANT_ID.get());
    }

}
