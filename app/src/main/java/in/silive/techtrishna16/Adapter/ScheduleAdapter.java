package in.silive.techtrishna16.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import in.silive.techtrishna16.CustomViews.CustomTimelineView;
import in.silive.techtrishna16.R;

/**
 * Created by AKG002 on 27-01-2016.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    ArrayList arrayList;
    Context c;

    public ScheduleAdapter(Context c, ArrayList s) {
        super();
        this.arrayList = s;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutResource = 0;
        if (viewType == 0) {
            layoutResource = R.layout.schedule_item_even;
        } else {
            layoutResource = R.layout.schedule_item_odd;
        }
        View view = LayoutInflater.from(c).inflate(layoutResource, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemViewType(int position) {
        return (position + 1) % 2;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {

            super(itemView);
        }
    }

}
