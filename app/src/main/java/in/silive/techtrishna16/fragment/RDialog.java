package in.silive.techtrishna16.fragment;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;

import in.silive.techtrishna16.R;

/**
 * Created by H.P on 1/24/2016.
 */
public class RDialog extends DialogFragment implements View.OnClickListener {
    ButtonRectangle ok;
    TextView text_re_enter;

    public RDialog() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);
        View view=inflater.inflate(R.layout.dialog_reg,container,false);
        ok=(ButtonRectangle)view.findViewById(R.id.ok);
        ok.setOnClickListener(this);
        text_re_enter=(TextView)view.findViewById(R.id.text_re_enter);


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.ok){
            dismiss();
        }

    }
}
