package org.taohansen.tp3infnet_spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.taohansen.tp3infnet_spring.entities.Material;

@Repository
public interface MaterialRepository extends MongoRepository<Material, String> {
}