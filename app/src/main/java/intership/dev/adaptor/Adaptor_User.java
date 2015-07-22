package intership.dev.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import intership.dev.contact.R;
import intership.dev.modal.User;

/**
 * Created by The on 22/07/2015.
 */
public class Adaptor_User extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> mUser;

    public Adaptor_User(Context mContext,ArrayList<User> mUser) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
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
            holder.mImgBtnCheck = (ImageButton) convertView
                    .findViewById(R.id.imgBtn_back);
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
        ImageButton mImgBtnCheck;
    }

    private void setValue(ViewHolder holder, int position) {
        final User user;
        user = getItem(position);
        holder.mImgAvatar.setImageResource(user.getmAvatar());
        holder.mTxtName.setText(user.getmName());
        holder.mImgBtnCheck.setImageResource(user.getmCheck());

    }
}
