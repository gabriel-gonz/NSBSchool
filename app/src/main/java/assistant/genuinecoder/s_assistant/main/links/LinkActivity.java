package assistant.genuinecoder.s_assistant.main.links;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import assistant.genuinecoder.s_assistant.R;
public class LinkActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        Button FB = (Button) findViewById(R.id.facebook);
        Button WB = (Button) findViewById(R.id.website);

        FB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
            Intent intent = null, chooser = null;

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.facebook.com/nrithyopasana"));
            chooser = Intent.createChooser(intent, "Launch Facebook");
            startActivity(chooser);
            }
        });
        WB.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
            Intent intent = null, chooser = null;

            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://ng.it5m.com.au/"));
            chooser = Intent.createChooser(intent, "Launch Website");
            startActivity(chooser);
            }
        });

    }

}
