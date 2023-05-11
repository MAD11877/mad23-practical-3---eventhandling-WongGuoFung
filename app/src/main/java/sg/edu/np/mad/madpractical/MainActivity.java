package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";
    User myUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume(){
        super.onResume();
        myUser = new User("Hello World!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

        TextView greeting = findViewById(R.id.userName);
        greeting.setText(myUser.getName());

        TextView description = findViewById(R.id.userDescription);
        description.setText(myUser.getDescription());
        Button fllwBtn = findViewById(R.id.followButton);
        fllwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Button A clicked");
                if (myUser.isFollowed()) {
                    myUser.setFollowed(false);
                    Log.v(TITLE, "Unfollowed");
                    fllwBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                } else {
                    myUser.setFollowed(true);
                    Log.v(TITLE, "Followed");
                    fllwBtn.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Intent myRecvIntent = getIntent();
        int randomNum = myRecvIntent.getIntExtra("randomNumber",0);
        TextView name = findViewById(R.id.userName);
        name.setText("MAD " + String.valueOf(randomNumber()));
    }
    private int randomNumber(){
        Random ran = new Random();
        int myRandomNumber  = ran.nextInt(1000000000);
        return myRandomNumber;
    }
}