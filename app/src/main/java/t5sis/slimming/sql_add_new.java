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
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Locale;

public class sql_add_new extends AppCompatActivity {

    AdView mAdView;
    private int choose;

    DatabaseHelper myDb;

    EditText name;
    EditText unit;

    EditText calory;
    EditText fat;
    EditText carb;
    EditText proten;


    String name_txt;
    String unit_txt;

    private int i;
    private int position;
    int PRIMARY_KEY;

    private int ads;

    // ads name
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private InterstitialAd mInterstitialAd;
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@







    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_add_new);

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



        // إعلان بيني
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // InterstitialAd

        String [] item = getResources().getStringArray(R.array.sql_add_new_ad);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(item[choose]);
        if (ads==0)
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {

                if (i == 20) {
                    update();
                } else {
                    save();
                }

            }});
        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@




        // *********************************

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@



        Bundle paste = getIntent().getExtras();
        i = paste.getInt("type");


        position=paste.getInt("position");
      //  PRIMARY_KEY=myDb.ID(position);




        Button bt=findViewById(R.id.button2);






        myDb = new DatabaseHelper(this);

        name=findViewById(R.id.name);
        unit=findViewById(R.id.unit);




        calory=findViewById(R.id.calory);
        fat=findViewById(R.id.fat);
        carb=findViewById(R.id.carb);
        proten=findViewById(R.id.proten);

        if(i==20) {

            bt.setText("تحديث البيانات");

            name.setText(myDb.get_data(position, 1));
            unit.setText(myDb.get_data(position, 2));
            calory.setText(myDb.get_data(position, 3));
            fat.setText(myDb.get_data(position, 4));
            carb.setText(myDb.get_data(position, 5));
            proten.setText(myDb.get_data(position, 6));

        }
    }

    public void save(View view) {

        if((calory.getText()+"")==""||(carb.getText()+"")==""||(fat.getText()+"")==""||(proten.getText()+"")==""||(name.getText()+"")==""||(unit.getText()+"")==""){
            Toast.makeText(this, "عليك ملئ جميع الخانات أولاً", Toast.LENGTH_SHORT).show();
        }
        else {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {

                if (i == 20) {
                    update();
                } else {
                    save();
                }
            }
        }

    }

    public void save(){

        name_txt=name.getText().toString();
        unit_txt=unit.getText().toString();

        boolean isInserted = myDb.insertData(name_txt,unit_txt,calory.getText().toString(),fat.getText().toString()
                ,carb.getText().toString(),proten.getText().toString() );
        if(isInserted == true)
            Toast.makeText(sql_add_new.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(sql_add_new.this,"Data not Inserted",Toast.LENGTH_LONG).show();

        Intent go = new Intent(this,sql_show_data.class);
        startActivity(go);
        finish();

    }

    public void update(){

        name_txt=name.getText().toString();
        unit_txt=unit.getText().toString();

        PRIMARY_KEY=myDb.ID(position);

        boolean isInserted = myDb.updateData (PRIMARY_KEY+"",name_txt,unit_txt,calory.getText().toString(),fat.getText().toString()
                ,carb.getText().toString(),proten.getText().toString() );
        if(isInserted == true)
            Toast.makeText(sql_add_new.this,"Data updated",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(sql_add_new.this,"Data not updated",Toast.LENGTH_LONG).show();

        Intent go = new Intent(this,sql_show_data.class);
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
