package intership.dev.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import intership.dev.adaptor.Adaptor_User;
import intership.dev.contact.R;
import intership.dev.modal.User;

/**
 * Created by The on 22/07/2015.
 */
public class InfoUserFragment extends Fragment {
    ArrayList<User> mUser;
    int mposition;
    EditText edt_name;
    EditText edt_Description;

    public InfoUserFragment(ArrayList<User> user, int positon) {
        this.mUser = user;
        mposition = positon;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_user, container, false);
        final TextView tv_name = (TextView) v.findViewById(R.id.tv_name);
        ImageView img_avatar=(ImageView)v.findViewById(R.id.img_avatar);
        final EditText edt_Description=(EditText)v.findViewById(R.id.edt_Description);
        tv_name.setText(mUser.get(mposition).getmName());
        img_avatar.setImageResource(mUser.get(mposition).getmAvatar());
        edt_Description.setText(mUser.get(mposition).getmDescripton());
        edt_name = (EditText) v.findViewById(R.id.edt_name);
        edt_name.setText(mUser.get(mposition).getmName());
        edt_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_name.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button btn_Save = (Button) v.findViewById(R.id.btn_Save);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edt_name.getText().toString();
                String Description = edt_Description.getText().toString();
                mUser.get(mposition).setmName(name);
                mUser.get(mposition).setmDescripton(Description);
                getActivity().onBackPressed();

            }
        });
        Button btn_Cancel=(Button) v.findViewById(R.id.btn_Cancel);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        ImageButton imgBtn_Back = (ImageButton) v.findViewById(R.id.imgBtn_back);
        imgBtn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        return v;
    }

}
