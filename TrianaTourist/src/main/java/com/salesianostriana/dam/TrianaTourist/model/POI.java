package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI {

    @Id
    @GeneratedValue
    private Long id;

    public POI(String name, String location, String descripcion, LocalDate date, String coverPhoto, String photo2, String photo3) {
        this.name = name;
        this.location = location;
        this.descripcion = descripcion;
        this.date = date;
        this.coverPhoto = coverPhoto;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }

    private String name;
    private String location;
    @Lob
    private String descripcion;
    private LocalDate date;

    @ManyToOne
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;

    @OneToMany(mappedBy = "pointOfInterest")
    private List<RouteStep> routes = new ArrayList<>();



}
