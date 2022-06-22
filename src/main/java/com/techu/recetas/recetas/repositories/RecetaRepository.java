package com.techu.recetas.recetas.repositories;

import com.techu.recetas.recetas.models.RecetaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends MongoRepository<RecetaModel,String> {
}
