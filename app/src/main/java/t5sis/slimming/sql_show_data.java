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
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Locale;

public class sql_show_data extends AppCompatActivity {


    DatabaseHelper myDb;
    ListView listv;
    private int ii;

    AdView mAdView;
    private int choose;

    private int ads;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_show_data);

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
            mAdView = findViewById(R.id.adView6_0);

        if(choose==1)
            mAdView = findViewById(R.id.adView6_1);


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


        myDb = new DatabaseHelper(this);
        listv=findViewById(R.id.lv);




        ArrayList<String> list = myDb.sho();
        ArrayAdapter mohawel = new ArrayAdapter(this,R.layout.list_unit,R.id.txt_NAME,list);
        listv.setAdapter(mohawel);


        final ArrayList<String> list_id = myDb.sho();



        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ii=i;



                AlertDialog.Builder sms = new AlertDialog.Builder(sql_show_data.this);
                sms.setMessage("حدد العملية المطلوبة :")
                        .setIcon(R.drawable.common_google_signin_btn_icon_dark)
                        .setTitle("")
                        .setNegativeButton("حذف", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                AlertDialog.Builder sms = new AlertDialog.Builder(sql_show_data.this);
                                sms.setMessage("سيتم حذف هذا العنصر")
                                        .setIcon(R.drawable.snf2)
                                        .setTitle("")
                                        .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                delet(ii);
                                            }
                                        })

                                        .setNegativeButton ("إلغاء", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .show();


                            }
                        })

                        .setPositiveButton("تعديل", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                update(ii);
                            }
                        })



                        .setNeutralButton("استعراض", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                show_data(ii);
                            }
                        })
                        .show();
            }
        });


    }




    public void neww (View view) {


        Intent go = new Intent(this,sql_add_new.class);
        go.putExtra("type",10);

       // go.putExtra("position",512);

        startActivity(go);
        finish();


    }

    public void delet(int i){

        position=myDb.ID(i);

        myDb.deleteData(position+"");


        refresh();
    }

    public void refresh(){
        ArrayList<String> list = myDb.sho();
        ArrayAdapter mohawel = new ArrayAdapter(this,R.layout.list_unit,R.id.txt_NAME,list);
        listv.setAdapter(mohawel);
    }

    public void update(int i){

        Intent go = new Intent(this,sql_add_new.class);
        go.putExtra("type",20);

        go.putExtra("position",i);

        startActivity(go);
        finish();

    }

    public void show_data(int i){


        Intent go = new Intent(this,show.class);




        go.putExtra("chose",7);

        go.putExtra("d1",myDb.get_data(i, 1));
        go.putExtra("d2",myDb.get_data(i, 2));
        go.putExtra("d3",myDb.get_data(i, 3));
        go.putExtra("d4",myDb.get_data(i, 4));
        go.putExtra("d5",myDb.get_data(i, 5));
        go.putExtra("d6",myDb.get_data(i, 6));



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
