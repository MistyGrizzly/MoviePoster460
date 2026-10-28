package com.example.poster1019;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PetsRepository {

    private static PetsRepository instance;

    private final List<Pets> allPets;

    public List<Pets> getAllPets(){ return allPets;}

    public static synchronized PetsRepository getInstance(Context context){
        if (instance == null){
            instance = new PetsRepository(context.getApplicationContext());
        }
        return instance;
    }

    private PetsRepository(Context appContext){
        allPets = Collections.unmodifiableList(createPets());
    }

    public Pets findById(String id){
        for(Pets pets:allPets){
            if(pets.id.equals(id)){
                return pets;
            }
        }
        return null;
    }

    private static List<Pets> createPets(){
        List<Pets> pets = new ArrayList<>();

        Pets biscuit = new Pets();
        biscuit.id = "biscuit";
        biscuit.image = R.drawable.biscuit;
        biscuit.name = "Biscuit";
        biscuit.description = "Sample Text";
        pets.add(biscuit);

        Pets king = new Pets();
        king.id = "king";
        king.image = R.drawable.king;
        king.name = "King";
        king.description = "Sample Text";
        pets.add(king);

        Pets pumpkin = new Pets();
        pumpkin.id = "pumpkin";
        pumpkin.image = R.drawable.pumpkin;
        pumpkin.name = "Pumpkin";
        pumpkin.description = "Sample Text";
        pets.add(pumpkin);

        return pets;
    }
}
