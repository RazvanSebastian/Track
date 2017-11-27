package edu.utcluj.track;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    TextView latitudeText;
    TextView longitudeText;
    Button startTrackingButton;
    Button stopTrackingButton;

    boolean isStart = false;

    private final static int INTERVAL = 1000 * 60 * 2; //2 minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        latitudeText = findViewById(R.id.latitudeTextView);
        longitudeText = findViewById(R.id.longitudeTextView);
        startTrackingButton = findViewById(R.id.startButton);
        stopTrackingButton = findViewById(R.id.stopButton);

        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitudeText.setText(location.getLatitude()+"");
                longitudeText.setText(location.getLongitude()+"");
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        startTrackingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
                    try{
                        onSavePosition();
                    }catch (Exception e){}
                }
                catch (SecurityException e){
                    Toast toast = Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        stopTrackingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void onSavePosition() throws JSONException,UnsupportedEncodingException {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://track-school.herokuapp.com/position";

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
