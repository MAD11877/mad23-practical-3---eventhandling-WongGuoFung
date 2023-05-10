package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String title = "List Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(title, "On Resume!");
        ImageView andIcon = findViewById(R.id.androidIcon);
        andIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title, "Android Icon Clicked");
                AlertDialog.Builder profileBuilder = new AlertDialog.Builder(andIcon.getContext());
                profileBuilder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    // After clicking on view, random integer generated.
                    public void onClick(DialogInterface dialog, int i) {
                        Log.v(title, "User wants to view!");
                        Intent viewIntent = new Intent(ListActivity.this, MainActivity.class);
                        viewIntent.putExtra("randomNumber", randomNumber());
                        Log.v(title, "Random number is " + randomNumber());
                        startActivity(viewIntent);
                    }

                });
                profileBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Log.v(title, "User wants to close builder!");
                    }
                });
                AlertDialog alert = profileBuilder.create();
                alert.setTitle("Profile");
                alert.setMessage("MADness");
                alert.show();
            }
        });
    }
    private int randomNumber(){
        Random ran = new Random();
        int myRandomNumber  = ran.nextInt(1000000000);
        return myRandomNumber;
    }
}