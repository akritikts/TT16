package in.silive.techtrishna16.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;

import in.silive.techtrishna16.Adapter.EventAdapter;
import in.silive.techtrishna16.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Events extends Fragment {
    ListView event_list;
    String[] name_of_events = {"Event One", "Event Two", "Event Three", "Event Four", "Event Five", "Event One", "Event Two", "Event Three", "Event Four", "Event Five", "Event One", "Event Two", "Event Three", "Event Four", "Event Five", "Event One", "Event Two", "Event Three", "Event Four", "Event Five", "Event One", "Event Two", "Event Three", "Event Four", "Event Five"};
    Integer[] images_of_events = {R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code, R.drawable.code};


    public Events() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        event_list = (ListView) view.findViewById(R.id.event_list);
        event_list.setAdapter(new EventAdapter(getContext(), name_of_events, images_of_events));
        EventAdapter custom_adapter = new EventAdapter(getContext(), name_of_events, images_of_events);
        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(custom_adapter);
        swingBottomInAnimationAdapter.setAbsListView(event_list);
        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(custom_adapter);
        animationAdapter.setAbsListView(event_list);
        event_list.setAdapter(animationAdapter);
//        assert swingBottomInAnimationAdapter.getViewAnimator()!=null;
        try {
            if (swingBottomInAnimationAdapter.getViewAnimator() != null)
                swingBottomInAnimationAdapter.getViewAnimator().setInitialDelayMillis(1900);
            event_list.setAdapter(swingBottomInAnimationAdapter);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Null received", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return view;
    }

}
