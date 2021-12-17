package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
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

    private String name;
    private String location;
    private String descripcion;
    private LocalDate date;

    @ManyToOne
    private POI category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
}
