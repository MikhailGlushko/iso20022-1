package net.toregard.camelroutes;

import net.toregard.entities.CVPingLog;
import net.toregard.entities.Routes;
import org.apache.camel.Exchange;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.List;

public class Business {
       private CrudRepository<CVPingLog, Long> cVPingLogRepository;
       private CrudRepository<Routes,Long> routesRepository;

       Logger logger = Logger.getLogger(Business.class);

    @Autowired
    public void Business(CrudRepository<CVPingLog, Long> cVPingLogRepository,
                         CrudRepository<Routes,Long> routesRepository
                         ){
        this.cVPingLogRepository=cVPingLogRepository;
        this.routesRepository=routesRepository;
    }

    public void hallo(Exchange exchange){
        exchange.getIn().setBody("Ok",String.class);
    }

    public void save(Exchange exchange){
        CVPingLog quote = CVPingLog.
                builder().
                dateTime(LocalDateTime.now()).
                text("CVPing: CamelRuoteCorr.Id"+exchange.
                        getExchangeId()
                        ).build();
        cVPingLogRepository.save(quote);
    }


    public void cvs(Exchange exchange) {
        List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
        int readAmount =data.size();
        int rowAmount =0;
        for (List<String> line : data) {
            if(rowAmount>0){
                Routes routes = createRoutes(line);
                routesRepository.save(routes);
            }
            rowAmount++;
        }
        logger.info(String.format("Lagret %s av %s",rowAmount-1,readAmount));
    }

    /**
     * route_id,
     * agency_id,
     * route_short_name,
     * route_long_name,
     * route_desc,
     * route_type,
     * route_url,
     * route_color,
     * route_text_color
     */
     private Routes createRoutes(List<String> row){
         return Routes.builder().
                 route_id(row.get(0)).
                 agency_id(row.get(1)).
                 route_short_name(row.get(2)).
                 route_long_name(row.get(3)).
                 route_desc(row.get(4)).
                 route_type(row.get(5)).
                 route_url(row.get(6)).
                 route_color(row.get(7)).
                 route_text_color(row.get(8)).build();
     }
}
