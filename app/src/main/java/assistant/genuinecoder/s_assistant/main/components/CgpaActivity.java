package assistant.genuinecoder.s_assistant.main.components;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import assistant.genuinecoder.s_assistant.R;

public class CgpaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
        Button btnNextScreen = (Button) findViewById(R.id.btnNextScreen);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {


            public void process(View view) {

                Intent intent = null, chooser = null;


                if (view.getId() == R.id.sendMail) {
                    intent = new Intent(Intent.ACTION_SEND);

                    intent.setData(Uri.parse("mailto:"));
                    String[] to = {"emailAddress1", "emailAddress2"};
                    intent.putExtra(Intent.EXTRA_EMAIL, to);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Email test");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hi there. Testing the mail app");
                    intent.setType("message/rfc822");
                    chooser = Intent.createChooser(intent, "Send Email");
                    startActivity(chooser);
                }
            }
        }
    }
}

