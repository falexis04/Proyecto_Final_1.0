package com.primeraweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity                                    //Para que esta clase se pueda mapear en una tabla de una base de datos debemos de agregarle la anotacion "Entity"
@Table(name = "tbl_personas")              //Para dar un nombre personalizado a la tabla usamos esta anotacion
@Data                                      //Esta se encaraga de crear los Getteders y setters
@AllArgsConstructor                        //Este se encarga de crear un constructor en cual incluye todos los campos
@NoArgsConstructor                         //Y este de crear un constructoe sin ningun campo

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Esta anotacion nos va a permitir definir extrategias de como se va a generar el Id. En este caso la extrategia es "IDENTITY" y se encarga de crear Ids aoutoincrementable, es decir que se incremente de 1 en 1
    private Long id;
    private String nombre;
    private int edad;

}
