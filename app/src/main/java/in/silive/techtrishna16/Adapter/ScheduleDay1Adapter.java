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
public class ScheduleDay1Adapter extends RecyclerView.Adapter<ScheduleDay1Adapter.ViewHolder> {
    ArrayList arrayList;
    Context c;

    public ScheduleDay1Adapter(Context c, ArrayList s) {
        super();
        this.arrayList = s;
        this.c = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.schedule_day_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
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
