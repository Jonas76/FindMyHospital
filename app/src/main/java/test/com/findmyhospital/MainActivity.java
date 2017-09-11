package test.com.findmyhospital;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String Tag = MainActivity.class.getName();
    CSVAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Needed for networking operation
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Lookup our ListView
        ListView mList = (ListView) findViewById(R.id.mList);
        //Create Adapter. The second parameter is required by ArrayAdapter
        //which our Adapter extends. In this example though it is unused,
        //so we'll pass it a "dummy" value of -1.
        mAdapter = new CSVAdapter(this, -1);
        //attach our Adapter to the ListView. This will populate all of the rows.
        mList.setAdapter(mAdapter);

        //This listener will get a callback whenever the user clicks on a row.

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                try {
                    Toast.makeText(v.getContext(), mAdapter.getItem(pos).getOrganisationID(), Toast.LENGTH_SHORT).show();
                }catch (NullPointerException e) {
                    Log.e(Tag,"Null pointer called" + e);
                }

            }
        });
    }
}
