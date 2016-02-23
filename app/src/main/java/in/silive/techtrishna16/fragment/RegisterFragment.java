package in.silive.techtrishna16.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.gc.materialdesign.views.CheckBox;

import com.gc.materialdesign.views.ButtonRectangle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

import in.silive.techtrishna16.Control.Config;
import in.silive.techtrishna16.Control.FetchData;
import in.silive.techtrishna16.Listeners.FetchDataListener;
import in.silive.techtrishna16.Listeners.RegisterListener;
import in.silive.techtrishna16.R;
import in.silive.techtrishna16.Control.Validation;

/**
 * Created by H.P on 1/22/2016.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener, FetchDataListener, RegisterListener {
    Spinner list_college, st_branch, st_year;
    EditText akg_st_no, st_name, st_mail, st_contact, st_paswrd, st_cpaswrd;
    TextInputLayout st_no_visibility;
    RadioGroup st_gender;
    RadioButton st_male, st_female;
    CheckBox st_tshirt;
    ButtonRectangle reg_new_accnt;
    String sCollege, sBranch, sYear, stNO, sName, sMail, sContact, sPaswrd, sCpaswrd;
    Integer sCollegeId;
    ArrayList<String> list_of_colleges = new ArrayList<>();
    ArrayAdapter<String> collegeListAdapter;
    int flag = 0;//flag for Register dialog
    TextView stno_err, name_err, phone_err, email_err, paswrd_err;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
        view = inflater.inflate(R.layout.register, container, false);
        list_college = (Spinner) view.findViewById(R.id.list_college);
        list_college.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    akg_st_no.setVisibility(View.VISIBLE);
                    st_no_visibility.setVisibility(View.VISIBLE);

                } else {
                    akg_st_no.setVisibility(View.INVISIBLE);
                    st_no_visibility.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        st_branch = (Spinner) view.findViewById(R.id.st_branch);
        st_year = (Spinner) view.findViewById(R.id.st_year);
        akg_st_no = (EditText) view.findViewById(R.id.akg_st_no);
        st_no_visibility = (TextInputLayout) view.findViewById(R.id.st_no_visibility);
        st_name = (EditText) view.findViewById(R.id.st_name);
        st_mail = (EditText) view.findViewById(R.id.st_mail);
        st_contact = (EditText) view.findViewById(R.id.st_contact);
        st_paswrd = (EditText) view.findViewById(R.id.st_paswrd);
        st_cpaswrd = (EditText) view.findViewById(R.id.st_cpaswrd);
        st_gender = (RadioGroup) view.findViewById(R.id.st_gender);
        st_male = (RadioButton) view.findViewById(R.id.st_male);
        st_female = (RadioButton) view.findViewById(R.id.st_female);
        st_tshirt = (CheckBox) view.findViewById(R.id.st_tshirt);
        reg_new_accnt = (ButtonRectangle) view.findViewById(R.id.reg_new_accnt);
        reg_new_accnt.setOnClickListener(this);
        collegeListAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list_of_colleges);
        list_college.setAdapter(collegeListAdapter);
        stno_err = (TextView) view.findViewById(R.id.stno_err);
        name_err = (TextView) view.findViewById(R.id.name_err);
        phone_err = (TextView) view.findViewById(R.id.phone_err);
        paswrd_err = (TextView) view.findViewById(R.id.paswrd_err);
        email_err = (TextView) view.findViewById(R.id.email_err);
        new FetchData(FetchData.GetCollegeList, this, Config.GET_METHOD).execute();
        return view;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.reg_new_accnt:
                getData();
                showDialog();
                break;


        }

    }


    @Override
    public void preRequest() {

    }

    @Override
    public void postRequest(String res) {
        try {
            JSONArray college_list = new JSONArray(res);
            for (int i = 0; i < college_list.length(); i++) {
                JSONObject college = college_list.getJSONObject(i);
                list_of_colleges.add(college.getString("CollegeName"));

            }
            collegeListAdapter.notifyDataSetChanged();
        } catch (Exception e) {

        }


    }


    @Override
    public void getData() {

        sCollege = list_college.getSelectedItem().toString();
        sCollegeId = list_college.getSelectedItemPosition() + 1;
        sBranch = st_branch.getSelectedItem().toString();
        sYear = st_year.getSelectedItem().toString();

        sName = st_name.getText().toString();
        if ((!((sName.contains(".")) || (sName.contains("'"))) || (sName.length() <= 2))||(sName.length()==0))
            name_err.setVisibility(View.VISIBLE);
        name_err.setError("Invalid Name");


        stNO = akg_st_no.getText().toString();


        if ((stNO.startsWith("16")) || (stNO.length() < 7)) {
            if (!((stNO.length() == 8) && (stNO.endsWith("d")))) {
                stno_err.setVisibility(View.VISIBLE);
                stno_err.setError("Invalid Student Number");
            }
            stno_err.setVisibility(View.VISIBLE);
            stno_err.setError("Invalid Student Number");
            flag = 1;
        }

        sMail = st_mail.getText().toString();
        if (!(Pattern.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$", sMail))) {
            email_err.setVisibility(View.VISIBLE);
            email_err.setError("Invalid E-mail address");
            flag = 1;
        }
        Validation evalidation = new Validation(this, sMail);
        evalidation.execute();


        sContact = st_contact.getText().toString();

        if (!(sContact.startsWith("9") || sContact.startsWith("8") || sContact.startsWith("7"))) {
            phone_err.setVisibility(View.VISIBLE);
            phone_err.setError("Invalid Contact Number");
            flag = 1;
        }
        Validation cvalidation = new Validation(this, sContact);
        cvalidation.execute();


        sPaswrd = st_paswrd.getText().toString();
        sCpaswrd = st_cpaswrd.getText().toString();
        if ((!(sCpaswrd.equals(sPaswrd)))||(sPaswrd.length()==0)) {
            paswrd_err.setVisibility(View.VISIBLE);
            paswrd_err.setError("Passwords do not match");
            flag = 1;
        }


    }

    @Override
    public void showDialog() {
        if (flag == 1) {
            RDialog Rdialog = new RDialog();
            Rdialog.show(getFragmentManager(), "Invalid Student Number");

        } else
            Toast.makeText(getContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showmDialog() {
        EmailAlrdyRegFrag emailAlrdyRegFrag = new EmailAlrdyRegFrag();
        emailAlrdyRegFrag.show(getFragmentManager(), "Already Registerd Mail");

    }

    @Override
    public void showcDialog() {
        PhoneAlrdyReg phoneAlrdyReg = new PhoneAlrdyReg();
        phoneAlrdyReg.show(getFragmentManager(), "Already Registered Phone number");
    }

    @Override
    public void mail_phone_chk(Map m) {
        if (m.get("E-mail") == "true") {
            showmDialog();
        }
        if (m.get("Phone_no") == "true") {
            showcDialog();
        }

    }
}
