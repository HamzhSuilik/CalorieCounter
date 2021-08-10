package t5sis.slimming;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // *********************************

        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, getApplicationContext().getResources().getDisplayMetrics());


        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    }

    public void goo(View view) {
        Intent go = new Intent(this,main.class);
        go.putExtra("sms",1);
        startActivity(go);
        finish();

    }

    public void sss1(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",1);
        startActivity(go);
        finish();

    }

    public void sss2(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",2);
        startActivity(go);
        finish();

    }

    public void sss3(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",3);
        startActivity(go);
        finish();

    }

    public void sss4(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",4);
        startActivity(go);
        finish();

    }

    public void sss5(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",5);
        startActivity(go);
        finish();

    }

    public void sss6(View view) {

        Intent go = new Intent(this,main.class);
        go.putExtra("sms",6);
        startActivity(go);
        finish();

    }

    public void sss7(View view) {

        Intent go = new Intent(this,sql_show_data.class);
        go.putExtra("sms",8);
        startActivity(go);
        finish();

    }

    public void sss8(View view) {

        Intent go = new Intent(this,sql_add_new.class);
        go.putExtra("type",10);
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
