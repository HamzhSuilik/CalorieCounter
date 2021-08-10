package t5sis.slimming;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class food_view extends AppCompatActivity {
    private int chose;
    private String share_txt;

    AdView mAdView;
    private int choose;

    private InterstitialAd mInterstitialAd;
    private int ads;

    private WebView web;

    private Handler handler = new Handler();
    private Timer timer = new Timer();
    LinearLayout load;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);

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


        // إعلان بيني
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // InterstitialAd

        String [] item = getResources().getStringArray(R.array.food_view_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(item[chose]);
        if (ads==0)
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                Intent intent = new Intent(getApplicationContext(), article.class);
                startActivity(intent);
                finish();

            }});
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




        // banar ad
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        if(choose==0)
            mAdView = findViewById(R.id.adView3_0);

        if(choose==1)
            mAdView = findViewById(R.id.adView3_1);


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


        String web1="https://www.t5sis.com/search/label/%D8%B1%D8%AC%D9%8A%D9%85%20%D9%88%D8%AF%D8%A7%D9%8A%D8%AA%20%D9%88%D8%A3%D9%86%D8%B8%D9%85%D8%A9%20%D8%BA%D8%B0%D8%A7%D8%A6%D9%8A%D8%A9";
        String web2="https://www.t5sis.com/search/label/%D8%AA%D9%85%D8%A7%D8%B1%D9%8A%D9%86%20%D8%B1%D9%8A%D8%A7%D8%B6%D9%8A%D8%A9";
        String web3="https://www.t5sis.com/search/label/%D8%A7%D9%84%D8%B9%D9%86%D8%A7%D9%8A%D8%A9%20%D8%A8%D8%A7%D9%84%D8%A8%D8%B4%D8%B1%D8%A9";
        String web4="https://www.t5sis.com/search/label/%D8%A7%D9%84%D8%B9%D9%86%D8%A7%D9%8A%D8%A9%20%D8%A8%D8%A7%D9%84%D8%B4%D8%B9%D8%B1";
        String web5="https://www.t5sis.com/search/label/%D9%85%D8%B7%D8%A8%D8%AE%20%D8%AA%D8%AE%D8%B3%D9%8A%D8%B3";


        // receve sms

        Bundle paste = getIntent().getExtras();
        chose = paste.getInt("sms");

        web=findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());

        if(chose==1)
            web.loadUrl(web1);

        if(chose==2)
            web.loadUrl(web2);

        if(chose==3)
            web.loadUrl(web3);

        if(chose==4)
            web.loadUrl(web4);

        if(chose==5)
            web.loadUrl(web5);


        load=findViewById(R.id.wait);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        load.setVisibility(View.INVISIBLE);
                        timer.cancel();


                    }
                });
            }
        }, 4000, 10);







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

        if (web.canGoBack()) {
            web.goBack();
        } else {
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

                                Intent intent = new Intent(getApplicationContext(), article.class);
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

}
