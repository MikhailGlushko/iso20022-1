package net.toregard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
//@Builder
//@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class VvDatakatlogen {
//    @Id
   private String title;
    private String homepage;
    private List<Datasets> datasets;
}
