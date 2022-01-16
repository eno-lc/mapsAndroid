package com.example.androidone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView textView;
    EditText editText;
    MyTTS myTTS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        editText = findViewById(R.id.editTextTextPersonName);
        myTTS = new MyTTS(this);
    }



    public void go1(View view){
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        }else{
            Toast.makeText(this, "Permission already given", Toast.LENGTH_LONG).show();
        }
    }

    public void gps(View view) {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Please allow permissions", Toast.LENGTH_LONG).show();
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        //stop gps>>>
        //locationManager.removeUpdates(this);
    }




    public void go2(View view){
        String message = editText.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("mymessage",message);
        startActivity(intent);
    }

    public void speak(View view){
        myTTS.speak(editText.getText().toString());
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        textView.setText(String.valueOf(location.getLatitude() + ", " + String.valueOf(location.getLongitude())));
        editText.setText(String.valueOf(location.getLatitude() + ", " + String.valueOf(location.getLongitude())));
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}