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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.text.NumberFormat;
import java.util.Locale;

public class test1 extends AppCompatActivity {

    AdView mAdView;
    private int choose;


    // ads name
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private InterstitialAd mInterstitialAd;
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        // ####################################
        // Remove ad
        // ###################################
        SharedPreferences gg2 = getSharedPreferences("file1", Context.MODE_PRIVATE);
        ads=gg2.getInt("ads",0);
        // ######################################


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        choose=gg.getInt("ad_id",0);
        // ###############################

        // banar ad
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(choose==0)
            mAdView = findViewById(R.id.adView8_0);

        if(choose==1)
            mAdView = findViewById(R.id.adView8_1);


        AdRequest adRequest = new AdRequest.Builder().build();
        if (ads==0)
            mAdView.loadAd(adRequest);




        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


        // إعلان بيني
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // InterstitialAd

        String [] item = getResources().getStringArray(R.array.test1_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(item[choose]);
        if (ads==0)
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                Intent intent = new Intent(getApplicationContext(), test.class);
                startActivity(intent);
                finish();

            }});
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // **********************************************

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        ///***************************************************



    }

    public void goo(View view) {
        EditText tall =findViewById(R.id.tall);
        EditText weight = findViewById(R.id.weight);
        TextView show=findViewById(R.id.show);



        if((tall.getText()+"")==""||(weight.getText()+"")==""){
            Toast.makeText(this, "عليك ملئ جميع الخانات أولاً", Toast.LENGTH_SHORT).show();
        }else {
            double talls= Double.valueOf(tall.getText().toString());
            double weights = Double.valueOf(weight.getText().toString());

            Locale locale = Locale.ENGLISH;
            NumberFormat nf = NumberFormat.getNumberInstance(locale);

            // round to 1 digits:
            nf.setMaximumFractionDigits(1);

            talls=(weights/(talls*talls*0.0001));

           String rate =String.valueOf(nf.format( talls));

            show.setText("مؤشر كتلة جسمك هو : "+rate);


//" مؤشر كتلة جسمك : " +rate
        }

    }

    private int ads;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder sms = new AlertDialog.Builder(this);
        sms.setMessage("هل تريد العودة إلى القائمة الرئيسية")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {

                            Intent intent = new Intent(getApplicationContext(), test.class);
                            startActivity(intent);
                            finish();
                        }
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
