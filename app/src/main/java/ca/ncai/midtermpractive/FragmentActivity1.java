package ca.ncai.midtermpractive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FragmentActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

//        PlusOneFragment plusOneFragment = new PlusOneFragment();
//        FragmentTransaction plusOneTransaction =  getSupportFragmentManager().beginTransaction();
//        plusOneTransaction.replace(R.id.headFragrament, plusOneFragment);
//        plusOneTransaction.addToBackStack(null);
//        plusOneTransaction.commit();
//
//
//
//        ItemFragment itemFragment = new ItemFragment();
//        FragmentTransaction bodyTransaction =  getSupportFragmentManager().beginTransaction();
//        bodyTransaction.replace(R.id.bodyFragraent, itemFragment);
//        bodyTransaction.addToBackStack(null);
//        bodyTransaction.commit();
    }
}
