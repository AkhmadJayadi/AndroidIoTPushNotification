package com.example.realtimesensoriotrevisi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class Cover extends AppCompatActivity {
    private Button tombolBuka, tombolTutup;
    private ImageView kotaksampah;
    private Firebase mRefTutupSampah;
    private TextView TutupSampah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        tombolBuka = findViewById(R.id.buttonBukaTempatSampah);
        tombolTutup = findViewById(R.id.buttonTutupTempatSampah);
        kotaksampah = (ImageView) findViewById(R.id.imageViewBukaKotakSampah);
        TutupSampah = findViewById(R.id.textViewNilaiTutupKotakSampah);

        //buka kirim data ke firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        tombolBuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference tutupsampah = database.getReference("tutupsampah");
                tutupsampah.setValue(1);
                kotaksampah.setImageResource(R.drawable.kotaksampahopen);
                Toast.makeText(getApplicationContext(),"Tempat Sampah Terbuka", Toast.LENGTH_SHORT).show();
            }
        });

        tombolTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference tutupsampah = database.getReference("tutupsampah");
                tutupsampah.setValue(0);
                kotaksampah.setImageResource(R.drawable.kotaksampahtutup);
                Toast.makeText(getApplicationContext(),"Tempat Sampah Tertutup", Toast.LENGTH_SHORT).show();
            }
        });

        //Cover
        mRefTutupSampah = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/tutupsampah");
        mRefTutupSampah.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String TutupSampahh = dataSnapshot.getValue(String.class);
                TutupSampah.setText(TutupSampahh);

                int TutupSampahhh = 0;

                try {
                    TutupSampahhh = Integer.parseInt(TutupSampahh);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(TutupSampahhh==0){
                    kotaksampah.setImageResource(R.drawable.kotaksampahtutup);
                }else if(TutupSampahhh==1){
                    kotaksampah.setImageResource(R.drawable.kotaksampahopen);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


}