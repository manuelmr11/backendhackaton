package com.techu.recetas.recetas.controllers;

import com.techu.recetas.recetas.servicies.RecetaService;
import com.techu.recetas.recetas.models.RecetaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    RecetaService recetaService;

    @GetMapping("/lista")
    public List<RecetaModel> findall () {
        System.out.println("Lista de Recetas");

        return this.recetaService.findAll();
    }

    @PostMapping("/addReceta")
    public ResponseEntity<RecetaModel> addReceta(@RequestBody RecetaModel receta) {
        System.out.println("addreceta");
        System.out.println("El nombre de la receta a crear es " + receta.getNombre());
        System.out.println("Los ingredientes son " + receta.getIngredientes());
        System.out.println("Como se prepara " + receta.getPreparacion());
        System.out.println("El tiempo de preparacion es " + receta.getTiempo());

        return new ResponseEntity<>(this.recetaService.addReceta(receta), HttpStatus.CREATED);
    }

    @GetMapping("/lista/{nombre}")
    public ResponseEntity<Object> findById(@PathVariable String nombre) {
        System.out.println("Buscar por ID RecetaController");
        System.out.println("El nombre/id de receta a buscar es "+nombre);
        Optional<RecetaModel> result = this.recetaService.findById(nombre);

        //if para booleanos true : false
        return new ResponseEntity<>(
                result.isPresent() ? result.get() : "Receta no encontrada"
                , result.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }


}
