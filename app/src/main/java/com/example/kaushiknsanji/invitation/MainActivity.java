package com.example.kaushiknsanji.invitation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Main Activity of the Invitation App
 *
 * @author <a href="mailto:kaushiknsanji@gmail.com">Kaushik N Sanji</a>
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method called when the User clicks on the address location
     * @param view
     *          <br/> - Text View Resource id 'location_text'
     */
    public void onClickOfLocation(View view){
        //Dispatch an Intent to show the location on the Map
        String locationTitle = getResources().getText(R.string.title_text).toString();
        String locationPlace = getResources().getText(R.string.location_text).toString();
        String geoLocationUriStr = Uri.encode(locationTitle + ", " + locationPlace);
        Intent locIntent = new Intent(Intent.ACTION_VIEW);
        locIntent.setData(Uri.parse("geo:0,0?q=" + geoLocationUriStr));

        //Verifying that the intent will resolve to an activity
        if(locIntent.resolveActivity(getPackageManager()) != null){
            startActivity(locIntent);
        }
    }
}
