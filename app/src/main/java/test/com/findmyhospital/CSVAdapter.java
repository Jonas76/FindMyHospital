package test.com.findmyhospital;

import android.content.Context;
import android.util.Log;
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
    private static String Tag = CSVAdapter.class.getName();
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
        //mView.setText(getItem(pos).getOrganisationName());
        mView.setText(getItem(pos).getOrganisationID());

        return mView;
    }

    private void loadArrayFromFile() {

        try {
            // Get input stream and Buffered Reader for our data file.
            //This can be used to get csv file from folder ctx.getResources().openRawResource(R.raw.hospital);
            InputStream is = new URL(hospitalURL).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            //Read each line

            while ((line = reader.readLine()) != null) {
                //Split to separate the name from the capital
                //TODO: have tried regex to split,However seems csv has no commas to spilt columns
                //String[] RowData = line.split("[ ]+");//("/,(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))/");
                String[] RowData = line.split(",");
                Log.d("Reading","" + line);

                //Create a State object for this row's data.
                HospitalReader cur = new HospitalReader();
                cur.setOrganisationID(RowData[0]);

                /*
                cur.setOrganisationCode(RowData[1]);
                cur.setOrganisationType(RowData[2]);
                cur.setSubType(RowData[3]);
                cur.setSector(RowData[4]);
                cur.setOrganisationStatus(RowData[5]);
                cur.setIsPimsManaged(RowData[6]);
                cur.setOrganisationName(RowData[7]);
                cur.setAddress1(RowData[8]);
                cur.setAddress2(RowData[9]);
                cur.setAddress3(RowData[10]);
                cur.setCity(RowData[11]);
                cur.setCounty(RowData[12]);
                cur.setPostcode(RowData[13]);
                cur.setLatitude(Integer.parseInt(RowData[14]);
                cur.setLongitude(Integer.parseInt(RowData[15]);
                cur.setParentODSCode(RowData[16]);
                cur.setParentName(RowData[17]);
                cur.setPhone(Integer.parseInt(RowData[18]);
                cur.setEmail(RowData[19]);
                cur.setWebsite(RowData[20]);
                cur.setFax(Integer.parseInt(RowData[21]));

                try {
                    cur.setOrganisationCode(RowData[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidObjectException(" OrganisationCode:" + e);
                   // Log.e(Tag, " OrganisationCode:" + e);
                }
                try {
                    cur.setOrganisationType(RowData[2]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "OrganisationType:" + e);
                }
                try {
                    cur.setSubType(RowData[3]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "SubType:" + e);
                }
                try {
                    cur.setSector(RowData[4]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "Sector:" + e);
                }
                try {
                    cur.setOrganisationStatus(RowData[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "OrganisationStatus:" + e);
                }
                try {
                    cur.setIsPimsManaged(RowData[6]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "IsPimsManaged:" + e);
                }
                try {
                    cur.setOrganisationName(RowData[7]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    //Log.e(Tag, "OrganisationName:" + e);
                }
                */

                //Add the State object to the ArrayList (in this case we are the ArrayList).
                this.add(cur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
