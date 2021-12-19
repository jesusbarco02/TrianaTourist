package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutePOIPk implements Serializable {

    private Long route_id;
    private Long poi_id;
}
