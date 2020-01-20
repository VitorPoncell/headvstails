package com.poturno.headvstails;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coin = findViewById(R.id.tv_coin);

        Uri uri = getReferrer();

        if (uri == null) {
            SharedPref.saveReferrer(this, SharedPref.MAIN_ACTIVITY_KEY, "no referrer");
        } else {
            SharedPref.saveReferrer(this, SharedPref.MAIN_ACTIVITY_KEY,
                    uri.getSchemeSpecificPart());
        }

    }

    public void onClick(View view) {
        toss();
    }

    private void toss() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids)
            {
                SystemClock.sleep(500);
                return null;
            }

            @Override
            protected void onPreExecute() {
                coin.setText("");
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                int result = (int) Math.floor(Math.random()*2);
                switch (result) {
                    case 0:
                        coin.setText(R.string.tail);
                        break;
                    case 1:
                        coin.setText(R.string.head);
                        break;
                }
            }
        }.execute();
    }
}
