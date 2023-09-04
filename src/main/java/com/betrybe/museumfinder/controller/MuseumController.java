package com.betrybe.museumfinder.controller;


import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * javadoc.
 */

@RestController
@RequestMapping("/museums")
public class MuseumController {
  MuseumServiceInterface service;

  @Autowired
  public MuseumController(MuseumServiceInterface service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Museum> createMuseum(@RequestBody MuseumDto museumDto) {
    Museum museum = ModelDtoConverter.dtoToModel(museumDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.createMuseum(museum));
  }

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getNearMuseum(
          @RequestParam("lat") Double latitude,
          @RequestParam("lng") Double longitude,
          @RequestParam("max_dist_km") Double maxDistance) {
    Museum nearMuseum = service.getClosestMuseum(new Coordinate(latitude, longitude), maxDistance);
    return ResponseEntity.ok((ModelDtoConverter.modelToDto(nearMuseum)));
  }
}