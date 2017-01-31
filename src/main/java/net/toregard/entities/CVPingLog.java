package net.toregard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Se vvreiseplanlegger
 */
@Entity
@Builder
@Data
//@Table(name = "CVPINGLOG")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CVPingLog implements Serializable {

    private static final long serialVersionUID = 6422148150215363492L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateTime;
    private String text;
}
