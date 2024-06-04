package com.primeraweb.service.impl;

import com.primeraweb.entities.Persona;
import com.primeraweb.repository.PersonaRepository;
import com.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
     private PersonaRepository personaRepository;                   //El servivio depende del Respositorio


    @Override
    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();                          //De esta manera obtenemos todas las personas de la base de datos
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return  personaRepository.findById(id).orElse(null);    //findById(id): Esto lo que hace esq va a la base datos y busca una persona por su Id, y si no la encuentra en donde entra orElse(null): Que significa que va a retornar Nulo
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return  personaRepository.save(persona);                      //De esta manera estamos guardando una persona en la base de datos
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaBBDD = personaRepository.findById(id).orElse(null);
        if(personaBBDD != null){
            personaBBDD.setNombre(persona.getNombre());
            personaBBDD.setEdad(persona.getEdad());
            return personaRepository.save(personaBBDD);               //Guardamos el nuevo registro en la base de datos
        }
        return null;
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public long contarPersonas() {
        return personaRepository.count();                             //count(): Este metodo se encaraga de contar el numero de personas que se han guaradado o exiten en la tabla

    }
}
