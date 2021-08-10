package t5sis.slimming;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;

public class test extends AppCompatActivity {

    AdView mAdView;
    private int choose;

    private int ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // ####################################
        // Remove ad
        // ###################################
        SharedPreferences gg2 = getSharedPreferences("file1", Context.MODE_PRIVATE);
        ads=gg2.getInt("ads",0);
        // ######################################

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        choose=gg.getInt("ad_id",1);
        // ###############################

        // banar ad
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(choose==0)
            mAdView = findViewById(R.id.adView7_0);

        if(choose==1)
            mAdView = findViewById(R.id.adView7_1);


        AdRequest adRequest = new AdRequest.Builder().build();
        if (ads==0)
            mAdView.loadAd(adRequest);
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // *********************************

        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    }

    public void goo1(View view) {
        Intent go = new Intent(this,test1.class);
        startActivity(go);
        finish();

    }

    public void goo2(View view) {
        Intent go = new Intent(this,test2.class);
        go.putExtra("sms",1);
        startActivity(go);
        finish();

    }

    public void goo3(View view) {
        Intent go = new Intent(this,test2.class);
        go.putExtra("sms",2);
        startActivity(go);
        finish();

    }

    public void goo4(View view) {
        Intent go = new Intent(this,test2.class);
        go.putExtra("sms",3);
        startActivity(go);
        finish();

    }

    public void goo5(View view) {
        Intent go = new Intent(this,test3.class);

        startActivity(go);
        finish();

    }

    public void goo6(View view) {
        Intent go = new Intent(this,test4.class);

        startActivity(go);
        finish();

    }

    public void goo7(View view) {
        Intent go = new Intent(this,test5.class);
        startActivity(go);
        finish();

    }


    public void goo99(View view) {
        Intent go = new Intent(this,test2.class);
        go.putExtra("sms",4);
        startActivity(go);
        finish();
    }

    public void goo999(View view) {
        Intent go = new Intent(this,test6.class);
        startActivity(go);
        finish();
    }


    public void cal(View view) {
        Intent go = new Intent(this,test.class);
        startActivity(go);
        finish();
    }

    public void snf(View view) {
        Intent go = new Intent(this,main_menu.class);
        startActivity(go);
        finish();
    }

    public void art(View view) {
        Intent go = new Intent(this,article.class);
        startActivity(go);
        finish();
    }

    public void vid (View view) {
        Intent go = new Intent(this,vidio.class);
        startActivity(go);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder sms = new AlertDialog.Builder(this);
        sms.setMessage("هل تريد العودة إلى صفحة البداية ؟")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), start.class);
                        startActivity(intent);
                        finish();
                    }
                })

                .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

}
