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
}
