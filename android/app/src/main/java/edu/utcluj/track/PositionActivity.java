package edu.utcluj.track;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class PositionActivity extends AppCompatActivity {

    LocationManager locationManager;
    LocationListener locationListener;

    boolean start = false;

    TextView latitudeText;
    TextView longitudeText;
    Button startTrackingButton;
    Button stopTrackingButton;
    Runnable runnable;

    boolean isStart = false;

    private final static int INTERVAL = 1000 * 60 * 2; //2 minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        latitudeText = findViewById(R.id.latitudeTextView);
        longitudeText = findViewById(R.id.longitudeTextView);
        startTrackingButton = findViewById(R.id.startButton);
        stopTrackingButton = findViewById(R.id.stopButton);

        locationManager = (LocationManager) getSystemService(getApplicationContext().LOCATION_SERVICE);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (start) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getLocation();
                            try {
                                onSavePosition();
                            } catch (Exception e) {
                            }
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        startTrackingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start = true;
                AsyncTask.execute(runnable);
            }
        });

        stopTrackingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start = false;
            }
        });
    }

    private void getLocation(){
        GpsTracker gpsTracker = new GpsTracker(this);
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            this.latitudeText.setText(String.valueOf(latitude));
            this.longitudeText.setText(String.valueOf(longitude));
            Log.i("Info#####:",latitude+" "+longitude);
        }else{
            gpsTracker.showSettingsAlert();
        }
    }

    private void onSavePosition() throws JSONException,UnsupportedEncodingException {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://192.168.43.77:8085/position";

        JSONObject jsonParams = new JSONObject();
        jsonParams.put("createTime", System.currentTimeMillis());
        jsonParams.put("latitude", latitudeText.getText());
        jsonParams.put("longitude", longitudeText.getText());

        StringEntity entity = new StringEntity(jsonParams.toString());
        client.addHeader("token", StoreManager.readToken(getApplicationContext()));

        client.post(getApplicationContext(), url, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    Toast toast = Toast.makeText(getApplicationContext(), "Fail : " + new String(responseBody, "UTF-8"), Toast.LENGTH_LONG);
                    toast.show();
                } catch (Exception e) {
                }
            }
        });
    }
}
