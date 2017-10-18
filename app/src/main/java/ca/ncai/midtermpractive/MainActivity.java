package ca.ncai.midtermpractive;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerSource,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerCool = (Spinner)findViewById(R.id.spinner);
        spinnerCool.setAdapter(adapter);

        spinnerCool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item " + Integer.toString(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.action_settings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    public void startFragramentActivity(View v)
    {
        Intent intent = new Intent(this, FragmentActivity1.class);
        startActivity(intent);
    }

    public void startRandNumActivity(View v)
    {
        Intent intent = new Intent(this, RandomNumberActivity.class);
        startActivity(intent);
    }
}
