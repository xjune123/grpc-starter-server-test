package com.grpc.test.grpcstarterservertest.interceptor;

import io.grpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: Michael
 * Email: yidongnan@gmail.com
 * Date: 2016/12/6
 */
public class LogGrpcInterceptor implements ServerInterceptor {
    public static final Context.Key<String> TENANT_ID
            = Context.key("TENANT_ID");
    private static final Logger log = LoggerFactory.getLogger(LogGrpcInterceptor.class);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        log.info(serverCall.getMethodDescriptor().getFullMethodName());
        serverCall.getMethodDescriptor().toBuilder().setFullMethodName("com.test.grpc.performance.TestPerformance/SayHelloC").build();
        if(metadata.containsKey(Metadata.Key.of("P_TENANT_ID", Metadata.ASCII_STRING_MARSHALLER))){
            String tenantId = metadata.get(Metadata.Key.of("P_TENANT_ID", Metadata.ASCII_STRING_MARSHALLER));
            Context context = Context.current().withValue(TENANT_ID, tenantId);
            return Contexts.interceptCall(context, serverCall, metadata, serverCallHandler);
        }
        return serverCallHandler.startCall(serverCall, metadata);
    }
}
