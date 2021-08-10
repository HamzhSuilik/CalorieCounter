package t5sis.slimming;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;


public class vidio extends AppCompatActivity {

    AdView mAdView;
    private int choose;

    private int ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidio);

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
            mAdView = findViewById(R.id.adView0);

        if(choose==1)
            mAdView = findViewById(R.id.adView1);


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

    public void go1 (View view) {
        yu("https://www.youtube.com/watch?v=kWOnH8CfzFc");
    }
    public void go2 (View view) {
        yu("https://www.youtube.com/watch?v=g3fuoHg9cZk");
    }
    public void go3 (View view) {
        yu("https://www.youtube.com/watch?v=e6TuEC2yzv4");
    }
    public void go4 (View view) {
        yu("https://www.youtube.com/watch?v=C9A2VKgvmKc");
    }
    public void go5 (View view) {
        yu("https://www.youtube.com/watch?v=-yLbaVmqNa0");
    }
    public void go6 (View view) {
        yu("https://www.youtube.com/watch?v=LHNbyrnC6qw");
    }
    public void go7 (View view) {
        yu("https://www.youtube.com/watch?v=XSpd43kOEdw");
    }
    public void go8 (View view) {
        yu("https://www.youtube.com/watch?v=SxYCN5TmROQ");
    }
    public void go9 (View view) {
        yu("https://www.youtube.com/watch?v=1q_9RPP_mtE");
    }

    public void play(int i){
        /*
        Intent go = new Intent(this,play.class);
        go.putExtra("sms",i);
        startActivity(go);
        finish();
        */
    }

    public void yu(String url){
        Intent star5 =new Intent(Intent.ACTION_VIEW);
        star5.setData(Uri.parse(url));
        startActivity(star5);
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
