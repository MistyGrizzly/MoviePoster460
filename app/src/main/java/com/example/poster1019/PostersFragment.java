package com.example.poster1019;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostersFragment extends Fragment implements posterListener {

    private Button buttonAddtoWatchList;

    public PostersFragment(){
        super(R.layout.fragment_posters);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //find the list and the button
        RecyclerView posterRecyclerView = view.findViewById(R.id.posTersRecyclerView);
        buttonAddtoWatchList  = view.findViewById(R.id.buttonAddToWatchlist);

        List<Posters> posters = new ArrayList<>();

        Posters the100 = new Posters();
        the100.image = R.drawable.poster3;
        the100.name = "Vietnam Movie";
        the100.rating = 5f;
        the100.createdBy = "Cuong Ngo";
        the100.story = "This is an Vietnam Movie with a young lady";
        posters.add(the100);

        Posters chineseMovie = new Posters();
        chineseMovie.image = R.drawable.poster4;
        chineseMovie.name = "Chinese Movie";
        chineseMovie.rating = 4f;
        chineseMovie.createdBy = "Zhang San";
        chineseMovie.story = "This is an Chinese Movie with a young lady.";
        posters.add(chineseMovie);

        Posters japanMovie = new Posters();
        japanMovie.image = R.drawable.poster1;
        japanMovie.name = "Japanese Movie";
        japanMovie.rating = 3f;
        japanMovie.createdBy = "Juzo Itami";
        japanMovie.story = "This is an Japanese Movie.";
        posters.add(japanMovie);

        Posters americanMovie = new Posters();
        americanMovie.image = R.drawable.poster2;
        americanMovie.name = "American Movie";
        americanMovie.rating = 5f;
        americanMovie.createdBy = "Tim Burton";
        americanMovie.story = "This is an American Movie.";
        posters.add(americanMovie);

        //connect the list to its adapter
        final PostersAdapter postersAdapter = new PostersAdapter(posters, this);
//        final PostersAdapter postersAdapter = new PostersAdapter(posters, (posterListener) this);
        posterRecyclerView.setAdapter(postersAdapter);

        //show the selected names
        buttonAddtoWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Posters> selectPosters = postersAdapter.getSelectedPosters();

                StringBuilder names = new StringBuilder();
                for (int i = 0; i<selectPosters.size();i++){
                    if(i>0){
                        names.append("\n");
                    }
                    names.append(selectPosters.get(i).name);
                }
                Toast.makeText(requireContext(),names.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddtoWatchList.setVisibility(View.VISIBLE);
        }else{
            buttonAddtoWatchList.setVisibility(View.GONE);
        }

    }
}
