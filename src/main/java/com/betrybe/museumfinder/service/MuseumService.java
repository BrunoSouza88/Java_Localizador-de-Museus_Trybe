package com.betrybe.museumfinder.service;


import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * javadoc.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  MuseumFakeDatabase database;

  @Autowired
  public MuseumService(MuseumFakeDatabase db) {
    this.database = db;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    Coordinate newCoordinate =
              new Coordinate(museum.getCoordinate().latitude(), museum.getCoordinate().longitude());
    if (!CoordinateUtil.isCoordinateValid(newCoordinate)) {
      throw new InvalidCoordinateException();
    } else {
      return database.saveMuseum(museum);
    }
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    Coordinate newCoordinate = new Coordinate(coordinate.latitude(), coordinate.longitude());
    if (!CoordinateUtil.isCoordinateValid(newCoordinate)) {
      throw new InvalidCoordinateException();
    }
    return database.getClosestMuseum(newCoordinate, maxDistance)
         .orElseThrow(() -> new MuseumNotFoundException());
  }

  @Override
  public Museum getMuseum(Long id) {
    return database.getMuseum(id)
            .orElseThrow(() -> new MuseumNotFoundException());
  }
}