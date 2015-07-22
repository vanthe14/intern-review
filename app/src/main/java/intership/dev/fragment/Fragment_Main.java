package intership.dev.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import intership.dev.adaptor.Adaptor_User;
import intership.dev.contact.R;
import intership.dev.modal.User;

/**
 * Created by The on 22/07/2015.
 */
public class Fragment_Main extends Fragment {
    ArrayList<User> mArraylist=new ArrayList<User>();
    Adaptor_User adt_user;
    ListView lv_user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        for(int i=1;i<3;i++)
        {
            User user=new User();
            user.setmAvatar(R.drawable.test);
            user.setmName("asfasfaf" + i);
            user.setmCheck(R.drawable.ic_check);
            mArraylist.add(user);
        }
        adt_user=new Adaptor_User(getActivity(),mArraylist);
        lv_user=(ListView)v.findViewById(R.id.lv_user);
        lv_user.setAdapter(adt_user);
        return v;
    }
}
