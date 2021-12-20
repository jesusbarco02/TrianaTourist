package com.salesianostriana.dam.TrianaTourist.errores.excepciones;

public class RoutePoiExist extends EntityNotFoundException {
    public RoutePoiExist(String id){
        super(String.format("Ya existe un punto de interés en la ruta con ID: %s",id));
    }

}
