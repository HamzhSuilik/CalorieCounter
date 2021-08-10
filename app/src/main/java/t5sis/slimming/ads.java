package t5sis.slimming;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Calendar;
import java.util.Locale;

import static t5sis.slimming.R.color.*;


public class ads extends AppCompatActivity implements RewardedVideoAdListener {

    AdView mAdView;

    private RewardedVideoAd mRewardedVideoAd;
    private TextView txt;
    private TextView show;
    private int check;
    private LinearLayout wait;
    private LinearLayout back;
    private Button bt;
    private boolean gole;
    private int fail;

    private String vidio_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        int nn=gg.getInt("ad_id",1);

        String [] item = getResources().getStringArray(R.array.vidio_id);
        vidio_id=item[nn];
        // **********************************************

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        ///***************************************************

        txt=findViewById(R.id.txt);
        show=findViewById(R.id.txt2);
        wait=findViewById(R.id.wait);
        back=findViewById(R.id.back_layout);
        bt=findViewById(R.id.bt);
        check=0;
        gole=false;
        fail=0;


        /*
        *********************************
         */





       MobileAds.initialize(this, vidio_id);

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);


        // uploud ad
        // $$$$$$$$$$$$$$$$$$$$$$$
        mRewardedVideoAd.loadAd(vidio_id, new AdRequest.Builder().build());
        // @@@@@@@@@@@@@@@@@@@@@@@@


    }


    @Override
    public void onRewardedVideoAdLoaded() {

        if (check==1) {
            wait.setVisibility(View.VISIBLE);
            mRewardedVideoAd.show();
        }else {
            check=9;
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {
        // When user open the ad
    }

    @Override
    public void onRewardedVideoStarted() {
        //When the video starts playing
    }

    @Override
    public void onRewardedVideoAdClosed() {
        // When the ad is closed
        mRewardedVideoAd.loadAd(vidio_id, new AdRequest.Builder().build());
        // @@@@@@@@@@@@@@@@@@@@@@@@
        check=0;
        wait.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        // Reward given to the user
        ok();
        show.setText("لقد تم إزالة جميع الإعلانات من التطبيق لمدة يوم ");
        gole=true;
        bt.setVisibility(View.INVISIBLE);

        back.setVisibility(View.VISIBLE);

        wait.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        // When the user clicks the link and goes to the App Store
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        // Failed to connect or upload ad

        if (fail==12){
            Toast.makeText(this, "تحقق من الإتصال بالإنترنت", Toast.LENGTH_SHORT).show();
            fail=11;
            wait.setVisibility(View.INVISIBLE);
        }else {

            fail = 10;
            wait.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @SuppressLint("ResourceAsColor")
    public void goo(View view) {


        if(fail==11){
            mRewardedVideoAd.loadAd(vidio_id, new AdRequest.Builder().build());
            // @@@@@@@@@@@@@@@@@@@@@@@@
            check=1;
            fail=12;
            wait.setVisibility(View.VISIBLE);

        }

        if(fail==10) {
            show.setText("فشل تحميل الفيديو"
                    + "\n" +
                    "تحقق من الإتصال بالإنترنت"
            );

            show.setTextColor(R.color.f1);
            Toast.makeText(this, "تحقق من الإتصال بالإنترنت", Toast.LENGTH_SHORT).show();
            fail = 11;
        }

        if (fail==0){
            if (check == 9) {
                mRewardedVideoAd.show();
            } else {
                wait.setVisibility(View.VISIBLE);
                check = 1;
            }
        }







    }

        public void back(View view) {
            Intent go = new Intent(this,start.class);
            startActivity(go);
            finish();
        }

        public void ok () {

            Calendar c = Calendar.getInstance();

            SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
            SharedPreferences.Editor copy = gg.edit();

            copy.putInt("ads", 1);

            copy.putInt("month", c.get(Calendar.MONTH));
            copy.putInt("day", c.get(Calendar.DAY_OF_MONTH));
            copy.putInt("hour", c.get(Calendar.HOUR_OF_DAY));

            copy.apply();


        }


        @Override
        public void onBackPressed() {
            //super.onBackPressed();

            if (gole==false) {
                AlertDialog.Builder sms = new AlertDialog.Builder(this);
                sms.setMessage("هل تريد العودة إلى القائمة الرئيسية")
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
            else {
                Intent intent = new Intent(getApplicationContext(), start.class);
                startActivity(intent);
                finish();
            }
        }

    }
