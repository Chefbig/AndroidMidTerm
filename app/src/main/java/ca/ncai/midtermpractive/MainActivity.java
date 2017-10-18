package ca.ncai.midtermpractive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private final int STANDARD_REQUEST_CODE = 0;

    public static final String EXTRA_MESSAGE = "ca.ncai.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Nico", "Create");

        // set up shareedPreferences
        // Cause exception without any notices ...
        sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

        Button bt = (Button) findViewById(R.id.startActivity3);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(intent, STANDARD_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            TextView tv = (TextView) findViewById(R.id.showText);
            String stringResult = data.getStringExtra("passThrough");
            tv.setText(stringResult);
            Toast.makeText(this, "Result: " + stringResult, Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(this, "Result_Cancelled", Toast.LENGTH_SHORT).show();
        }
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
    public void startActivity2(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        EditText editText = (EditText) findViewById(R.id.editText);

        String text = editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, text);
        startActivity(intent);
    }


    public void readPreference(View v) {
        String s = "abce";
        String name = sharedPreferences.getString("name", "No name");
        TextView tv = (TextView) findViewById(R.id.showText);
        tv.setText(name);

        Toast.makeText(this, "readPreference: " + name, Toast.LENGTH_SHORT).show();
    }

    //set up shareedPreferences when activity onCreate
    //sharedPreferences = getSharedPreferences("userInfo", MODE_PRIVATE);

    public void savePreference(View v) {
        EditText et = (EditText) findViewById(R.id.editText);
        String name = et.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", name);
        editor.apply();

        Toast.makeText(this, "readPreference: " + name, Toast.LENGTH_SHORT).show();

    }

    public void showDialog(View v)
    {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}
