package in.silive.techtrishna16.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonRectangle;

import java.util.regex.Pattern;

import in.silive.techtrishna16.R;
import in.silive.techtrishna16.fragment.RDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuerryUs extends Fragment implements View.OnClickListener{
    EditText querry_mail,querry;
    String qMail,qQues;
    ButtonRectangle submit;



    public QuerryUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_querry_us, container, false);
        querry_mail=(EditText)view.findViewById(R.id.querry_mail);
        querry=(EditText)view.findViewById(R.id.querry);
        submit=(ButtonRectangle)view.findViewById(R.id.submit);
        submit.setOnClickListener(this);
        //getQuerry();

        return view;
    }
    public void getQuerry(){
        qMail=querry_mail.getText().toString();
        if (!(Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$", qMail)))
        {
            RDialog Rdialog=new RDialog();
            Rdialog.show(getFragmentManager(),"Invalid E-mail");
        }
        qQues=querry.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.submit){

        }
    }
}
