package in.hokyo.a5buttons;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ContactForm extends AppCompatActivity {

    private String name = null;
    private String contactNumber = null;
    private String message = null;
    private final String emailSubject = "Query from Android App";
    private final String hokyoemail = "info@tvfdm.in";
    private String emailBody = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        submit();
    }

    public void getData(View view){
        EditText nameEt, contactNumberET, messageET;
        nameEt = findViewById(R.id.nameEt);
        name = nameEt.getText().toString();

        contactNumberET = findViewById(R.id.contactNumberEt);
        contactNumber = contactNumberET.getText().toString();

        messageET = findViewById(R.id.messageEt);
        message = messageET.getText().toString();

        emailBody = "Name: " + name +
                "\n\nContact Number: "+ contactNumber +
                "\n\nMessage: " + message;
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void submit(){
        MaterialButton submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(view -> {
            getData(view);
            Log.d("contactFormDeb", "name = " + name+" "+"contact = " + contactNumber+" "+"message = " + message);
            Log.d("contactFormDeb", String.valueOf(name.isEmpty()));

            boolean nameEmptyCheck = (name.length()==0 || name.isEmpty());
            boolean contactEmptyCheck = (contactNumber.length()==0 || contactNumber.isEmpty());
            boolean messageEmptyCheck = (message.length()==0 || message.isEmpty());

            Log.d("contactFormDeb", "emptyCheck"+String.valueOf(nameEmptyCheck));
            Log.d("contactFormDeb", "emptyCheck"+String.valueOf(contactEmptyCheck));
            Log.d("contactFormDeb", "emptyCheck"+String.valueOf(messageEmptyCheck));

            if (nameEmptyCheck || contactEmptyCheck || messageEmptyCheck){
                Log.d("contactFormDeb", "lalalalala");
                Toast.makeText(ContactForm.this, "Sorry, please fill all the fields", Toast.LENGTH_LONG).show();
            }else{
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[] {hokyoemail});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
                getIntent().removeExtra("");

                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });
    }
}