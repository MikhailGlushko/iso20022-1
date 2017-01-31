package net.toregard.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Routes  implements Serializable {

    private static final long serialVersionUID = -9198292276822537110L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String route_id;
    private String agency_id;
    private String route_short_name;
    private String route_long_name;
    private String route_desc;
    private String route_type;
    private String route_url;
    private String route_color;
    private String route_text_color;
}
