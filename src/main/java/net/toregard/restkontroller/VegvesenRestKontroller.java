package net.toregard.restkontroller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import net.toregard.entities.Datasets;
import net.toregard.entities.VvDatakatlogen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by toanders on 05.01.2017.
 */
@RestController
@RequestMapping("/vegvesen")
public class VegvesenRestKontroller {
    @Autowired
    RestTemplate restTemplate;

    @Value("${vvreiseplanlegger}")
    String vvreiseplanlegger;

    @Value("${vvDatakatalogen}")
    String vvDatakatalogen;

    private static final Logger log = LoggerFactory.getLogger(VegvesenRestKontroller.class);

    /**
     * Se http://www.baeldung.com/rest-template
     * @return
     */
    @RequestMapping(value= "/ruteplan",produces = "application/json")
    public String ruteplan() {
        ResponseEntity<String> response = restTemplate.getForEntity(vvreiseplanlegger, String.class);
        return "";
    }

    @RequestMapping(value= "/datakatalogen",produces = "application/json")
    public List<VvDatakatlogen> datakatalogen() throws IOException {
        List<VvDatakatlogen> liste = new ArrayList<VvDatakatlogen>();
        ResponseEntity<String> response = restTemplate.getForEntity(vvDatakatalogen + "/1", String.class);
        if(response.getStatusCode()== HttpStatus.OK)
        {
            mapVvDatakatlogen(liste,response);
        }
        return liste;
    }

    void mapVvDatakatlogen(List<VvDatakatlogen> liste,ResponseEntity<String> response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        VvDatakatlogen vvd = new VvDatakatlogen();
        JsonNodeType _type=root.getNodeType();
        if(_type  == JsonNodeType.OBJECT){
            if(root.get("title")!=null) vvd.setTitle(root.get("title").asText());
            if(root.get("homepage")!=null) vvd.setHomepage(root.get("homepage").asText());
            if(root.get("datasets")!=null){
                if(root.get("datasets").isArray()){
                    for (final JsonNode objNode : root.get("datasets")) {
                        vvd.setDatasets(new ArrayList<Datasets>());
                        Datasets datasets = new Datasets();
                        if(root.get("id")!=null) datasets.setId((root.get("id").asText()));
                        if(root.get("title")!=null) datasets.setTitle(root.get("title").asText());
                        vvd.getDatasets().add(datasets);
                    }
                }
                liste.add(vvd);
            }
        }
    }

//    List<VvDatakatlogen> getVvDatakatlogen(){
//        ResponseEntity<String> response = restTemplate.getForEntity(vvDatakatalogen + "/1", String.class);
//        //log.info(Arrays.asList(vvDatakatlogen).toString());
//        return Arrays.asList(vvDatakatlogen);
//    }

}
