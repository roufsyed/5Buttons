package in.hokyo.a5buttons;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    public void buttonOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.hokyoButton:{
                Intent hokyoIntent = new Intent(MainActivity.this, MyWebView.class);
                String hokyoWebsite = "http://www.hokyo.in/";
                hokyoIntent.putExtra("website", hokyoWebsite);
                Log.d("HOKYO_TEST", "HOKYO_TEST:"+ hokyoWebsite);
                startActivity(hokyoIntent);
                break;
            }

            case R.id.tvfdmButton:{
                Intent tvfdmIntent = new Intent(MainActivity.this, MyWebView.class);
                String tvfdmWebsite = "http://www.tvfdm.in/";
                tvfdmIntent.putExtra("website", tvfdmWebsite);
                startActivity(tvfdmIntent);
                break;
            }

            case R.id.callUsButton:{
                String hokyoPhoneNumber = "8100929050";
                Uri uri = Uri.parse("tel:"+Uri.encode(hokyoPhoneNumber));
                Intent callUsIntent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(callUsIntent);
                break;
            }
            case R.id.contactUsButton:{
                Intent contactUsIntent = new Intent(MainActivity.this, ContactForm.class);
                Log.d("CONTACT_TEST", "CONTACT_TEST");
                startActivity(contactUsIntent);
                break;
            }
            case R.id.downloadButton:{
                Intent downloadIntent = new Intent(android.content.Intent.ACTION_VIEW);
                String hokyoPackageName = "com.vootflix.app";
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage(hokyoPackageName);
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    String playstoreLink = "https://play.google.com/store/apps/details?id=com.vootflix.app";
                    downloadIntent.setData(Uri.parse(playstoreLink));
                    startActivity(downloadIntent);
                }
                break;
            }
        }
    }
}