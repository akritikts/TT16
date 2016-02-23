package in.silive.techtrishna16.fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.gc.materialdesign.views.*;

import in.silive.techtrishna16.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment implements View.OnClickListener {
    ButtonRectangle thumb_button_2, thumb_button_1;

    Fragment fragment;


    public ContactUs() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.contactus, container, false);
        thumb_button_1 = (ButtonRectangle) view.findViewById(R.id.thumb_button_1);
        thumb_button_1.setOnClickListener(this);
        thumb_button_2 = (ButtonRectangle) view.findViewById(R.id.thumb_button_2);
        thumb_button_2.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.thumb_button_1:
                fragment= new Org_committee();
                break;
            case R.id.thumb_button_2:
                fragment = new Credits();



        }
        FragmentTransaction cft = getFragmentManager().beginTransaction();
        cft.replace(R.id.content_frame,fragment);
        cft.addToBackStack(null);
        cft.commit();

    }
}
