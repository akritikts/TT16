package in.silive.techtrishna16.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.gc.materialdesign.views.ButtonRectangle;

import in.silive.techtrishna16.Adapter.ListviewAdapter;
import in.silive.techtrishna16.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Credits extends Fragment implements View.OnClickListener {
    ListView credits_list;
    ButtonRectangle close;
    String[] credit_devlprs = {"Developer Team","Developer Team","Developer Team","Developer Team","Developer Team"};
    String[] names={"Person One","Person Two","Person Three","Person Four","Person Five"};
    Integer[] credits_pics={R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit};


    public Credits() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_credits, container, false);
        credits_list=(ListView)view.findViewById(R.id.credits_list);
        close=(ButtonRectangle)view.findViewById(R.id.close);
        close.setOnClickListener(this);
        setLayout();
        return view;
    }
    public void setLayout(){
        credits_list.setAdapter(new ListviewAdapter(getContext(), credit_devlprs, names, credits_pics));

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.close){
            getChildFragmentManager().popBackStackImmediate();

        }
    }
}
