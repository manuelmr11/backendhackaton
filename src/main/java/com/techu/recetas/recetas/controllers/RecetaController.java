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
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
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

    @PutMapping("/lista/{nombre}")
    public ResponseEntity<Object> updateReceta(
            @RequestBody RecetaModel receta,
            @PathVariable String nombre) {

        System.out.println("updateReceta");
        System.out.println("La id del parametro que se va a actualizar es " + nombre);
        System.out.println("El nombre de la receta a actualizar es " + receta.getNombre());
        System.out.println("Los ingredientes son " + receta.getIngredientes());
        System.out.println("Como se prepara " + receta.getPreparacion());
        System.out.println("El tiempo de preparacion es " + receta.getTiempo());

        Optional<RecetaModel> purchaseToUpdate = this.recetaService.findById(nombre);

        boolean updatePurchase = this.recetaService.update(receta, nombre);

        return new ResponseEntity<>(
                updatePurchase ? "Usuario actualizado" : "Usuario No Existe",
                updatePurchase ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @DeleteMapping("/lista/{nombre}")
    public ResponseEntity<Object> deleteReceta(@PathVariable String nombre) {
        System.out.println("deleteReceta");
        System.out.println("La id del parametro que se va a borrar es " + nombre);

        boolean deleteReceta = this.recetaService.delete(nombre);

        return new ResponseEntity<>(
                deleteReceta ? "Compra borrada" : "Compra No Borrada",
                deleteReceta ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }


}
