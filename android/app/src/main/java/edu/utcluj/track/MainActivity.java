package edu.utcluj.track;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Login process here; if on device is register a user will be automatically login
 */

public class MainActivity extends Activity {

    EditText emailInput;
    EditText passwordInput;
    Button loginButton;
    Button registerButton;

    private Gson gson;

    private  String deviceToken;


    @Override
    protected void onResume() {
        super.onResume();
        StoreManager.storeToken(getApplicationContext(),"invalid");
        /*
         * Check if the device is already login
         */
        if(!StoreManager.readToken(getApplicationContext()).equals("tokenNotFound")) {
            checkTokenStored();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceToken = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        emailInput = findViewById(R.id.emailLoginInput);
        passwordInput = findViewById(R.id.passwordLoginInput);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        gson = new Gson();

        loginButton.setOnClickListener(new View.OnClickListener() {
            public  void onClick (View v) {
                try {
                    onLoginDevice();
                }
                catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                try {
                    onRegisterNewDevice();
                }
                catch (Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    /**
     * Http request to do a login POST with @email @password and @deviceID
     *
     * @throws JSONException
     * @throws UnsupportedEncodingException
     */
    private void onLoginDevice() throws JSONException,UnsupportedEncodingException{
        String url="https://track-school.herokuapp.com/device/authentication";
        AsyncHttpClient client = new AsyncHttpClient();

        JSONObject jsonParams = new JSONObject();
        jsonParams.put("email", emailInput.getText());
        jsonParams.put("password", passwordInput.getText());
        jsonParams.put("deviceToken",deviceToken);
        StringEntity entity = new StringEntity(jsonParams.toString());

        client.post(getApplicationContext(),url, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    StoreManager.storeToken(getApplicationContext(),new String(responseBody,"UTF-8"));
                    Toast toast = Toast.makeText(getApplicationContext(), "Login success!", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(getBaseContext(), PositionActivity.class);
                    startActivity(intent);
                }
                catch (Exception e){}

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    Toast toast = Toast.makeText(getApplicationContext(), "Fail : "+new String(responseBody, "UTF-8"), Toast.LENGTH_LONG);
                    toast.show();
                }
                catch (Exception e){}
            }
        });
    }

    /**
     * Http request to do a register POST with @email @password and @deviceID
     *
     * @throws JSONException
     * @throws UnsupportedEncodingException
     */
    private void onRegisterNewDevice() throws JSONException,UnsupportedEncodingException {
        String url="https://track-school.herokuapp.com/device";
        AsyncHttpClient client = new AsyncHttpClient();

        JSONObject jsonParams = new JSONObject();
        jsonParams.put("email", emailInput.getText());
        jsonParams.put("password", passwordInput.getText());
        jsonParams.put("deviceToken",deviceToken);
        StringEntity entity = new StringEntity(jsonParams.toString());

        client.post(getApplicationContext(),url, entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    Toast toast = Toast.makeText(getApplicationContext(), "Registration success!", Toast.LENGTH_LONG);
                    toast.show();
                }
                catch (Exception e){}

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    Toast toast = Toast.makeText(getApplicationContext(), "Fail : "+new String(responseBody, "UTF-8"), Toast.LENGTH_LONG);
                    toast.show();
                }
                catch (Exception e){}
            }
        });
    }

    /**
     *
     * @return true if the device is registered and the user has passed the login part
     */
    private void checkTokenStored() {
        String url = "https://track-school.herokuapp.com/device";
        AsyncHttpClient client = new AsyncHttpClient();

        client.addHeader("token", StoreManager.readToken(getApplicationContext()));

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Intent intent = new Intent(getBaseContext(), PositionActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast toast = Toast.makeText(getApplicationContext(), "You must to login again!", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
