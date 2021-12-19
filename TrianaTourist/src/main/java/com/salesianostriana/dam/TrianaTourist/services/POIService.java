package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.poiDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.poiDto.POIDtoConverter;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repos.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;
    private final CategoryService categoryService;

    public List<POI> findAll(){
        List<POI> result = poiRepository.findAll();

        if (result.isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }else{
            return result;
        }
    }

    public POI findById(Long id){
        return poiRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(),POI.class));
    }

    public POI save (CreatePOIDto p){
        POI poi = POI.builder()
                .name(p.getName())
                .location(p.getLocation())
                .descripcion(p.getDescripcion())
                .date(p.getDate())
                .category(categoryService.findById(p.getCategory()))
                .coverPhoto(p.getCoverPhoto())
                .photo2(p.getPhoto2())
                .photo3(p.getPhoto3())
                .build();
        return poiRepository.save(poi);
    }

    public POI edit (CreatePOIDto poi, Long id) {
        return poiRepository.findById(id).map(r -> {
            r.setName(poi.getName());
            return poiRepository.save(r);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));

    }

    public void deleteById (Long id){
        Optional<POI> poi = poiRepository.findById(id);
        if(poi.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),POI.class);
        }else{
            poiRepository.deleteById(id);
        }
    }


}
