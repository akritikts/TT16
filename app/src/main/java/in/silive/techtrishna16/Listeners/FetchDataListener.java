package in.silive.techtrishna16.Listeners;

import android.content.Context;

/**
 * Created by AKG002 on 21-01-2016.
 */
public interface FetchDataListener {
    public void preRequest();
    public void postRequest(String res);

    public Context getContext();

}
