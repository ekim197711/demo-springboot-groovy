package com.codeinvestigator.demospringbootgroovy.space

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.PostConstruct

@RestController
class SpaceShipRestController {

    SpaceShipRepository repository

    SpaceShipRestController(SpaceShipRepository repository){
        this.repository = repository
    }

    @PostConstruct
    def initSpaceShips(){
        List<String> strs = [
                new SpaceShip(name: 'HugeShip', crew: 23),
                new SpaceShip(name: 'Smallship', size: 2233),
                new SpaceShip(name: 'Eagle'),
                new SpaceShip(name: 'Raven', crew: 250, size: 454)
        ].each { ship -> ship.name = ship.name + "Now from H2 DATABASE!!!" }
        strs

        this.repository.saveAll(strs)
    }

    @GetMapping("/ships")
    List ships(){
        repository.findAll()
    }

    @GetMapping("/captains")
        Map captains(){
            [
                    'Natasha': new SpaceShip(name: 'Pink lady'),
                    'Mike': new SpaceShip(name: 'Eagleship'),
                    'Jens': new SpaceShip(name: 'OldAndDirty'),
                    'Jan': new SpaceShip(name: 'SlowButSteady'),
                    'Jette': new SpaceShip(name: 'LoudAndNoisy'),
                    'Sofia': new SpaceShip(name: 'Blue Ship')
            ].each {entryset -> println "$entryset.key matches the value $entryset.value"}
        .each {key, value -> println "Key $key, Value: $value"}
        .each {key, value -> value.crew = value.crew*10}
    }
}


