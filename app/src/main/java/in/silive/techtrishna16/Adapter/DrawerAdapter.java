package in.silive.techtrishna16.Adapter;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import in.silive.techtrishna16.R;


/**
 * Created by AKG002 on 10-01-2016.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.mDrawerViewHolder>{
    TypedArray icons;
    String[] items;
    Context context;
    public DrawerAdapter(Context c, TypedArray icons, String[] itemsList) {
        super();
        this.context = c;
        this.icons = icons;
        this.items = itemsList;

    }

    @Override
    public mDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(context).inflate(R.layout.navigation_drawer_item, parent,false);
        mDrawerViewHolder viewHolder = new mDrawerViewHolder(row);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(mDrawerViewHolder holder, int position) {
        holder.itemIcon.setImageResource(icons.getResourceId(position,-1));
        holder.itemText.setText(items[position]);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class mDrawerViewHolder extends RecyclerView.ViewHolder{
        ImageView itemIcon;
        TextView itemText;

        public mDrawerViewHolder(View itemView) {
            super(itemView);
            this.itemIcon = (ImageView) itemView.findViewById(R.id.item_icon);
            this.itemText = (TextView)itemView.findViewById(R.id.item_text);

        }
    }
}
