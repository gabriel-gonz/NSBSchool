package assistant.genuinecoder.s_assistant.main.components;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import assistant.genuinecoder.s_assistant.R;
import assistant.genuinecoder.s_assistant.main.AppBase;

public class CommunicationActivity extends AppCompatActivity {

    public static String time, period;
    ListView listView;
    ListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<String> names;
    ArrayList<String> registers;
    Activity thisActivity = this;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        time = getIntent().getStringExtra("DATE");
        period = getIntent().getStringExtra("PERIOD");

        Log.d("Communication", time + " -- " + period);
        listView = (ListView) findViewById(R.id.attendanceListViwe);
        names = new ArrayList<>();
        registers = new ArrayList<>();

        Button btn = (Button) findViewById(R.id.loadButton);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListView(v);
            }
        });

        Button btnx = (Button) findViewById(R.id.buttonSaveAttendance);
        assert btnx != null;
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = null, chooser = null;
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to = {"emailAddress1", "emailAddress2"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Email test");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi there. Testing the mail app");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);
//                Toast.makeText(getBaseContext(), "Saving", Toast.LENGTH_LONG).show();
//                adapter.saveAll();
            }
        });

        spinner = (Spinner) findViewById(R.id.attendanceSpinner);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, AppBase.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }

    public void loadListView(View view) {
        names.clear();
        registers.clear();
        String qu = "SELECT * FROM STUDENT WHERE cl = '" + spinner.getSelectedItem().toString() + "' " +
                "ORDER BY ROLL";
        Cursor cursor = AppBase.handler.execQuery(qu);
        if (cursor == null || cursor.getCount() == 0) {
            Log.e("Communication", "Null cursor");
        } else {
            int ctr = 0;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                names.add(cursor.getString(0) + " (" + cursor.getInt(4) + ')');
                registers.add(cursor.getString(2));
                cursor.moveToNext();
                ctr++;
            }
            if (ctr == 0) {
                Toast.makeText(getBaseContext(), "No Students Found", Toast.LENGTH_LONG).show();
            }
            Log.d("Communication", "Got " + ctr + " students");
        }
        adapter = new ListAdapter(thisActivity, names, registers);
        listView.setAdapter(adapter);
    }
}

