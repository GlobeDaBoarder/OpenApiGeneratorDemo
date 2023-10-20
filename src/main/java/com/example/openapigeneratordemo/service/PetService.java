package com.example.openapigeneratordemo.service;

import generated.pet.model.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets();

    Pet createPet(Pet pet);
}
