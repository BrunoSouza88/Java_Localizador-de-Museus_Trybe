package com.betrybe.museumfinder.model;

/**
 * Class Museu.
 */
public class Museum {
  private Long id;
  private String name;
  private String description;
  private String address;
  private String collectionType;
  private String subject;
  private String url;
  private Coordinate coordinate;
  private Long legacyId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public  void setName(String newName) {
    this.name = newName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String newDescription) {
    this.description = newDescription;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String newAddress) {
    this.address = newAddress;
  }

  public String getCollectionType() {
    return collectionType;
  }

  public void setCollectionType(String newCollectionType) {
    this.collectionType = newCollectionType;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String newSubject) {
    this.subject = newSubject;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String newUrl) {
    this.url = newUrl;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(Coordinate newCoordinate) {
    this.coordinate = newCoordinate;
  }

  public Long getLegacyId() {
    return legacyId;
  }

  public void setLegacyId(Long newLegacyId) {
    this.legacyId = newLegacyId;
  }
}
