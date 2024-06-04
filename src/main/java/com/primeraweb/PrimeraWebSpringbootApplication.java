package com.primeraweb;

import com.primeraweb.entities.Persona;
import com.primeraweb.repository.PersonaRepository;
import com.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrimeraWebSpringbootApplication {                      //"CommandLineRunner" Nos sirve para indicar que un elemento debe de ejecutarse cuando esta dentro de una aplicacion
    @Autowired                                                      // @Autowired: Esta anotacion sirve para poder inyectar en este caso PersonaRepository
    private PersonaService personaService;                           //Cuando llamamos a la Interfas esta automaticamente llama a la implementacion

    public static void main(String[] args) {
            SpringApplication.run(PrimeraWebSpringbootApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {

        personaService.crearPersona(new Persona(5L, "Luz", 19));                    //personaRepositorY es una interfas y esta llamando al metodo save el cual hereda de JPArepository
        personaService.crearPersona(new Persona(6L, "Angie", 15));                  //y este se encaraga de guaradar uan entidad a una base de datos
        personaService.crearPersona(new Persona(7L, "Moto", 45));
        personaService.crearPersona(new Persona(8L, "Pipe", 24));

        //Mostramos el numero de personas
        System.out.println("Numero de Personas en la Tabla: "+ personaService.contarPersonas());     //count(): Este metodo se encaraga de contar el numero de personas que se han guaradado o exiten en la tabla

        //Mostramos la lista de Personas
        List<Persona> personas = personaService.obtenerTodas();
        personas.forEach(persona -> System.out.println("Nombre de la Persona: "+persona.getNombre() + " -> Id: "+persona.getId() + " -> Edad: "+persona.getEdad()));
    }*/
}

//implements CommandLineRunner
//create-drop
//update