package intership.dev.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import intership.dev.adaptor.Adaptor_User;
import intership.dev.contact.R;
import intership.dev.modal.User;

/**
 * Created by The on 22/07/2015.
 */
public class MainFragment extends Fragment {
    ArrayList<User> mArraylist = new ArrayList<User>();
    Adaptor_User adt_user;
    ListView lv_user;
    ProgressBar progressBar;
    public MainFragment(ArrayList<User> arr) {
        this.mArraylist = arr;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        adt_user = new Adaptor_User(getActivity(), mArraylist);
        adt_user.notifyDataSetChanged();
        progressBar=(ProgressBar)v.findViewById(R.id.progesbar_load);
        lv_user = (ListView) v.findViewById(R.id.lv_user);
        lv_user.setAdapter(adt_user);
        lv_user.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount){
            }
        });
        return v;
    }
}
