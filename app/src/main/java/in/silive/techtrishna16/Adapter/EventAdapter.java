package in.silive.techtrishna16.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import in.silive.techtrishna16.R;

/**
 * Created by H.P on 2/5/2016.
 */
public class EventAdapter extends BaseAdapter {
    String[] events;
    Integer[] event_img;
    public static LayoutInflater inflater = null;
    class Holder{
        TextView event;
        ImageView img_event;
    }
    public EventAdapter(Context context,String[] str,Integer[]integers){
        events=str;
        event_img=integers;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return events.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder= new Holder();
        View view;
        view=inflater.inflate(R.layout.events_adapter,null);
        holder.event=(TextView)view.findViewById(R.id.name_of_event);
        holder.event.setText(events[position]);
        holder.img_event=(ImageView)view.findViewById(R.id.img_of_event);
        holder.img_event.setImageResource(event_img[position]);
        return view;
    }
}
