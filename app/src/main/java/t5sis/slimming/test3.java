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

public class test3 extends AppCompatActivity {

    AdView mAdView;
    private int choose;

    EditText weght;
    double sum ;
    TextView show1;
    TextView show2;

    // ads name
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private InterstitialAd mInterstitialAd;
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private int ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

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
            mAdView = findViewById(R.id.adView9_0);

        if(choose==1)
            mAdView = findViewById(R.id.adView9_1);


        AdRequest adRequest = new AdRequest.Builder().build();
        if (ads==0)
            mAdView.loadAd(adRequest);
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // إعلان بيني
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // InterstitialAd

        String [] item = getResources().getStringArray(R.array.test3_ad);

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


        weght=findViewById(R.id.weight);
        show1=findViewById(R.id.show1);
        show2=findViewById(R.id.show2);

        // *********************************

        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    }

    public void goo(View view) {

        if ((weght.getText()+"")==""){
            Toast.makeText(this, "عليك إدخال الوزن أولاً", Toast.LENGTH_SHORT).show();
        }else {
           sum =Double.valueOf(weght.getText().toString());
            sum *=0.03;

            Locale locale = Locale.ENGLISH;
            NumberFormat nf = NumberFormat.getNumberInstance(locale);

            // round to 2 digits:
            nf.setMaximumFractionDigits(1);

            show1.setText("النتيجة : "+nf.format(sum)+" لتر");

            sum*=4;

            show2.setText("النتيجة : "+nf.format(sum)+" أكواب");

        }
    }

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
