package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "route")
    private List<RoutePOI> steps = new ArrayList<>();

    public Route( String name) {
        this.name = name;
    }


}
