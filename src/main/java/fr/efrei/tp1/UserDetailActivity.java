package fr.efrei.tp1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.efrei.tp1.bo.User;

public class UserDetailActivity
    extends AppCompatActivity
{

  public static final String USER_EXTRA = "userExtra";

  //The tag used into this screen for the logs
  public static final String TAG = UserDetailActivity.class.getSimpleName();

  private TextView name;


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    //We first set up the layout linked to the activity
    setContentView(R.layout.activity_user_detail);

    //Then we retrieved the widget we will need to manipulate into the
    name = findViewById(R.id.name);

    //Then we retrieve the extra
    final User user = (User) getIntent().getSerializableExtra(UserDetailActivity.USER_EXTRA);

    //Then we bind the User and the UI
    name.setText(user.name);


    //Then we update the title into the actionBar
    getSupportActionBar().setTitle(user.name);
  }

}