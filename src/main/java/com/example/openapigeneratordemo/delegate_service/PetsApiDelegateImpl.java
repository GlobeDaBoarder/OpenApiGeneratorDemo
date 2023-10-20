package com.example.openapigeneratordemo.delegate_service;

import com.example.openapigeneratordemo.service.PetService;
import generated.pet.api.PetsApiDelegate;
import generated.pet.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetsApiDelegateImpl implements PetsApiDelegate {

    private final PetService petService;

    @Override
    public ResponseEntity<Pet> createPet(Pet pet) {
        return ResponseEntity.ok(petService.createPet(pet));
    }

    @Override
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }
}
