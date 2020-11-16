package fr.efrei.tp1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.efrei.tp1.bo.User;
import fr.efrei.tp1.repository.UserRepository;

final public class AddUserActivity
    extends AppCompatActivity
    implements OnClickListener
{

  //The tag used into this screen for the logs
  public static final String TAG = AddUserActivity.class.getSimpleName();

  private EditText name;


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);

    //We first set up the layout linked to the activity
    setContentView(R.layout.activity_add_user);

    //Then we retrieved the widget we will need to manipulate into the
    name = findViewById(R.id.name);


    //We configure the click on the save button
    findViewById(R.id.save).setOnClickListener(this);
  }

  @Override
  public void onClick(View v)
  {
    //we first retrieve user's entries
    final String userName = name.getEditableText().toString();


    //We display the properties into the logcat
    displayUserEntries(userName);

    //We check if all entries are valid (not null and not empty)
    final boolean canAddUser = checkFormEntries(userName);

    if (canAddUser == true)
    {
      //We add the user to the list and we reset the form
      saveUser(userName);
      resetForm();
    }
    else
    {
      //we display a log error and a Toast
      Log.w(AddUserActivity.TAG, "Cannot add the user");
      Toast.makeText(this, R.string.cannot_add_user, Toast.LENGTH_SHORT).show();
    }
  }

  private void resetForm()
  {
    name.setText(null);

  }

  private void saveUser(String userName)
  {
    UserRepository.getInstance().addUser(new User(userName));
  }

  private boolean checkFormEntries(String userName)
  {
    return TextUtils.isEmpty(userName) == false;
  }

  private void displayUserEntries(String userName)
  {
    Log.d(AddUserActivity.TAG, "name : '" + userName + "'");

  }

}