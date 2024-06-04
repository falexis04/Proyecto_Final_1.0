package com.primeraweb.controller;


import com.primeraweb.entities.Persona;
import com.primeraweb.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class  PersonaController {
    @Autowired                                                                //Y con @Autowired inyectamos a PersonaService, y Cuando llamamos a la Interfas esta automaticamente llama a la implementacion
    private PersonaService personaService;                                    //El Controller depende del service y el service depende del Repository


    @GetMapping                                                                //Le indicamos que va hacer un listado con esta anotacion
    public String listarPersonas(Model model) {                                //La clase Model se utliza para transferir objetos del controller a la vista
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas",personas);               //Key-valor
        return "listar";
    }

    @GetMapping("/nueva")                                                       //Utlizamos  @GetMapping y no PostMapping porque aun no estamos creando si no simplemente llevando a un formulario
    public String mostrarFormularioDeNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/personas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")                                                       //Se encarga de guardar una persona en la base de datos
    public String guardarNuevaPersona(@ModelAttribute Persona persona) {         //@ModelAttribute:  Esta anotacion nos sirve para
        personaService.crearPersona(persona);
        return "redirect:/personas";                                             //Luego de guardar una persona en la base de datos te va a redirigir al empoi de personas
    }

    @GetMapping("/editar/{id}")                                                                                    //Utlizamos  @GetMapping y no PostMapping porque aun no estamos creando si no simplemente llevando a un formulario
    public String EditarPersona(@PathVariable Long id,@ModelAttribute Persona persona, Model model) {              //@PathVariable: Nos permite pasarle al URL variables, en este caso es el id y se le pasa asi: /Editar/{id}
        model.addAttribute("persona",persona);
        model.addAttribute("accion", "/personas/editar/"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Long id,@ModelAttribute Persona persona) {
        personaService.actualizarPersona(id, persona);
        return "redirect:/personas";                                            //Ecribismos redirect para que nos redireccione al emboi de personas
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
