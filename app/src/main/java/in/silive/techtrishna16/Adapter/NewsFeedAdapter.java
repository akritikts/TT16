package in.silive.techtrishna16.Adapter;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.silive.techtrishna16.NewsFeed.Feed;
import in.silive.techtrishna16.R;


/**
 * Created by AKG002 on 10-01-2016.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.feedViewHolder> {
    ArrayList<Feed> list;
    Context context;

    public NewsFeedAdapter(Context c, ArrayList<Feed> list) {
        super();
        this.context = c;
        this.list = list;
    }

    @Override
    public feedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.news_feed_card, parent, false);
        feedViewHolder viewHolder = new feedViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(feedViewHolder holder, int position) {
        holder.timeStamp.setText(list.get(position).getTimeStamp());
        holder.eventName.setText(list.get(position).getEventName());
        holder.title.setText(list.get(position).getTitle());
        holder.feed.setText(list.get(position).getFeed());
        holder.feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView) v;
                ObjectAnimator animation = ObjectAnimator.ofInt(v, "maxLines", textView.getLineCount());
                animation.setDuration(200).start();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class feedViewHolder extends RecyclerView.ViewHolder {
        TextView title, eventName, timeStamp, feed;

        public feedViewHolder(View itemView) {
            super(itemView);
            this.timeStamp = (TextView) itemView.findViewById(R.id.time_stamp);
            this.eventName = (TextView) itemView.findViewById(R.id.event_name);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.feed = (TextView) itemView.findViewById(R.id.feed);
        }
    }
}
