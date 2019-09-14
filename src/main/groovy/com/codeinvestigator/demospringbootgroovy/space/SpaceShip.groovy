package com.codeinvestigator.demospringbootgroovy.space

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ToString
class SpaceShip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id
    String name = "Name not set..."
    int crew = 10
    int size = 1000
}
