package com.example.poster1019;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    public ContactFragment(){
        super(R.layout.fragment_contact);
    }
    // Button added for changing the contact us text
    private Button infoButton;
    private TextView aboutUs;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // additional information button and initialized text view to edit
        infoButton = view.findViewById(R.id.additional_info);
        aboutUs = view.findViewById(R.id.about_us);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aboutUs.getText().equals(getString(R.string.company_intro))) {
                    aboutUs.setText(getString(R.string.about_me));
                } else if (aboutUs.getText().equals(getString(R.string.about_me))) {
                    aboutUs.setText(getString(R.string.company_intro));
                }
            }
        });

        view.findViewById(R.id.layoutEmail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmailApp(getString(R.string.contact_email));
            }
        });
    }

    private void openEmailApp(String emailAddress){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+emailAddress));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(requireContext(),R.string.no_email_app,Toast.LENGTH_SHORT).show();
        }
    }


}
