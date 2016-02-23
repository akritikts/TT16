package in.silive.techtrishna16.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.silive.techtrishna16.R;

/**
 * Created by H.P on 1/17/2016.
 */
public class Splash extends AppCompatActivity {

    public int screen_timeout = 3000;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        context=this;
        ConnectivityManager check = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = check.getActiveNetworkInfo();
        if (info==null) {
            Toast.makeText(context, "Please check your network connection", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        }, screen_timeout);


    }




    }

