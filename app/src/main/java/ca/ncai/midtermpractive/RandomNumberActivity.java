package ca.ncai.midtermpractive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class RandomNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
    }


    public void randomNumber( int userNumber)
    {
        int iArray[] = new int[1000];


        Random r = new Random();

        for(int i = 0; i< 1000; i++)
        {
            iArray[i] = r.nextInt(1000)+1;
        }

        int count = 0;

        for(int i = 0; i< 1000; i++)
        {
            if(iArray[i] == userNumber)
                count++;
        }

        int percentage = count / 1000;

        double mean=0 , sum = 0;

        for(int i = 0; i< 1000; i++)
        {
            sum += iArray[i];
        }
        mean = sum / (1.0 * iArray.length);


    }


    public float cToF(float c)
    {
        return 9*c/5 + 32;
    }

    public float fToC(float f)
    {
        return ((f - 32)*5)/9;
    }

    public float kToC(float k)
    {
        return k + (float)273.15;
    }

    public float cToK(float c)
    {
        return c-(float) 273.15;
    }

    public double pToK(double p)
    {
        return p * 0.453592;
    }

    public double kToP(double k)
    {
        return k / 0.453592;
    }
}
