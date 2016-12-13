package com.android.pronetway.schoolnet.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.bean.P;
import com.android.pronetway.schoolnet.bean.SchoolLife;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coleman on 2016/12/12.
 */
public class SchoolPictureAdapter extends android.widget.BaseAdapter  {

    private LayoutInflater inflater;
    private List<SchoolLife.EimdataBean> pictures;

    Context mContext;
    public SchoolPictureAdapter(List<SchoolLife.EimdataBean> pictures ) {
        super();

        pictures = new ArrayList<>();
        this.pictures = pictures;
    }

    @Override
    public int getCount() {
        return pictures==null?0:pictures.size();

    }

    @Override
    public Object getItem(int position) {
        return pictures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.picture_item, null);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.tv_title_school_life);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.iv_school_life);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(pictures.get(position).getTitle());
        Log.i("cole_adapter", "getView:url_____________ "+pictures.get(position).getTitle().toString());
//        String igurl = P.HTTP + P.IP + P.PORT + pictures.get(position);
//        Picasso.with(mContext).load(igurl).into(viewHolder.image); //fit,size都不适用,就是用自己的规则
//        Log.i("cole_adapter", "getView:url_____________ "+igurl.toString());
//        if (pictures.get(position).getPicpath() != null) {
//            String igurl = P.HTTP + P.IP + P.PORT + pictures.get(position);
//            Picasso.with(mContext).load(igurl).into(viewHolder.image); //fit,size都不适用,就是用自己的规则
////            viewHolder.image.setImageResource(Integer.parseInt(pictures.get(position).getPicpath()));
//        }
        return convertView;
    }

    class ViewHolder {
        public TextView title;
        public ImageView image;
    }
}
