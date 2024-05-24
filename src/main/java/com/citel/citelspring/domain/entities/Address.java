package com.citel.citelspring.domain.entities;

public class Address {
  int id;
  String zipCode;
  String street;
  int number;
  String neighborhood;
  String city;
  String state;

  public Address(int id, String zipCode, String street, int number, String neighborhood, String city, String state) {
    this.id = id;
    this.zipCode = zipCode;
    this.street = street;
    this.number = number;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getZipCode() {
    return zipCode;
  }

}