package in.silive.techtrishna16.Control;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import in.silive.techtrishna16.Listeners.RegisterListener;

/**
 * Created by H.P on 1/24/2016.
 */


    public class Validation extends AsyncTask<URL,Void, String> {
    String mail_phone_chk;
    HashMap map_mail_phone;
    RegisterListener listener;
    public Validation(RegisterListener listener ,String str)
    {
        this.listener = listener;
        mail_phone_chk=str;
        map_mail_phone=new HashMap();
    }



    @Override
        protected String doInBackground(URL... params) {
        if (Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",mail_phone_chk))
        {
       checkemail(mail_phone_chk);

        return null;
        }

        else
        {
             checknumer(mail_phone_chk);
           return null;

        }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listener.mail_phone_chk(map_mail_phone);

        }





    public Map checkemail(String s) {
        URL httpUrl;
        try {
            httpUrl = new URL(
                    "http://www.silive.in/tt15.rest/api/Student/IsEmailAlreadyRegistered?email=" + s);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.connect();
            connection.setConnectTimeout(5000);
            InputStream in = connection.getInputStream();
            GetStringFromStream gsfs = new GetStringFromStream();
            String data = gsfs.getString(in);
            Log.d("data"," "+ data);
            JSONObject obj = new JSONObject(data);
            String message = obj.getString("IsEmailAlreadyRegistered");
            Log.d("data"," "+ message);
            map_mail_phone.put("E-mail",message);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map_mail_phone;
    }

    public Map checknumer(String s) {
        URL httpUrl;
        try {
            httpUrl = new URL(
                    "http://www.silive.in/tt15.rest/api/Student/IsPhoneNoAlreadyRegistered?phoneno="
                            + s);
            HttpURLConnection connection = (HttpURLConnection) httpUrl
                    .openConnection();
            connection.connect();
            InputStream in = connection.getInputStream();
            GetStringFromStream gsfs = new GetStringFromStream();
            String data = gsfs.getString(in);
            Log.d("data"," "+ data);
            JSONObject obj = new JSONObject(data);
            String message = obj.getString("IsPhoneNoAlreadyRegistered");
            Log.d("data"," "+ message);
            map_mail_phone.put("Phone_no",message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map_mail_phone;
    }



}

