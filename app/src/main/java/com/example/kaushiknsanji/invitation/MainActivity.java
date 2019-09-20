/*
 * Copyright 2017 Kaushik N. Sanji
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kaushiknsanji.invitation;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Main Activity of the Invitation App
 *
 * @author Kaushik N Sanji
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Method called when the User clicks on the address location
     * @param view Text View Resource id 'location_text'
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
