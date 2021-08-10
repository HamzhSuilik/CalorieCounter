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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Locale;


public class main extends AppCompatActivity {


    GridView gridView;
    // chose
    private int chose;


    AdView mAdView;
    private int choose;


    String letterlist1[]={"بطيخ","عنب","مشمش","موز","برتقال","تفاح","تمر","خوخ","فراولة",
            "كرز","تين","جوافة","كيوي","ليمون","ماجو"};
    int lettericon1[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6
            ,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12
            ,R.drawable.a13,R.drawable.a14,R.drawable.a15};

    String letterlist2[]={"بصل","بطاطة حلوة","خس","طماطم","باذنجان","بازيلاء","بروكلي","خيار","ملفوف","شمندر","عدس","فاصولياء","فجل","فلفل حار","كاتشب","مسحوق الطماطم"};
    int lettericon2[]={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7
            ,R.drawable.b8,R.drawable.b9,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13,R.drawable.b14
            ,R.drawable.b15,R.drawable.b16};


    String letterlist3[]={"أضلاع الخروف","فخذ خروف","كتف العجل","أضلاع العجل","لحم عجل مفروم","صدر البقر","صدر الدجاج","كبد الدجاج","فخذ الدجاج","كتف خروف","ساق الخروف"};
    int lettericon3[]={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6
            ,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11};


    String letterlist4[]={"الهال","زنجبيل مطحون","فلفل حار","قرفة","خل التفاح","زعتر","ملح","نعنع مجفف","زعفران","بقدونس مجفف","الأرز","برغل"};
    int lettericon4[]={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6,R.drawable.d7
            ,R.drawable.d8,R.drawable.d9,R.drawable.d10,R.drawable.d11,R.drawable.d12};

    String letterlist5[]={"بيض","صفار البيض","الجبنة السويسرية","اللبن الرائب","الزبادي","العجه","قشطة","بياض البيض","جبنة الشيدر","جبنة الفيتا","جبنة الموزرلا"};
    int lettericon5[]={R.drawable.e1,R.drawable.e2,R.drawable.e3,R.drawable.e4,R.drawable.e5,R.drawable.e6
            ,R.drawable.e7,R.drawable.e8,R.drawable.e9,R.drawable.e10,R.drawable.e11};

    String letterlist6[]={"حليب بودرة","شاي","شراب البرتقال","عصير الفاكهة","قهوة","شراب الليمون","كولا"};
    int lettericon6[]={R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5,R.drawable.f6,R.drawable.f7};

    private int ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // receve sms

        Bundle paste = getIntent().getExtras();
        chose = paste.getInt("sms");


         gridView =findViewById(R.id.grid);


         if (chose==1){
         contener_view bb = new contener_view(main.this,lettericon1,letterlist1);
             gridView.setAdapter(bb);}

        if (chose==2){
            contener_view bb = new contener_view(main.this,lettericon2,letterlist2);
            gridView.setAdapter(bb);}

        if (chose==3){
            contener_view bb = new contener_view(main.this,lettericon3,letterlist3);
            gridView.setAdapter(bb);}

        if (chose==4){
            contener_view bb = new contener_view(main.this,lettericon4,letterlist4);
            gridView.setAdapter(bb);}

        if (chose==5){
            contener_view bb = new contener_view(main.this,lettericon5,letterlist5);
            gridView.setAdapter(bb);}

        if (chose==6){
            contener_view bb = new contener_view(main.this,lettericon6,letterlist6);
            gridView.setAdapter(bb);}






         // on click

         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                 Intent go = new Intent(main.this,show.class);
                 go.putExtra("snf",position);
                 go.putExtra("chose",chose);
                 startActivity(go);
                 finish();

             }
         });




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
        sms.setMessage("هل تريد العودة إلى القائمة الرئيسية")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), main_menu.class);
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
