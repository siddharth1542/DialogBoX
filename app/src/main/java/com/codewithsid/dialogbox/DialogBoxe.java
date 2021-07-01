package com.codewithsid.dialogbox;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.codewithsid.dialogbox.models.Models;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;


public class DialogBoxe {


    private  TextView title;
    private  ImageView img;
    SwipeDismissDialog swipeDismissDialog;
   private Button btn;
   Dialog dialog;



    private static  DialogBoxe Instance;


    public static DialogBoxe getInstance(){

        if(Instance ==null){
            Instance = new DialogBoxe();
        }
        return Instance;
    }

    public void showDialogBox(Context context, Models models) {


        View v = LayoutInflater.from(context).inflate(R.layout.dialog_box,null);
//        dialog = new Dialog(context);
//
//
//        dialog.setContentView(R.layout.dialog_box);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//        img = dialog.findViewById(R.id.imagepost);
//        title = dialog.findViewById(R.id.title_tv);
//        btn = dialog.findViewById(R.id.SuccessClick);

//
//        final AlertDialog.Builder aleart = new AlertDialog.Builder(context);
//        View v  = LayoutInflater.from(context).inflate(R.layout.dialog_box,null);

      title = v.findViewById(R.id.title_tv);
     img = v.findViewById(R.id.imagepost);
      btn = v.findViewById(R.id.SuccessClick);

        title.setText(models.getTitle());
        Glide.with(context)
                .load(models.getImageURL())
                .into(img);

//        dialog.show();
        Log.d("tt","yuyuy"+models.getTitle());



        swipeDismissDialog = new SwipeDismissDialog.Builder(context)
                .setView(v)
                .build()
                .show();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Thh","thehappy");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(models.getSuccess_url()));
                context.startActivity(intent);
            }
        });


    }


}
