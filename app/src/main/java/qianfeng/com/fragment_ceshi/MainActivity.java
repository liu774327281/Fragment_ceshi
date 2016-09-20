package qianfeng.com.fragment_ceshi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity{
    private Fragment[] mFragments;
    private RadioGroup bottomRg;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbOne, rbTwo, rbThree;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments = new Fragment[3];
        fragmentManager =getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.chat_fragment);
        mFragments[1] = fragmentManager.findFragmentById(R.id.find_fragment);
        mFragments[2] = fragmentManager
                .findFragmentById(R.id.mine_fragment);
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();
        setFragmentIndicator() ;
    }

    private void setFragmentIndicator() {

        this.bottomRg = (RadioGroup) findViewById(R.id.bottomRg);
        this.rbOne = (RadioButton) findViewById(R.id.rbOne);
        this.rbTwo = (RadioButton) findViewById(R.id.rbTwo);
        this.rbThree = (RadioButton) findViewById(R.id.rbThree);

        bottomRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                fragmentTransaction = fragmentManager.beginTransaction()
                        .hide(mFragments[0]).hide(mFragments[1])
                        .hide(mFragments[2]);
                switch (checkedId) {
                    case R.id.rbOne:
                        fragmentTransaction.show(mFragments[0]).commit();
                        break;

                    case R.id.rbTwo:
                        fragmentTransaction.show(mFragments[1]).commit();
                        break;

                    case R.id.rbThree:
                        fragmentTransaction.show(mFragments[2]).commit();
                        break;

                    default:
                        break;
                }
            }
        });

    }
}



