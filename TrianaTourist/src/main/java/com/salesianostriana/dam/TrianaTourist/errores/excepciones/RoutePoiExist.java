package com.salesianostriana.dam.TrianaTourist.errores.excepciones;

public class RoutePoiExist extends EntityNotFoundException {
    public RoutePoiExist(String id, Class clazz){
        super(String.format("Ya existe un %s con ID: %s", clazz.getName(),id));
    }

}
