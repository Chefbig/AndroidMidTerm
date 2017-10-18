package ca.ncai.midtermpractive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Nico", "Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Nico", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Nico", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Nico", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Nico", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Nico", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Nico", "onRestart");
    }

    // invoked by Onclick in xml 
    public void startActivity2(View v)
    {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }
}
