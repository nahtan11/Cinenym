package com.example.nathan.cinenym;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.nathan.cinenym.MainActivity;
import com.google.android.gms.common.api.Response;

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
import java.util.ArrayList;

/**
 * Created by Adam Copeland on 08/03/2018.
 */

public class fetchedData extends AsyncTask<Void, Void, Void> {



    String data="";
    String dataParsed="";
    String singleParsed="";
    protected String movie;
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Bitmap> posters = new ArrayList<>();

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
            Bitmap logo = null;
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
                /*JSONArray jsonArray = new JSONArray(totalSearched.getString("results"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    jsonObject.isNull("");
                    singleParsed = "" + jsonObject.getString("title") + "\n" +
                            "Rating:         " + jsonObject.getString("vote_average") + "\n" +
                            "Overview:    " + jsonObject.getString("overview") + "\n\n";

                    dataParsed += singleParsed;
                }*/

                JSONArray jsonArray = new JSONArray(totalSearched.getString("results"));
                for(int i=0;i<jsonArray.length(); i++)
                {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    movies.add(new Movie(jsonObject.getString("title"), jsonObject.getString("vote_average"), jsonObject.getString("overview"), jsonObject.getString("poster_path")));
                    dataParsed += movies.get(i).toString();
                    InputStream is = new URL("https://image.tmdb.org/t/p/original"+movies.get(i).getLinkToImage()).openStream();
                    logo = BitmapFactory.decodeStream(is);
                    posters.add(logo);
                }


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch(Exception e){ // Catch the download exception
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);
        if(movies.size() > 1) {
            MovieSearchActivity.data1.setText(movies.get(0).toString());
            MovieSearchActivity.im1.setImageBitmap(posters.get(0));
            MovieSearchActivity.data2.setText(movies.get(1).toString());
            MovieSearchActivity.im2.setImageBitmap(posters.get(1));
            MovieSearchActivity.data3.setText(movies.get(2).toString());
            MovieSearchActivity.im3.setImageBitmap(posters.get(2));
            MovieSearchActivity.data4.setText(movies.get(3).toString());
            MovieSearchActivity.im4.setImageBitmap(posters.get(3));
            MovieSearchActivity.data5.setText(movies.get(4).toString());
            MovieSearchActivity.im5.setImageBitmap(posters.get(4));
            MovieSearchActivity.data6.setText(movies.get(5).toString());
            MovieSearchActivity.im6.setImageBitmap(posters.get(5));
            MovieSearchActivity.data7.setText(movies.get(6).toString());
            MovieSearchActivity.im7.setImageBitmap(posters.get(6));
            MovieSearchActivity.data8.setText(movies.get(7).toString());
            MovieSearchActivity.im8.setImageBitmap(posters.get(7));
            MovieSearchActivity.data9.setText(movies.get(8).toString());
            MovieSearchActivity.im9.setImageBitmap(posters.get(8));
            MovieSearchActivity.data10.setText(movies.get(9).toString());
            MovieSearchActivity.im10.setImageBitmap(posters.get(9));
            MovieSearchActivity.data11.setText(movies.get(10).toString());
            MovieSearchActivity.im11.setImageBitmap(posters.get(10));
            MovieSearchActivity.data12.setText(movies.get(11).toString());
            MovieSearchActivity.im12.setImageBitmap(posters.get(11));
            MovieSearchActivity.data13.setText(movies.get(12).toString());
            MovieSearchActivity.im13.setImageBitmap(posters.get(12));
            MovieSearchActivity.data14.setText(movies.get(13).toString());
            MovieSearchActivity.im14.setImageBitmap(posters.get(13));
            MovieSearchActivity.data15.setText(movies.get(14).toString());
            MovieSearchActivity.im15.setImageBitmap(posters.get(14));
            MovieSearchActivity.data16.setText(movies.get(15).toString());
            MovieSearchActivity.im16.setImageBitmap(posters.get(15));
            MovieSearchActivity.data17.setText(movies.get(16).toString());
            MovieSearchActivity.im17.setImageBitmap(posters.get(16));
            MovieSearchActivity.data18.setText(movies.get(17).toString());
            MovieSearchActivity.im18.setImageBitmap(posters.get(17));
            MovieSearchActivity.data19.setText(movies.get(18).toString());
            MovieSearchActivity.im19.setImageBitmap(posters.get(18));
            MovieSearchActivity.data20.setText(movies.get(19).toString());
            MovieSearchActivity.im20.setImageBitmap(posters.get(19));
        }
        else {
            MovieSearchActivity.data1.setText(movies.get(0).toString());
            MovieSearchActivity.im1.setImageBitmap(posters.get(0));
        }
    }
}
