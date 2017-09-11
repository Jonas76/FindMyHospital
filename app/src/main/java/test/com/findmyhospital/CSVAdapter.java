package test.com.findmyhospital;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by John on 10/09/2017.
 */

public class CSVAdapter extends ArrayAdapter<HospitalReader> {
    private Context ctx;

    private String hospitalURL = "https://data.gov.uk/data/resource/nhschoices/Hospital.csv";

    public CSVAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.ctx = context;
        //Load the data.
        loadArrayFromFile();
    }

    /*
     * getView() is the method responsible for building a View out of a some data that represents
     * one row within the ListView.
     * (non-Javadoc)
     * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
     */
    @Override
    public View getView(final int pos, View convertView, final ViewGroup parent) {

        TextView mView = (TextView) convertView;
        //If convertView was null then we have to create a new TextView.
        //If it was not null then we'll re-use it by setting the appropriate
        //text String to it.
        if (null == mView) {
            mView = new TextView(parent.getContext());
            mView.setTextSize(14);
        }

        //Set the state name as the text.
        try {
            mView.setText(getItem(pos).getOrganisationID());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //We could handle the row clicks from here. But instead
        //we'll use the ListView.OnItemClickListener from inside
        //of MainActivity, which provides some benefits over doing it here.

		/*mView.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(parent.getContext(), getItem(pos).getOrganisationID(), Toast.LENGTH_SHORT).show();
			}
		});*/

        return mView;
    }

    private void loadArrayFromFile() {

        try {
            // Get input stream and Buffered Reader for our data file.
            InputStream is = new URL(hospitalURL).openStream();//ctx.getResources().openRawResource(R.raw.hospital);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            //Read each line

            while ((line = reader.readLine()) != null) {
                //Split to separate the name from the capital

                String[] RowData = line.split(",");

                //Create a State object for this row's data.
                HospitalReader cur = new HospitalReader();

                cur.setOrganisationID(RowData[0]);

                //getting more columns seems to fail, maybe due to csv file not have separated column?
//					try {
//						cur.setOrganisationCode(RowData[1]);
//					}catch (ArrayIndexOutOfBoundsException e) {
//						Log.e("OrganisationCode"," Failed");
//					}
                //Add the State object to the ArrayList (in this case we are the ArrayList).
                this.add(cur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
