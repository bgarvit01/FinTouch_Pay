package me.aflak.fingerprintdialoglibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.aflak.libraries.callback.FingerprintCallback;
import me.aflak.libraries.view.Fingerprint;

/**
 * Created by Omar on 08/01/2018.
 */

public class SimpleView extends AppCompatActivity implements FingerprintCallback {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Fingerprint fingerprint = findViewById(R.id.activity_view_example_fingerprint);
        fingerprint.callback(this)
            .circleScanningColor(android.R.color.black)
            .fingerprintScanningColor(R.color.colorAccent)
            .authenticate();


    }

    @Override
    public void onAuthenticationSucceeded() {
        Intent intent=new Intent(this,midactivity.class);
        startActivity(intent);

        // Logic when fingerprint is recognized
    }

    @Override
    public void onAuthenticationFailed() {
        Toast.makeText(getApplicationContext(),"INVALID USER",Toast.LENGTH_SHORT).show();
        // Logic when fingerprint failed to recognize
    }

    @Override
    public void onAuthenticationError(int errorCode, String error) {
        Toast.makeText(getApplicationContext(),"FAILED!,RETRY",Toast.LENGTH_LONG).show();

        // Logic when an error raised while authenticating
        // See Android Doc for errorCode meaning
    }
}
