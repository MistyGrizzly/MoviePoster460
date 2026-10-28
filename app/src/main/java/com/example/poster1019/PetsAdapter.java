package com.example.poster1019;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.PetsViewHolder> {

    //  The same adapter and card layout are used on two pages.

    public void setPets(List<Pets> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    private List<Pets> pets;


    public PetsAdapter(List<Pets> pets){
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PetsViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_container_poster,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull PetsAdapter.PetsViewHolder holder, int position) {
        holder.bindPets(pets.get(position));

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public List<Pets> getSelectedPets(){
        List<Pets> selectedPets = new ArrayList<>();
        for (Pets pet : pets){
            if (pet.isSelected){
                selectedPets.add(pet);
            }
        }
        return selectedPets;
    }

    class PetsViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layoutPets;
        View viewbackground;
        RoundedImageView imagePets;
        TextView textName,textDescription;

        public PetsViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutPets = itemView.findViewById(R.id.layoutPets);
            viewbackground = itemView.findViewById(R.id.viewBackground);
            imagePets = itemView.findViewById(R.id.imagePets);
            textName = itemView.findViewById(R.id.textPetName);
            textDescription = itemView.findViewById(R.id.textPetDescription);
        }

        void bindPets(final Pets pets){
            imagePets.setImageResource(pets.image);
            textName.setText(pets.name);
            textDescription.setText(pets.description);

        }


    }
}
