package com.itheima.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;

import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: com.itheima.gateway.filter
 * @ClassName: MyParamGatewayFilterFactory
 * @Author: zhangle @Date: 2020/2/28 20:26
 * @Description:
 */
@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {

    public static final String PARAM_NAME = "param";

    public MyParamGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            if (request.getQueryParams().containsKey(config.param)){
                request.getQueryParams().get(config.param).forEach(value -> System.out.println(config.param+"   "+value));
            }
            return chain.filter(exchange);
        });
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }

    public class Config{
        private String param;
        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }
    }
}
