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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.text.NumberFormat;
import java.util.Locale;

public class test2 extends AppCompatActivity {

    private int chose;
    private TextView titel;
    private TextView show;

    private EditText tall ;
    private EditText weght ;
    private EditText age ;

    private RadioButton a1 ;
    private RadioButton a2 ;


    private RadioButton b1 ;
    private RadioButton b2 ;

    private RadioButton c1 ;
    private RadioButton c2 ;
    private RadioButton c3 ;


    private  int talln;
    private  int weghtn;
    private int agen;

    private double sum ;

    // ads name
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private InterstitialAd mInterstitialAd;
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    private int ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        // ####################################
        // Remove ad
        // ###################################
        SharedPreferences gg2 = getSharedPreferences("file1", Context.MODE_PRIVATE);
        ads=gg2.getInt("ads",0);
        // ######################################

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        chose=gg.getInt("ad_id",1);
        // ###############################


        // إعلان بيني
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // InterstitialAd

        String [] item = getResources().getStringArray(R.array.test2_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(item[chose]);
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

        // text
        titel=findViewById(R.id.title);
        show=findViewById(R.id.show);
        tall=findViewById(R.id.tall);
        weght=findViewById(R.id.weight);
        age=findViewById(R.id.age);

        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);

        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);

        // reseve data

        Bundle paste = getIntent().getExtras();
        chose = paste.getInt("sms");

        // *********************************

        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // Titel ************

        if (chose==1)
            titel.setText("حاجة الجسم اليومية من السعرات الحرارية");

        if (chose==2)
            titel.setText("حاجة الجسم اليومية من البروتينات");

        if (chose==3)
            titel.setText("حاجة الجسم اليومية من الكاربوهيدرات");

        if (chose==4)
            titel.setText("حاجة الجسم اليومية من الدهون");


    }

    public void goo(View view) {

        int i=0;

        if((tall.getText()+"")==""||(weght.getText()+"")==""||(age.getText()+"")==""){
            i=81;
        }

        if (a1.isChecked()==true||a2.isChecked()==true){
           i++;
        }

        if (b1.isChecked()==true||b2.isChecked()==true){
            i++;
        }

        if (c1.isChecked()==true||c2.isChecked()==true||c3.isChecked()==true){
            i++;
        }


        if (i!=3){
            Toast.makeText(this, "عليك ملئ جميع الخانات أولاً", Toast.LENGTH_SHORT).show();
        }else {

            talln=Integer.valueOf( tall.getText().toString() );
            weghtn=Integer.valueOf( weght.getText().toString() );
            agen=Integer.valueOf( age.getText().toString() );

            if (chose == 1)
                calory();

            if (chose == 2)
                proten();

            if (chose == 3)
                carb();

            if (chose == 4)
                fat();

        }
    }

    public void calory (){

        if (a2.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.5+499;
            }

            if (agen>9 && agen<18){
                sum=weghtn*12.2+746;
            }

            if (agen>17 && agen<30){
                sum=weghtn*14.7+496;
            }

            if (agen>29 && agen<61){
                sum=weghtn*8.7+829;
            }

            if (agen>61){
                sum=10.5*weghtn+596;
            }

        }

        if (a1.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.7+495;
            }

            if (agen>9 && agen<18){
                sum=weghtn*17.5+651;
            }

            if (agen>17 && agen<30){
                sum=weghtn*15.3+679;
            }

            if (agen>29 && agen<61){
                sum=weghtn*11.6+879;
            }

            if (agen>61){
                sum=13.5*weghtn+487;
            }

        }

        if (c1.isChecked()==true)
            sum*=1.2;
        if (c2.isChecked()==true)
            sum*=1.3;
        if (c3.isChecked()==true)
            sum*=1.4;

        if (b2.isChecked()==true)
            sum-=500;

        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        // round to 2 digits:
        nf.setMaximumFractionDigits(0);

        show.setText("النتيجة : "+nf.format(sum)+"  سعرة حرارية");

    }

    public void proten (){
        if (a2.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.5+499;
            }

            if (agen>9 && agen<18){
                sum=weghtn*12.2+746;
            }

            if (agen>17 && agen<30){
                sum=weghtn*14.7+496;
            }

            if (agen>29 && agen<61){
                sum=weghtn*8.7+829;
            }

            if (agen>61){
                sum=10.5*weghtn+596;
            }

        }

        if (a1.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.7+495;
            }

            if (agen>9 && agen<18){
                sum=weghtn*17.5+651;
            }

            if (agen>17 && agen<30){
                sum=weghtn*15.3+679;
            }

            if (agen>29 && agen<61){
                sum=weghtn*11.6+879;
            }

            if (agen>61){
                sum=13.5*weghtn+487;
            }

        }

        if (c1.isChecked()==true)
            sum*=1.2;
        if (c2.isChecked()==true)
            sum*=1.3;
        if (c3.isChecked()==true)
            sum*=1.4;

        if (b2.isChecked()==true)
            sum-=500;

        sum*=0.0875;

        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        // round to 2 digits:
        nf.setMaximumFractionDigits(1);

        show.setText("النتيجة : "+nf.format(sum)+" غرام");
    }

    public void carb (){
        if (a2.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.5+499;
            }

            if (agen>9 && agen<18){
                sum=weghtn*12.2+746;
            }

            if (agen>17 && agen<30){
                sum=weghtn*14.7+496;
            }

            if (agen>29 && agen<61){
                sum=weghtn*8.7+829;
            }

            if (agen>61){
                sum=10.5*weghtn+596;
            }

        }

        if (a1.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.7+495;
            }

            if (agen>9 && agen<18){
                sum=weghtn*17.5+651;
            }

            if (agen>17 && agen<30){
                sum=weghtn*15.3+679;
            }

            if (agen>29 && agen<61){
                sum=weghtn*11.6+879;
            }

            if (agen>61){
                sum=13.5*weghtn+487;
            }

        }

        if (c1.isChecked()==true)
            sum*=1.2;
        if (c2.isChecked()==true)
            sum*=1.3;
        if (c3.isChecked()==true)
            sum*=1.4;

        if (b2.isChecked()==true)
            sum-=500;

        sum*=0.125;

        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        // round to 2 digits:
        nf.setMaximumFractionDigits(1);

        show.setText("النتيجة : "+nf.format(sum)+" غرام");
    }

    public void fat(){

        if (a2.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.5+499;
            }

            if (agen>9 && agen<18){
                sum=weghtn*12.2+746;
            }

            if (agen>17 && agen<30){
                sum=weghtn*14.7+496;
            }

            if (agen>29 && agen<61){
                sum=weghtn*8.7+829;
            }

            if (agen>61){
                sum=10.5*weghtn+596;
            }

        }

        if (a1.isChecked()==true){

            if (agen<10){
                sum=weghtn*22.7+495;
            }

            if (agen>9 && agen<18){
                sum=weghtn*17.5+651;
            }

            if (agen>17 && agen<30){
                sum=weghtn*15.3+679;
            }

            if (agen>29 && agen<61){
                sum=weghtn*11.6+879;
            }

            if (agen>61){
                sum=13.5*weghtn+487;
            }

        }

        if (c1.isChecked()==true)
            sum*=1.2;
        if (c2.isChecked()==true)
            sum*=1.3;
        if (c3.isChecked()==true)
            sum*=1.4;

        if (b2.isChecked()==true)
            sum-=500;

        sum*=0.01667;


        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        // round to 2 digits:
        nf.setMaximumFractionDigits(1);

        show.setText("النتيجة : "+nf.format(sum)+" غرام");
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
