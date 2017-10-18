package ca.ncai.midtermpractive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();

        EditText editText = (EditText) findViewById(R.id.sendBackText);
        String sendBackString = editText.getText().toString();

        if(sendBackString == "")
        {
            setResult(RESULT_CANCELED);
        }else {
            intent.putExtra("passThrough", sendBackString);

            setResult(RESULT_OK,intent);
        }

        //this code should run at the end, otherwise the result will alwasy be Canceled
        super.onBackPressed();

    }
}
