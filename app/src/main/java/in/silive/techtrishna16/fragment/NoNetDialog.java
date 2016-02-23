package in.silive.techtrishna16.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;

import in.silive.techtrishna16.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoNetDialog extends DialogFragment implements View.OnClickListener{
    TextView nonet;
    ButtonRectangle ok;



    public NoNetDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setCancelable(false);
        View view=inflater.inflate(R.layout.fragment_no_net_dialog, container, false);
        nonet =(TextView)view.findViewById(R.id.nonet);
        ok=(ButtonRectangle)view.findViewById(R.id.ok);
        ok.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.ok){
            dismiss();

        }

    }
}
