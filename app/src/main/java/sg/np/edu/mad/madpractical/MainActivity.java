package sg.np.edu.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    final String TITLE = "MADPractical";
    String myRecvNum = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "Start");
    }

    @Override
    protected void onResume(){

        super.onResume();
        Log.v(TITLE, "Resume");

        User user1 = new User("Shahid", "zao shang hao zhong guo", 1, false);
        Button fbutton = findViewById(R.id.fbutton);
        TextView fToast = findViewById(R.id.toastview);

        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.followed == false){
                    fToast.setText("Unfollowed");
                    fbutton.setText("FOLLOW");
                    user1.followed = true;
                }
                else {
                    fbutton.setText("UNFOLLOW");
                    user1.followed = false;
                    fToast.setText("Followed");

                }
            }
        });

        TextView namebox = findViewById(R.id.namebox);
        TextView descbox = findViewById(R.id.descbox);
        namebox.setText(user1.name);
        descbox.setText(user1.description);

        Intent myRecvIntent = getIntent();
        myRecvNum = myRecvIntent.getStringExtra("rannum");
        namebox.setText(user1.name + myRecvNum);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "Paused");
    }

    @Override
    protected void onStop(){

        super.onStop();
        Log.v(TITLE, "Stop");
    }

    @Override
    protected void onRestart(){

        super.onRestart();
        Log.v(TITLE, "Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TITLE, "Destroy");
    }
}