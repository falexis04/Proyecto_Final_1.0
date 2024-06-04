package com.primeraweb.repository;

import com.primeraweb.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Estereotipos
public interface PersonaRepository extends JpaRepository<Persona,Long> { //"JpaRepository<Persona,Long>" Una interfas siempre va a heredar una clase "JpaRepository" y despues le pasamos el tipo de identidad y luego el tipo de Id de esa identidad en este caso "Long"


}
