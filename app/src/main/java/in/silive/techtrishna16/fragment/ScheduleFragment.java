package in.silive.techtrishna16.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.silive.techtrishna16.Adapter.ScheduleAdapter;
import in.silive.techtrishna16.Adapter.ScheduleDay1Adapter;
import in.silive.techtrishna16.CustomViews.CustomTimelineView;
import in.silive.techtrishna16.Listeners.ScheduleTouchListener;
import in.silive.techtrishna16.R;

public class ScheduleFragment extends Fragment implements ScheduleTouchListener, View.OnClickListener {
    View scheduleFirstDay, scheduleCenter;
    RecyclerView timeLine, firstDayList;
    Boolean timelineVisible = true;
    ImageView showTimeline;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_schedule_center, container, false);
        scheduleFirstDay = view.findViewById(R.id.scheduleFirstDay);
        scheduleCenter = view.findViewById(R.id.scheduleCenter);
        timeLine = (RecyclerView) view.findViewById(R.id.timeline);
        firstDayList = (RecyclerView) view.findViewById(R.id.listFirstDay);
        showTimeline = (ImageView) view.findViewById(R.id.showTimeline);
        showTimeline.setOnClickListener(this);
        ArrayList<String> s = new ArrayList<>();
        s.add("asd");
        s.add("asdsgf");
        s.add("asdsgf");
        s.add("asdsgf");
        s.add("asdsgf");
        s.add("asdsgf");
        ScheduleAdapter adapter = new ScheduleAdapter(getContext(), s);
        timeLine.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        timeLine.addOnItemTouchListener(new RecyclerTouchListener(this));
        timeLine.setAdapter(adapter);
        timeLine.setLayoutFrozen(false);
        ScheduleDay1Adapter day1Adapter = new ScheduleDay1Adapter(getContext(), s);
        firstDayList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        firstDayList.setAdapter(day1Adapter);

        return view;
    }

    @Override
    public void postTouch(int postition) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int px = (int) ((300 * displayMetrics.density) + 0.5);
        if (!timelineVisible) {
            scheduleFirstDay.animate().translationXBy(-px).setDuration(300).start();
            timeLine.animate().translationXBy(-px).setDuration(300).start();
            timelineVisible = true;
            timeLine.setLayoutFrozen(false);
        } else {
            switch (postition) {
                case 1:
                    scheduleFirstDay.animate().translationX(px).setDuration(300).start();
                    timeLine.animate().translationX(px).setDuration(300).start();
                    timelineVisible = false;
                    timeLine.setLayoutFrozen(true);
                    break;
            }
        }

    }

    @Override
    public void onClick(View v) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int px = (int) ((300 * displayMetrics.density) + 0.5);
        switch (v.getId()) {
            case R.id.showTimeline:
                scheduleFirstDay.animate().translationXBy(-px).setDuration(300).start();
                timeLine.animate().translationXBy(-px).setDuration(300).start();
                timelineVisible = true;
                timeLine.setLayoutFrozen(false);
                break;
        }
    }

    class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        ScheduleTouchListener listener;
        GestureDetector gestureDetector;

        public RecyclerTouchListener(ScheduleTouchListener listener) {
            this.listener = listener;
            gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }


        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View view = rv.findChildViewUnder(e.getX(), e.getY());
            if (view != null && gestureDetector.onTouchEvent(e)) {
                listener.postTouch(rv.getChildAdapterPosition(view));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
