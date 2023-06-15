package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String title = "Activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "ListActivity resumed!");
        ImageView img = findViewById(R.id.androidclick);

        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.v(title, "Button clicked");
                alertDialog();
            }
        });
    }

    private void alertDialog(){
        Log.v(title, "Alert Method called");
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setCancelable(false);
        builder.setMessage("MADness");
        builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtra("rannum", String.valueOf(randomNum()));
                startActivity(myIntent);
                Log.v(title, "Activity started");
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }

    private int randomNum(){
        Random ran = new Random();
        int randomNumber = ran.nextInt(1000000000);
        return randomNumber;
    }

}