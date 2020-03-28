package com.seniorsteps.seniorsurvey.Base;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MyBaseActivity extends AppCompatActivity {

    protected AppCompatActivity activity;
    MaterialDialog materialDialog;
    public MyBaseActivity(){
        activity=this;
    }




    public MaterialDialog ShowMessage(String title, String content){

        return new MaterialDialog.Builder(this)
                .content(content)
                .title(title)
                .positiveText("ok")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public MaterialDialog ShowProgressBar(){
       materialDialog= new MaterialDialog.Builder(this)
                .progress(true,0)
                 .content("loading...")
                .title("please wait")
                .cancelable(false)
                .show();
       return materialDialog;
    }

    public void HideProgressBar(){
        if(materialDialog!=null&&materialDialog.isShowing())
            materialDialog.dismiss();
    }

    public MaterialDialog ShowConfirmationDialog(String title, String content, String pos, String neg, MaterialDialog.SingleButtonCallback posCallback, MaterialDialog.SingleButtonCallback negCallback){

        return new MaterialDialog.Builder(this)
                .content(content)
                .title(title)
                .positiveText(pos)
                .onPositive(posCallback)
                .negativeText(neg)
                .onNegative(negCallback)
                .show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void SaveString(String key,String value){
        SharedPreferences.Editor sharedPreferences =
                getSharedPreferences("survey",MODE_PRIVATE).edit();
        sharedPreferences.putString(key,value);
        sharedPreferences.apply();

    }
    public String getString(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("survey",MODE_PRIVATE);
      return   sharedPreferences.getString(key,null);

    }


}
