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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.text.NumberFormat;
import java.util.Locale;

public class show extends AppCompatActivity {





    private int chose;
    private int snf;

    private int amount;

    private int img;
    private String name;
    private String unit;

    private double carb;
    private double fat;
    private double protein;
    private double calory;

    private TextView name_txt;
    private TextView unit_txt;
    private ImageView main_img;
    private EditText edtxt;




    String name1[]={"بطيخ","عنب","مشمش","موز","برتقال","تفاح","تمر","خوخ","فراولة",
            "كرز","تين","جوافة","كيوي","ليمون","ماجو"};
    int img1[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6
            ,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12
            ,R.drawable.a13,R.drawable.a14,R.drawable.a15};

    String name2[]={"بصل","بطاطة حلوة","خس","طماطم","باذنجان","بازيلاء","بروكلي","خيار","ملفوف","شمندر","عدس","فاصولياء","فجل","فلفل حار","كاتشب","مسحوق الطماطم"};
    int img2[]={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7
            ,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13,R.drawable.b14
            ,R.drawable.b15,R.drawable.b16};


    String name3[]={"أضلاع الخروف","فخذ خروف","كتف العجل","أضلاع العجل","لحم عجل مفروم","صدر البقر","صدر الدجاج","كبد الدجاج","فخذ الدجاج","كتف خروف","ساق الخروف"};
    int img3[]={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6
            ,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11};


    String name4[]={"الهال","زنجبيل مطحون","فلفل حار","قرفة","خل التفاح","زعتر","ملح","نعنع مجفف","زعفران","بقدونس مجفف","الأرز","برغل"};
    int img4[]={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7
            ,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11,R.drawable.d12};

    String name5[]={"بيض","صفار البيض","الجبنة السويسرية","اللبن الرائب","الزبادي","العجه","قشطة","بياض البيض","جبنة الشيدر","جبنة الفيتا","جبنة الموزرلا"};
    int img5[]={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,R.drawable.e6
            ,R.drawable.e7,R.drawable.e8,R.drawable.e9,R.drawable.e10,R.drawable.e11};

    String name6[]={"حليب بودرة","شاي","شراب البرتقال","عصير الفاكهة","قهوة","شراب الليمون","كولا"};
    int img6[]={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6,R.drawable.f7};



    String unit1[]={"غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام"};
    double carb1[]={0.0755,0.145,0.111,0.228,0.1175,0.138,0.75,0.0954,0.0768,0.1601,0.192,0.143,0.1466,0.0932,0.17};
    double fat1[]={0.0015,0.0033,0.0039,0.0033,0.0012,0.0017,0.0015,0.025,0.003,0.002,0.003,0.0095,0.0052,0.003,0.0027};
    double protein1 []={0.0061,0.0074,0.014,0.0109,0.0094,0.0026,0.0181,0.0091,0.0067,0.0106,0.0075,0.0255,0.0114,0.011,0.0051
    };
    double calory1[]={0.3,0.57,0.48,0.89,0.47,0.52,2.77,0.39,0.32,0.63,0.74,0.68,0.61,0.29,0.65};


    String unit2[]={"غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","حبة متوسطة","غرام","ملعقة كبيرة","غرام"};
    double carb2[]={0.0934,0.234,0.2,0.0392,0.0873,0.143,0.0478,0.01,2.41,0.1628,0.2214,0.3088,1.13,3.96,3.77,0.7468};
    double fat2[]={0.001,0.0012,2,0.002,0.0023,0.0027,0.0029,0.002,0.17,0.0008,0.0055,0.0048,0,0.2,0.05,0.0044};
    double protein2 []={0.011,0.0171,0.07,0.0088,0.0083,0.0515,0.281,0.007,1.5,0.008,0.0896,0.0931,0.03,0.48,0.26,0.1291};
    double calory2[]={0.4,1,1.02,0.18,0.35,0.78,0.26,0.15,14,0.65,1.06,1.62,0.72,18,14.55,3.02};


    String unit3[]={"غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام"};
    double carb3[]={0,0,0,0,0,0,0.0899,0.0073,0,0,0};
    double fat3[]={0.2959,0.1442,0.061,0.0744,0.0677,0.0699,0.132,0.0483,0.0566,0.1894,0.0329};
    double protein3 []={0.2213,0.262,0.3368,0.2576,0.1935,0.3326,0.2484,0.1692,0.2829,0.1719,0.2108};
    double calory3[]={3.61,2.42,1.99,1.77,1.44,2.05,2.6,1.119,1.72,2.44,1.2};


    String unit4[]={"غرام","غرام","غرام","غرام","ملعقة كبيرة","غرام","غرام","غرام","غرام","غرام","غرام","غرام"};
    double carb4[]={0.6847,0.7,0.5466,0.8059,0.14,0.2445,0,0.5204,0.6337,0.0548,0.445,0.663};
    double fat4[]={0.067,0.0595,0.1676,0.0124,0,0.0186,0,0.0603,0.0585,0.0548,0.0044,0.069};
    double protein4 []={0.1076,0.0912,0.1226,0.0399,0,0.0556,0,0.1993,0.1143,0.263,0.0425,0.1689};
    double calory4[]={3.11,3.47,3.14,2.47,3.13,1.01,0,2.85,3.01,2.92,2.05,3.89};


    String unit5[]={"حبة وسط","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام","غرام"};
    double carb5[]={0.34,0.108,0.0538,0.479,0.138,0.0069,0.0813,1.05,0.0128,0.0409,0.0247};
    double fat5[]={4.37,0.2275,0.278,0.0088,0.0125,0.1203,0.1528,0,0.3314,0.2128,0.2464};
    double protein5 []={5.53,0.138,0.2693,0.0334,0.0493,0.1057,0.0785,0.098,0.249,0.1421,0.216};
    double calory5[]={62.92,3.07,3.8,0.4,0.85,1.57,2.01,0.047,4.03,2.64,3.18};

    String unit6[]={"غرام","غرام","غرام","غرام","غرام","غرام","غرام"};
    double carb6[]={0.1067,0.0977,0.1132,0.91,0.411,0.1042,0.1058};
    double fat6[]={0.0321,0,0,0.0016,0.005,0.0004,0};
    double protein6 []={0.0367,0,0.0012,0.0025,0.122,0.0007,0};
    double calory6[]={0.86,0.39,0.45,2.27,2.41,0.4,0.41};

    // ads name
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private InterstitialAd mInterstitialAd;
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    AdView mAdView;
    private int choose;
    private int go;
    private int ads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

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

        String [] item = getResources().getStringArray(R.array.show_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(item[chose]);
        if (ads==0)
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

               close_ad();

            }});
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




        // *********************************

        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@





        Bundle paste = getIntent().getExtras();
        chose = paste.getInt("chose");
        snf=paste.getInt("snf");



        if(chose<7) {

            if (chose == 1) {
                img = img1[snf];
                name = name1[snf];
                unit = unit1[snf];

                carb = carb1[snf];
                fat = fat1[snf];
                protein = protein1[snf];
                calory = calory1[snf];
            }

            if (chose == 2) {
                img = img2[snf];
                name = name2[snf];
                unit = unit2[snf];

                carb = carb2[snf];
                fat = fat2[snf];
                protein = protein2[snf];
                calory = calory2[snf];
            }
            if (chose == 3) {
                img = img3[snf];
                name = name3[snf];
                unit = unit3[snf];

                carb = carb3[snf];
                fat = fat3[snf];
                protein = protein3[snf];
                calory = calory3[snf];
            }
            if (chose == 4) {
                img = img4[snf];
                name = name4[snf];
                unit = unit4[snf];

                carb = carb4[snf];
                fat = fat4[snf];
                protein = protein4[snf];
                calory = calory4[snf];
            }
            if (chose == 5) {
                img = img5[snf];
                name = name5[snf];
                unit = unit5[snf];

                carb = carb5[snf];
                fat = fat5[snf];
                protein = protein5[snf];
                calory = calory5[snf];
            }
            if (chose == 6) {
                img = img6[snf];
                name = name6[snf];
                unit = unit6[snf];

                carb = carb6[snf];
                fat = fat6[snf];
                protein = protein6[snf];
                calory = calory6[snf];
            }

        }


        if(chose==7){


            img=R.drawable.sql_img;
            name=paste.getString("d1");
            unit=paste.getString("d2");

/*
            carb=Double.valueOf(paste.getString("d3"));
            fat=Double.valueOf(paste.getString("d4"));
            protein=Double.valueOf(paste.getString("d5"));
            calory=Double.valueOf(paste.getString("d6"));
            */

            calory=Double.valueOf(paste.getString("d3"));
            fat=Double.valueOf(paste.getString("d4"));
            carb=Double.valueOf(paste.getString("d5"));
            protein=Double.valueOf(paste.getString("d6"));



        }


        // img and text
        //************************************

        main_img=findViewById(R.id.img);
        name_txt=findViewById(R.id.name);
        unit_txt=findViewById(R.id.unit);


        main_img.setImageResource(img);
        name_txt.setText(name);
        unit_txt.setText(unit);

        //*********************************




    }

    public void goo(View view) {

        edtxt= findViewById(R.id.editText);


         if((edtxt.getText()+"")==""){
            Toast.makeText(show.this, "يجب أن تدخل الكمية المطلوبة", Toast.LENGTH_SHORT).show();
        }
        else
        {

            amount=Integer.valueOf(edtxt.getText().toString());

            Locale locale = Locale.ENGLISH;
            NumberFormat nf = NumberFormat.getNumberInstance(locale);

            //nf.setMinimumFractionDigits(2);
            // round to 2 digits:
            nf.setMaximumFractionDigits(2);


            TextView txt;
            txt = findViewById(R.id.calory);
            txt.setText(String.valueOf(nf.format(amount * calory)));

            txt = findViewById(R.id.fat);
            txt.setText(String.valueOf(nf.format(amount * fat)));

            txt = findViewById(R.id.protein);
            txt.setText(String.valueOf(nf.format(amount * protein)));

            txt = findViewById(R.id.carb);
            txt.setText(String.valueOf(nf.format(amount * carb)));
        }

    }

    public void cal(View view) {

        go=1;

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {

            Intent go = new Intent(this, test.class);
            startActivity(go);
            finish();
        }
    }

    public void snf(View view) {

        go=2;

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {
            Intent go = new Intent(this, main_menu.class);
            startActivity(go);
            finish();
        }
    }

    public void art(View view) {

        go=3;

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }else {
            Intent go = new Intent(this, article.class);
            startActivity(go);
            finish();
        }
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
        sms.setMessage("هل تريد العودة إلى القائمة الرئيسية")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        go=4;

                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }else {

                            Intent intent = new Intent(getApplicationContext(), main_menu.class);
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


    public void close_ad(){

        if (go==1) {
            Intent intent = new Intent(getApplicationContext(), test.class);
            startActivity(intent);
            finish();
        }

        if (go==2) {
            Intent intent = new Intent(getApplicationContext(), main_menu.class);
            startActivity(intent);
            finish();
        }


        if (go==3) {
            Intent intent = new Intent(getApplicationContext(), article.class);
            startActivity(intent);
            finish();
        }

        if (go==4) {
            Intent intent = new Intent(getApplicationContext(), main_menu.class);
            startActivity(intent);
            finish();
        }



    }



}
