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
public class Org_committee extends Fragment implements View.OnClickListener{
    ListView org_list;
    ButtonRectangle close;
    String[] org_comm = {"Chief Organisers","Chief Organisers","Chief Organisers","Chief Organisers","General Secretory"};
    String[] names={"Person One","Person Two","Person Three","Person Four","Person Five"};
    Integer[] org_comm_pics={R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit,R.drawable.img_credit};


    public Org_committee() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_org_committee, container, false);
        org_list=(ListView)view.findViewById(R.id.org_list);
        close=(ButtonRectangle)view.findViewById(R.id.close);
        close.setOnClickListener(this);
        setLayout();
        return view;
    }
    public void setLayout(){
        org_list.setAdapter(new ListviewAdapter(getContext(),org_comm,names,org_comm_pics));

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.close){
            getChildFragmentManager().popBackStackImmediate();
        }
    }
}
