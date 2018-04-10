package com.example.nathan.cinenym;

import android.os.AsyncTask;
import android.widget.EditText;

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
import java.util.Random;

/**
 * Created by Adam Copeland on 12/03/2018.
 */

public class FetchGenre extends AsyncTask<Void, Void, Void>
{
    String data="", singleParsed="";
    protected int genre;
    Random rNumber = new Random();
    int listNumber = rNumber.nextInt(19);
    int pageNumber, rPageNumber;




    //needs to be passed an int value maybe store in an array action = 28, adventure = 12, animation = 16, comedy = 35, documentary = 99, drama = 18, family = 10751,
    FetchGenre(int genre)
    {
        this.genre = genre;

    }

    @Override
    protected Void doInBackground(Void... voids)
    {
        try
        {
            URL url = new URL("https://api.themoviedb.org/3/discover/movie?api_key=99038db7d4813b9d7fd41e54322a61dc&include_adult=false&vote_average.gte=7.5&with_genres="+genre);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null)
            {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject genreSearched = new JSONObject(data);
            pageNumber = genreSearched.getInt("total_pages");
            if(pageNumber<1000)
            {
                pageNumber = pageNumber;
                rPageNumber = rNumber.nextInt(pageNumber)-1;
            }
            else
            {
                rPageNumber = rNumber.nextInt(1000)-1;
            }
            //edit code from above to take in for the real random genera

            url = new URL("https://api.themoviedb.org/3/discover/movie?api_key=99038db7d4813b9d7fd41e54322a61dc&include_adult=false&vote_average.gte=7.5&with_genres="+genre+"&page="+rPageNumber);
            HttpURLConnection secondHttpUrl = (HttpURLConnection) url.openConnection();
            InputStream secondInputStream = secondHttpUrl.getInputStream();
            BufferedReader secondBuffR = new BufferedReader(new InputStreamReader(secondInputStream));
            data = "";
            line = "";
            while(line != null)
            {
                line = secondBuffR.readLine();
                data = data +line;
            }
            JSONObject randomSearch = new JSONObject(data);
            JSONArray genreJArray = new JSONArray(randomSearch.getString("results"));
            JSONObject genreGot = (JSONObject) genreJArray.get(listNumber);
            singleParsed = ""+genreGot.getString("title")+"\n"+
                    "Rating:     "+genreGot.getString("vote_average")+"\n"+
                    "Overview    "+genreGot.getString("overview");

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        RandomMovie.data.setText(singleParsed);
    }
}
