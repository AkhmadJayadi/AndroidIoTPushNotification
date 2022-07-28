package com.example.realtimesensoriotrevisi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private TextView Cover, Logam, Nonorganik, Organik, Otomatis;
    private Firebase mRefCover, mRefLogam, mRefNonOrganik, mRefOrganik, mRefOtomatis;
    private View viewsatu, viewdua, viewtiga, viewempat, viewlima, viewenam, viewtujuh, viewdelapan, viewsembilan,
            viewsepuluh, viewsebelas, viewduabelas, viewtigabelas, viewempatbelas, viewlimabelas;
    //private Button tomboltutupsampah, tombolbukasampah;
    private static final String TAG = "";
    private RequestQueue queue;
    private EditText caritoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        //Log.d(TAG, "Token : "+token);
        queue = Volley.newRequestQueue(this);
//
//        tomboltutupsampah = findViewById(R.id.button3);
//        tombolbukasampah = findViewById(R.id.button4);
        Cover = (TextView)findViewById(R.id.CoverValue);
        Logam = (TextView)findViewById(R.id.LogamValue);
        Nonorganik = (TextView)findViewById(R.id.NonOrganikValue);
        Organik = (TextView)findViewById(R.id.OrganikValue);
        Otomatis = (TextView)findViewById(R.id.OtomatisValue);
        caritoken = (EditText)findViewById(R.id.editTextTextPersonName);

        caritoken.setText(token);

        viewsatu = (View)findViewById(R.id.myRectangleView1);
        viewdua = (View)findViewById(R.id.myRectangleView2);
        viewtiga = (View)findViewById(R.id.myRectangleView3);
        viewempat = (View)findViewById(R.id.myRectangleView4);
        viewlima = (View)findViewById(R.id.myRectangleView5);
        viewenam = (View)findViewById(R.id.myRectangleView6);
        viewtujuh = (View)findViewById(R.id.myRectangleView7);
        viewdelapan = (View)findViewById(R.id.myRectangleView8);
        viewsembilan = (View)findViewById(R.id.myRectangleView9);
        viewsepuluh = (View)findViewById(R.id.myRectangleView10);
        viewsebelas = (View)findViewById(R.id.myRectangleView11);
        viewduabelas = (View)findViewById(R.id.myRectangleView12);
        viewtigabelas = (View)findViewById(R.id.myRectangleView13);
        viewempatbelas = (View)findViewById(R.id.myRectangleView14);
        viewlimabelas = (View)findViewById(R.id.myRectangleView15);

//        //buka kirim data ke firebase
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        tomboltutupsampah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseReference tutupsampah = database.getReference("tutupsampah");
//                tutupsampah.setValue(1);
//            }
//        });
//
//        tombolbukasampah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatabaseReference tutupsampah = database.getReference("tutupsampah");
//                tutupsampah.setValue(0);
//            }
//        });

        //tutup kirim data ke firebase

        //Cover
        mRefCover = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/cover");
        mRefCover.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Coverr = dataSnapshot.getValue(String.class);
                Cover.setText(Coverr);

                int Coverrr = 0;

                try {
                    Coverrr = Integer.parseInt(Coverr);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(Coverrr>=0 && Coverrr<=20){

                }else if(Coverrr>=21 && Coverrr<=40){

                }else if(Coverrr>=41 && Coverrr<=60){

                }else if(Coverrr>=61 && Coverrr<=80){

                }else if(Coverrr>=81 && Coverrr<=100){

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        //Logam
        mRefLogam = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/logam");
        mRefLogam.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Logamm = dataSnapshot.getValue(String.class);
                Logam.setText(Logamm);

                int Logammm = 0;

                try {
                    Logammm = Integer.parseInt(Logamm);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(Logammm>=0 && Logammm<=20){
                    viewsebelas.setVisibility(View.INVISIBLE);
                    viewduabelas.setVisibility(View.INVISIBLE);
                    viewtigabelas.setVisibility(View.INVISIBLE);
                    viewempatbelas.setVisibility(View.INVISIBLE);
                    viewlimabelas.setVisibility(View.VISIBLE);
                }else if(Logammm>=21 && Logammm<=40){
                    viewsebelas.setVisibility(View.INVISIBLE);
                    viewduabelas.setVisibility(View.INVISIBLE);
                    viewtigabelas.setVisibility(View.INVISIBLE);
                    viewempatbelas.setVisibility(View.VISIBLE);
                    viewlimabelas.setVisibility(View.VISIBLE);
                }else if(Logammm>=41 && Logammm<=60){
                    viewsebelas.setVisibility(View.INVISIBLE);
                    viewduabelas.setVisibility(View.INVISIBLE);
                    viewtigabelas.setVisibility(View.VISIBLE);
                    viewempatbelas.setVisibility(View.VISIBLE);
                    viewlimabelas.setVisibility(View.VISIBLE);
                }else if(Logammm>=61 && Logammm<=80){
                    viewsebelas.setVisibility(View.INVISIBLE);
                    viewduabelas.setVisibility(View.VISIBLE);
                    viewtigabelas.setVisibility(View.VISIBLE);
                    viewempatbelas.setVisibility(View.VISIBLE);
                    viewlimabelas.setVisibility(View.VISIBLE);
                }else if(Logammm>=81 && Logammm<=100){
                    viewsebelas.setVisibility(View.VISIBLE);
                    viewduabelas.setVisibility(View.VISIBLE);
                    viewtigabelas.setVisibility(View.VISIBLE);
                    viewempatbelas.setVisibility(View.VISIBLE);
                    viewlimabelas.setVisibility(View.VISIBLE);

                    Toast.makeText(getApplicationContext(),"Tempat Sampah Logam Penuh", Toast.LENGTH_SHORT).show();
                    sendNotification("Warning", "Tempat%20Sampah%20Logam%20Penuh", token);
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        //nonorganik
        mRefNonOrganik = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/nonorganik");
        mRefNonOrganik.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Nonorganikk = dataSnapshot.getValue(String.class);
                Nonorganik.setText(Nonorganikk);

                int Nonorganikkk = 0;

                try {
                    Nonorganikkk = Integer.parseInt(Nonorganikk);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(Nonorganikkk>=0 && Nonorganikkk<=20){
                    viewsatu.setVisibility(View.INVISIBLE);
                    viewdua.setVisibility(View.INVISIBLE);
                    viewtiga.setVisibility(View.INVISIBLE);
                    viewempat.setVisibility(View.INVISIBLE);
                    viewlima.setVisibility(View.VISIBLE);
                }else if(Nonorganikkk>=21 && Nonorganikkk<=40){
                    viewsatu.setVisibility(View.INVISIBLE);
                    viewdua.setVisibility(View.INVISIBLE);
                    viewtiga.setVisibility(View.INVISIBLE);
                    viewempat.setVisibility(View.VISIBLE);
                    viewlima.setVisibility(View.VISIBLE);
                }else if(Nonorganikkk>=41 && Nonorganikkk<=60){
                    viewsatu.setVisibility(View.INVISIBLE);
                    viewdua.setVisibility(View.INVISIBLE);
                    viewtiga.setVisibility(View.VISIBLE);
                    viewempat.setVisibility(View.VISIBLE);
                    viewlima.setVisibility(View.VISIBLE);
                }else if(Nonorganikkk>=61 && Nonorganikkk<=80){
                    viewsatu.setVisibility(View.INVISIBLE);
                    viewdua.setVisibility(View.VISIBLE);
                    viewtiga.setVisibility(View.VISIBLE);
                    viewempat.setVisibility(View.VISIBLE);
                    viewlima.setVisibility(View.VISIBLE);
                }else if(Nonorganikkk>=81 && Nonorganikkk<=100){
                    viewsatu.setVisibility(View.VISIBLE);
                    viewdua.setVisibility(View.VISIBLE);
                    viewtiga.setVisibility(View.VISIBLE);
                    viewempat.setVisibility(View.VISIBLE);
                    viewlima.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Tempat Sampah Anorganik Penuh", Toast.LENGTH_SHORT).show();
                    sendNotification("Warning", "Tempat%20Sampah%20Anorganik%20Penuh", token);
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        //organik
        mRefOrganik = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/organik");
        mRefOrganik.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String organikk = dataSnapshot.getValue(String.class);
                Organik.setText(organikk);

                int organikkk = 0;

                try {
                    organikkk = Integer.parseInt(organikk);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(organikkk>=0 && organikkk<=20){
                    viewenam.setVisibility(View.INVISIBLE);
                    viewtujuh.setVisibility(View.INVISIBLE);
                    viewdelapan.setVisibility(View.INVISIBLE);
                    viewsembilan.setVisibility(View.INVISIBLE);
                    viewsepuluh.setVisibility(View.VISIBLE);
                }else if(organikkk>=21 && organikkk<=40){
                    viewenam.setVisibility(View.INVISIBLE);
                    viewtujuh.setVisibility(View.INVISIBLE);
                    viewdelapan.setVisibility(View.INVISIBLE);
                    viewsembilan.setVisibility(View.VISIBLE);
                    viewsepuluh.setVisibility(View.VISIBLE);
                }else if(organikkk>=41 && organikkk<=60){
                    viewenam.setVisibility(View.INVISIBLE);
                    viewtujuh.setVisibility(View.INVISIBLE);
                    viewdelapan.setVisibility(View.VISIBLE);
                    viewsembilan.setVisibility(View.VISIBLE);
                    viewsepuluh.setVisibility(View.VISIBLE);
                }else if(organikkk>=61 && organikkk<=80){
                    viewenam.setVisibility(View.INVISIBLE);
                    viewtujuh.setVisibility(View.VISIBLE);
                    viewdelapan.setVisibility(View.VISIBLE);
                    viewsembilan.setVisibility(View.VISIBLE);
                    viewsepuluh.setVisibility(View.VISIBLE);
                }else if(organikkk>=81 && organikkk<=100){
                    viewenam.setVisibility(View.VISIBLE);
                    viewtujuh.setVisibility(View.VISIBLE);
                    viewdelapan.setVisibility(View.VISIBLE);
                    viewsembilan.setVisibility(View.VISIBLE);
                    viewsepuluh.setVisibility(View.VISIBLE);

                    Toast.makeText(getApplicationContext(),"Tempat Sampah Organik Penuh", Toast.LENGTH_SHORT).show();
                    sendNotification("Warning", "Tempat%20Sampah%20Organik%20Penuh", token);
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        //otomatis
        mRefOtomatis = new Firebase("https://realtimesensoriot-729ff-default-rtdb.firebaseio.com/otomatis");
        mRefOtomatis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String Otomatiss = dataSnapshot.getValue(String.class);
                Otomatis.setText(Otomatiss);

                int Otomatisss = 0;

                try {
                    Otomatisss = Integer.parseInt(Otomatiss);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

                if(Otomatisss>=0 && Otomatisss<=20){

                }else if(Otomatisss>=21 && Otomatisss<=40){

                }else if(Otomatisss>=41 && Otomatisss<=60){

                }else if(Otomatisss>=61 && Otomatisss<=80){

                }else if(Otomatisss>=81 && Otomatisss<=100){

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });


    }

    public void sendNotification(String title, String body, String tokenn) {
        RequestQueue queue = Volley.newRequestQueue(this);

        final String judul = "judul="+title;
        final String isi = "&isi="+body;
        final String tokennn = "&token="+tokenn;
        //Toast.makeText(getApplicationContext(),tokenn, Toast.LENGTH_SHORT).show();
        //final String URL_PREFIX = "http://192.168.244.22:8080/firebase01/kirimnotifikasi.php?";
        final String URL_PREFIX = "https://sidosari.com/firebase01/kirimnotifikasi.php?";

        String url = URL_PREFIX + judul + isi + tokennn;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //textView.setText("Response is: " + response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

//    private void sendNotification(String messageTitle, String messageBody) {
//
//        //'MainActivity' is the target activity. When notification will be clicked, 'MainActivity' will be triggered
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//                PendingIntent.FLAG_ONE_SHOT);
//
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//        NotificationCompat.Builder notificationBuilder =
//                new NotificationCompat.Builder(this, "m")
//                        .setContentTitle(messageTitle)
//                        .setContentText(messageBody)
//                        .setAutoCancel(true)
//                        .setSound(defaultSoundUri)
//                        .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//        // Since android Oreo notification channel is needed.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel("m",
//                    "Channel human readable title",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
//    }



}