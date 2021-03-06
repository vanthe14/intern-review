package intership.dev.adaptor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import intership.dev.contact.MainActivity;
import intership.dev.contact.R;
import intership.dev.fragment.InfoUserFragment;
import intership.dev.fragment.MainFragment;
import intership.dev.modal.User;

/**
 * Created by The on 22/07/2015.
 */
public class Adaptor_User extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> mUser;
    public Adaptor_User(Context mContext, ArrayList<User> mUser) {
        this.mUser = mUser;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mUser.size();
    }

    @Override
    public User getItem(int position) {
        return mUser.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.custom_user, parent, false);
            holder = new ViewHolder();

            // init XML
            holder.mImgAvatar = (ImageView) convertView
                    .findViewById(R.id.img_user);
            holder.mTxtName = (TextView) convertView
                    .findViewById(R.id.tv_user);
            holder.mBtnEdit = (ImageButton) convertView.findViewById(R.id.imgBtn_edit);
            holder.mBtnDelete = (ImageButton) convertView.findViewById(R.id.imgBtn_delete);
            holder.mBtnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // mUser.remove(position);
                    //notifyDataSetChanged();
                    AlertDialog.Builder b=new AlertDialog.Builder(mContext);
                    b.setInverseBackgroundForced(false);
                    b.setTitle("Question");
                    b.setMessage("bạn có muốn xóa không?");
                    b.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }});
                    b.setNegativeButton("OK", new DialogInterface.OnClickListener() {

                        @Override

                        public void onClick(DialogInterface dialog, int which)

                        {
                            mUser.remove(position);
                            notifyDataSetChanged();
                        }

                    });
                    b.create().show();
                }
            });
            holder.mBtnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment_infouser = new InfoUserFragment(mUser, position);
                    FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
                    FragmentTransaction transaction= fragmentManager.beginTransaction();
                    transaction.replace(R.id.frame_main, fragment_infouser);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    notifyDataSetChanged();
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        setValue(holder, position);


        return convertView;
    }

    private static class ViewHolder {
        ImageView mImgAvatar;
        TextView mTxtName;
        ImageButton mBtnEdit;
        ImageButton mBtnDelete;
    }

    private void setValue(ViewHolder holder, int position) {
        final User user;
        user = getItem(position);
        holder.mImgAvatar.setImageResource(user.getmAvatar());
        holder.mTxtName.setText(user.getmName());
    }
}
