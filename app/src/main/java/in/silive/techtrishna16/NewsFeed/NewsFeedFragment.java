package in.silive.techtrishna16.NewsFeed;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import in.silive.techtrishna16.Adapter.NewsFeedAdapter;
import in.silive.techtrishna16.Control.Config;
import in.silive.techtrishna16.Control.FetchData;
import in.silive.techtrishna16.Listeners.FetchDataListener;
import in.silive.techtrishna16.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment implements FetchDataListener {
    ArrayList<Feed> list = new ArrayList<>();
    NewsFeedAdapter adapter;
    RecyclerView feedList;
    FetchData fetchData;
    ProgressDialog progressDialog;

    public NewsFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        fetchData = new FetchData(getContext(), FetchData.NewsFeedUrl, this, Config.GET_METHOD);
        fetchData.execute();
        feedList = (RecyclerView) view.findViewById(R.id.feed_list);
        feedList.setItemAnimator(new DefaultItemAnimator());
        adapter = new NewsFeedAdapter(getActivity(), list);
        feedList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        feedList.setAdapter(adapter);

        return view;
    }

    @Override
    public void postRequest(String res) {
        progressDialog.dismiss();
        try {
            JSONArray array = new JSONArray(res);
            for (int i = 0; i < array.length(); ++i) {
                JSONObject item = array.getJSONObject(i);
                Feed feed = new Feed();
                feed.setEventName(item.getString("EventName"));
                feed.setFeed(item.getString("Feed"));
                feed.setTitle(item.getString("Title"));
                feed.setTimeStamp(item.getString("TimeStamp"));
                list.add(feed);
                adapter.notifyItemInserted(i);

            }
        } catch (Exception e) {
            e.printStackTrace();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("TechTrishna");
            builder.setMessage("Error connecting to server");
            builder.setNeutralButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    fetchData = new FetchData(getContext(), FetchData.NewsFeedUrl, NewsFeedFragment.this, Config.GET_METHOD);
                    fetchData.execute();
                }
            });
        }
    }

    @Override
    public void preRequest() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);;
        progressDialog.setMessage("Connecting to server ...");
        progressDialog.show();
    }


}
