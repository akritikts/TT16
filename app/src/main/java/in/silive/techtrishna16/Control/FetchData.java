package in.silive.techtrishna16.Control;

import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import in.silive.techtrishna16.Listeners.FetchDataListener;

/**
 * Created by AKG002 on 21-01-2016.
 */
public class FetchData extends AsyncTask<URL, Void, String> {
    public static final String NewsFeedUrl = "http://www.silive.in/tt15.rest/api/newsfeed/getnewsfeeds/1";
    public static final String CollegeUrl = "http://www.silive.in/tt15.rest/api/college/createcollege/1";
    public static final String NewRegistration = "http://www.silive.in/tt15.rest/api/Student/CreateStudent";
    public static final String GetCollegeList = "http://www.silive.in/tt15.rest/api/college/getcolleges";
    URL url;
    HttpURLConnection httpURLConnection;
    BufferedReader bufferedReader;
    String result;
    FetchDataListener listener;
    private String type_of_method;
    Context context;
    public FetchData(Context context,String url, FetchDataListener listener,String type_of_method) {
        this.context = context;
        try {
            this.url = new URL(url);
            this.listener = listener;
            this.type_of_method=type_of_method;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public FetchData(String url, FetchDataListener listener,String type_of_method) {
        try {
            this.url = new URL(url);
            this.listener = listener;
            this.type_of_method=type_of_method;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected String doInBackground(URL... params) {
        try {

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(type_of_method);
            if(type_of_method.equals(Config.POST_METHOD)){

            }
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println("Code :" + responseCode);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
                sb.append(line);
            result = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.preRequest();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.postRequest(s);
    }
}
