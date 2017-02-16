package net.toregard.restkontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ehelse")
public class EhelseKontroller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(
            value= "/melding/{mobilId}/{knappTrykket}",
            produces = "application/json",
            method = RequestMethod.GET)
    public boolean mottaData(
            @PathVariable String mobilId,
            @PathVariable String knappTrykket) {
        boolean mottatt=false;
                log.info("*******************************");
                log.info(String.format("mottatData %s %s",mobilId,knappTrykket));
                log.info("*******************************");
                return  true;
    }
}
