package net.toregard.camelroutes;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by toanders on 05.01.2017.
 * http://henryk-konsek.blogspot.no/2014/10/using-apache-camel-with-spring-boot.html
 */
@Component
public class PingRoute extends RouteBuilder {
    Logger logger = Logger.getLogger(PingRoute.class);

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
                .to("log:PingRouteFeilerMenDetGlemmerVi?level=ERROR");

            from("timer:foo?repeatCount=1")
                    .to("log:Starter Opp Ping Route");

            //Caller periodisk min CV
            from("timer:pingcv?period={{CVPingLogTime}}").
                    to("direct:pingCV").
                    bean(Business.class,"save").
                    to("log:CV pinget lagret");

            from("direct:pingCV").
                   to("ahc:{{CVUrl}}").
                    bean(Business.class,"hallo").
                    to("log:CV pinget");

//        from("file://D:\\data\\tmp\\in\\in").
//                unmarshal().csv().split(body()).
//                bean(Business.class,"cvs").
//                //to("file://D:\\data\\tmp\\in\\ut").
//                //to("mock:daltons")
//                //to("ehf:hallo").
//                to("log:ferdig CVS");
    }


}
