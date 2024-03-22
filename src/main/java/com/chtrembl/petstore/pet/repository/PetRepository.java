package com.chtrembl.petstore.pet.repository;

import com.chtrembl.petstore.pet.entity.Pet;
import com.chtrembl.petstore.pet.entity.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByStatusIn(List<StatusEnum> statuses);
}
