package in.silive.techtrishna16.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.silive.techtrishna16.R;

/**
 * Created by H.P on 1/30/2016.
 */
public class ListviewAdapter extends BaseAdapter {
    String[]result;
    String[] header;
    Integer[]id;
    Context context;
    private static LayoutInflater inflater=null;
    public class Holder{
        TextView tv;
        LinearLayout ll;
        TextView container_text;
        ImageView container_img;
    }
    public ListviewAdapter(Context context,String[] strings,String[] text_row,Integer[] integer){
        header=strings;
        id=integer;
        result=text_row;

        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return result.length;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View row_view;
        row_view=inflater.inflate(R.layout.adapter_contact_us,null);
        holder.tv=(TextView)row_view.findViewById(R.id.contact_header);
        holder.ll=(LinearLayout)row_view.findViewById(R.id.contact_container);
        holder.container_img=(ImageView)row_view.findViewById(R.id.container_img);
        holder.container_text=(TextView)row_view.findViewById(R.id.container_text);
        holder.tv.setText(header[position]);
        holder.container_img.setImageResource(id[position]);
        holder.container_text.setText(result[position]);
        return row_view;

    }
}
