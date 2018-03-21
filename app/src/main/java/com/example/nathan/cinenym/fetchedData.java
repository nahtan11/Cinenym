package com.example.nathan.cinenym;

import android.os.AsyncTask;
import android.widget.EditText;

import com.example.nathan.cinenym.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Adam Copeland on 08/03/2018.
 */

public class fetchedData extends AsyncTask<Void, Void, Void> {

    String data="";
    String dataParsed="";
    String singleParsed="";
    protected String movie;

    fetchedData(String movie)
    {
        this.movie = movie;
    }

    @Override
    protected Void doInBackground(Void... voids)
    {

        try
        {
            //take image in also then create new class for movie object so i can display from that
            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=99038db7d4813b9d7fd41e54322a61dc&language=en-US&page=1&include_adult=false&query="+movie);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject totalSearched = new JSONObject(data);

            if(totalSearched.getString("total_results").equals("0"))
            {
                dataParsed = "No results for "+movie+".";
            }
            else
            {
                JSONArray jsonArray = new JSONArray(totalSearched.getString("results"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    jsonObject.isNull("");
                    singleParsed = "" + jsonObject.getString("title") + "\n" +
                            "Rating:         " + jsonObject.getString("vote_average") + "\n" +
                            "Overview:    " + jsonObject.getString("overview") + "\n\n";

                    dataParsed += singleParsed;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        MovieSearchActivity.data.setText(dataParsed);
    }
}
