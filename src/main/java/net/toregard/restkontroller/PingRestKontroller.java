package net.toregard.restkontroller;

import net.toregard.entities.CVPingLog;
import net.toregard.persistence.CVPingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toanders on 05.01.2017.
 */
@RestController
@RequestMapping("/helper")
public class PingRestKontroller {
    @Autowired(required = false)
    private Cloud cloud;

    @Autowired
    CVPingLogRepository cVPingLogRepository;

    @RequestMapping(value= "/ping",produces = "application/json")
    public String ping() {
        return "ok";
    }

    @RequestMapping(value= "/cvsjekk",produces = "application/json")
    public List<CVPingLog> cvsjekk() {
        List<CVPingLog> s= cVPingLogRepository.findAll();
        return  s;
    }

    @RequestMapping(value = "/service")
    public List<ServiceInfo> showServiceInfo() {
        if (cloud != null) {
            return cloud.getServiceInfos();
        } else {
            return new ArrayList<>();
        }
    }



}
