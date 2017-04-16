package net.toregard.restkontroller;

import net.toregard.entities.CVPingLog;
import net.toregard.persistence.CVPingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/helper")
public class PingRestKontroller {

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

//    @RequestMapping(value= "/svv",produces = "application/json")
//    public String svv() {
//        // First, create factory
//        ClientFactory factory = new ClientFactory("https://www.vegvesen.no/nvdb/api/v2", "nvdbapi-client", "ACME");
//// Then, create your client. Typically, there's one per root endpoint
//        RoadObjectClient client = factory.createRoadObjectClient();
//
//// Example single object download
//        RoadObject ro = client.getRoadObject(534, 1);
//
//// Remember to close your factory when you're done using it
//        factory.close();
//        return "ok";
//    }



}
