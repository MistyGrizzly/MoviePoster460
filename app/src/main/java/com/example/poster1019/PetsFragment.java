package com.example.poster1019;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class PetsFragment extends Fragment {

    private PetsRepository petsRepository;

    public PetsFragment(){super(R.layout.fragment_pets);}

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        petsRepository = PetsRepository.getInstance(requireContext());
        List<Pets> pets = petsRepository.getAllPets();
    }
}
