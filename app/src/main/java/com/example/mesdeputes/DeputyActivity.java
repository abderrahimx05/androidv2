package com.example.mesdeputes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DeputyActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView listeViewHistorirque, textViewName, textViewCirco, textViewnaissance,textViewEmail, textViewGroupe,textViewCollabs, textViewResponsabilite, textViewAdresse;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deputy);

        textViewName= findViewById(R.id.textViewDeputyName);
        textViewCirco= findViewById(R.id.textViewDeputyCirco);
        textViewGroupe= findViewById(R.id.textViewDeputyGroupe);
        textViewEmail= findViewById(R.id.textViewDeputyEmail);
        textViewCollabs= findViewById(R.id.textViewDeputyCollabs);
        textViewResponsabilite = findViewById(R.id.textViewDeputyResp);
        textViewnaissance = findViewById(R.id.textViewDeputyNaissance);
        textViewAdresse = findViewById(R.id.textViewDeputyAdrr);
        imageView= findViewById(R.id.imageViewDeputy);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Deputy deputy= (Deputy) getIntent().getSerializableExtra("deputy");
        textViewName.setText(" Prénom :"+deputy.getFirstname()+" Nom :"+deputy.getLastname());
        textViewnaissance.setText("Date de naissance: "+deputy.getDateNaissance());
        textViewAdresse.setText("adresse : "+deputy.getAdresse());
        textViewCirco.setText("Département: " + deputy.getDepartment()+", "+
                deputy.getNameCirco()+ " "+ deputy.getNumCirco()+
                (deputy.getNumCirco()==1? "er": "eme")+" circoncription");
        textViewGroupe.setText(deputy.getGroupe());
        textViewEmail.setText("Email : "+deputy.getEmail());
        textViewCollabs.setText("Collaborateurs: "+deputy.getCollaborateurs());
        textViewResponsabilite.setText("Responsabilité : "+deputy.getResponsabilite());
        ApiServices.loadDeputyAvatar(this, deputy.getNameForAvatar(), imageView);
    }
}
