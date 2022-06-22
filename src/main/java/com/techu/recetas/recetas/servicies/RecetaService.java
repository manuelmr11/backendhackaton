package com.techu.recetas.recetas.servicies;

import com.techu.recetas.recetas.models.RecetaModel;
import com.techu.recetas.recetas.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    @Autowired
    RecetaRepository recetaRepository;

    public List<RecetaModel> findAll() {

        System.out.println("Todas las recetas");

        return this.recetaRepository.findAll();

    }

    public Optional<RecetaModel> findById(String nombre) {
        System.out.println("Todas las recetas");
        return this.recetaRepository.findById(nombre);
    }

    public RecetaModel addReceta(RecetaModel receta) {
        System.out.println("addReceta an recetaService");

        return this.recetaRepository.save(receta);

    }

    public boolean update(RecetaModel receta, String nombre) {
          System.out.println("update an RecetaService");

          boolean result = false;

           if (this.findById(nombre).isPresent() == true) {

                System.out.println("Receta a acutalizar encontrada " + nombre);
                receta.setNombre(nombre);
                receta.setTiempo(receta.getTiempo());
                receta.setIngredientes(receta.getIngredientes());
                receta.setPreparacion(receta.getPreparacion());
                receta.setFoto(receta.getFoto());
                this.recetaRepository.save(receta);

                result = true;
            }

            return result;

    }

    public boolean delete(String nombre) {

        System.out.println("delete an recetaService");

        boolean result = false;

        if (this.findById(nombre).isPresent() == true) {
            System.out.println("Usuario encontrado");
            this.recetaRepository.delete(this.findById(nombre).get());

            result = true;
        }

        return result;
    }


}
