package net.toregard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Builder
@Data
//@Table(name = "DATASETS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datasets {
//    @Id
    private String id;
    private String title;

}
