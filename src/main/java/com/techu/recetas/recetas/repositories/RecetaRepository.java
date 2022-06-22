package com.techu.recetas.recetas.repositories;

import com.techu.recetas.recetas.models.RecetaModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecetaRepository extends MongoRepository<RecetaModel,String> {
}
