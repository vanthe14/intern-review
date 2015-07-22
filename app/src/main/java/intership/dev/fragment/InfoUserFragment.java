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
import android.widget.TextView;

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

    public InfoUserFragment(ArrayList<User> user, int positon) {
        this.mUser = user;
        mposition = positon;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info_user, container, false);
        final TextView txt = (TextView) v.findViewById(R.id.tv_name);
        txt.setText(mUser.get(mposition).getmName());
        edt_name = (EditText) v.findViewById(R.id.edt_name);
        edt_name.setText(mUser.get(mposition).getmName());
        edt_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt.setText(s);
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
                mUser.get(mposition).setmName(name);
                Fragment fragment_main = new MainFragment(mUser);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main, fragment_main);
                fragmentTransaction.commit();

            }
        });
        ImageButton imgBtn_Back = (ImageButton) v.findViewById(R.id.imgBtn_back);
        imgBtn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment_main = new MainFragment(mUser);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main, fragment_main);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}
