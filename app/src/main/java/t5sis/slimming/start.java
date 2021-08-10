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
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Locale;

public class start extends AppCompatActivity {

    private int ads;
    private int month;
    private int day;
    private int hour;

    private int month_now;
    private int day_now;
    private int hour_now;

    private int ok;


    // ad adrese

    private int number;
    private int id;
    private boolean okk =true;
    private boolean check;

    private int value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        if ("t5sis.slimming"!=("t5sis.sli"+"mming")){
            finish();
        }


        // ad adrese

        number=27;
        id=0;
        okk=true;
        value=99;

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        check=gg.getBoolean("check",false);
        // ###############################


        boolean kt=gg.getBoolean("start_key",false);

        if(kt==false) {
            read();
            read2();
        }

        // *********************************

        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        ok=0;

        // ####################################
        // Remove ad
        // ###################################
        SharedPreferences gg2 = getSharedPreferences("file1", Context.MODE_PRIVATE);
        ads=gg2.getInt("ads",0);
        // ######################################




        month=gg.getInt("month",0);
        day=gg.getInt("day",0);
        hour=gg.getInt("hour",0);

        Calendar c = Calendar.getInstance();

        month_now=c.get(Calendar.MONTH);
        day_now=c.get(Calendar.DAY_OF_MONTH);
        hour_now=c.get(Calendar.HOUR_OF_DAY);


        if (ads==1) {


            int m[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


            if (month != month_now && (month + 1) != month_now)
                ok = 1;

            if (month == month_now) {
                if (day != day_now && (day + 1) != day_now)
                    ok = 1;

                if ((day + 1) == day_now) {

                    if (hour_now > hour)
                        ok = 1;
                }
            }


            if ((month + 1) == month_now) {
                if (day_now != 1)
                    ok = 1;

                if (day != m[month])
                    ok = 1;
            }

            if (ok==1){

                SharedPreferences.Editor copy = gg.edit();
                copy.putInt("ads", 0);
                copy.apply();

                ads=0;


            }


        }


    }

    public void snf(View view) {
        check();

        Intent go = new Intent(this,main_menu.class);
        startActivity(go);
        finish();
    }

    public void cal(View view) {
        check();

        Intent go = new Intent(this,test.class);
        startActivity(go);
        finish();
    }

    public void artical(View view) {
        check();

        Intent go = new Intent(this,article.class);
        startActivity(go);
        finish();
    }

    public void rate(View view) {
        check();

        Intent star5 =new Intent(Intent.ACTION_VIEW);
        star5.setData(Uri.parse("https://play.google.com/store/apps/details?id=t5sis.slimming"));
        startActivity(star5);


    }

    public void share(View view) {
        check();

        Intent shear =new Intent(Intent.ACTION_SEND);
        shear.setType("text/plain");
        shear.putExtra(Intent.EXTRA_TEXT,"تطبيق حساب السعرات الحرارية"+"\n"+ "يحتوي على حسابات الوزن المثالي و حرق الرياضة للطاقة و غيرها من الحسابات المهمة"
                +"\n"+"حمله من هذا الرابط" +"\n"+"https://play.google.com/store/apps/details?id=t5sis.slimming");
        startActivity(shear);
    }

    public void ads(View view) {
        check();

        if (ads==1){
            Toast.makeText(this, "تم إزالة الإعلانات مسبقاً", Toast.LENGTH_SHORT).show();
        }else {
            Intent go = new Intent(this, ads.class);
            startActivity(go);
            finish();
        }
    }

    public void out(View view) {

        check();

        AlertDialog.Builder sms = new AlertDialog.Builder(this);
        sms.setMessage("هل تريد الخروج ؟")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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

    public void web(View view){
        check();
        Intent star5 =new Intent(Intent.ACTION_VIEW);
        star5.setData(Uri.parse("https://www.t5sis.com/"));
        startActivity(star5);
    }

    public void youtube (View view){
        check();
        Intent star5 =new Intent(Intent.ACTION_VIEW);
        star5.setData(Uri.parse("https://www.youtube.com/user/T5sis"));
        startActivity(star5);
    }

    public void vidio (View view){
        check();
        Intent go = new Intent(this,vidio.class);
        startActivity(go);
        finish();
    }

    @Override
    public void onBackPressed() {

        check();

        //super.onBackPressed();
        AlertDialog.Builder sms = new AlertDialog.Builder(this);
        sms.setMessage("هل تريد العودة الخروج من التطبيق")
                .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setTitle("")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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


    public void read(){



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("id");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
                SharedPreferences.Editor copy = gg.edit();
                copy.putInt("ad_id", dataSnapshot.getValue(int.class));
                copy.apply();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                //value = -9;

            }
        });



    }

    public void read2(){



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("number");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
                SharedPreferences.Editor copy = gg.edit();
                copy.putInt("number", dataSnapshot.getValue(int.class));
                copy.apply();


            }

            @Override
            public void onCancelled(DatabaseError error) {
                //value = -9;

            }
        });



    }

    public void next(){

        int ad,num;

        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);

        int s1=gg.getInt("ad_id",1009);
        int s2=gg.getInt("number",1009);

        ad=s1;
        num=s2;

        if (ad==0){
            ad=1;
        }else{
            ad=0;
        }

        num++;

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("id");
        myRef.setValue(ad);

        DatabaseReference myRef2 = database.getReference("number");
        myRef2.setValue(num);

        SharedPreferences gg2 = getSharedPreferences("file1", Context.MODE_PRIVATE);
        SharedPreferences.Editor copy = gg2.edit();
        copy.putBoolean("start_key",true);
        copy.apply();

    }

    public void check(){
        SharedPreferences gg = getSharedPreferences("file1", Context.MODE_PRIVATE);
        int s1=gg.getInt("ad_id",1009);
        boolean k=gg.getBoolean("start_key",false);

        if(s1!=1009&&k==false)
            next();
    }

}
