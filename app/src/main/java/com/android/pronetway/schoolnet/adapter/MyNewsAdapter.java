package com.android.pronetway.schoolnet.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.bean.BaseBean;
import com.android.pronetway.schoolnet.bean.Eimdata;
import com.android.pronetway.schoolnet.bean.GlideImageLoader;
import com.android.pronetway.schoolnet.bean.P;

import java.util.List;

/**
 * Created by Coleman on 2016/12/8.
 */
public class MyNewsAdapter extends  BaseRecycleAdapter {
    final GlideImageLoader gil = new GlideImageLoader();
    Context mContext;
    private ImageView iv;

    /**
     * @param context  //上下文
     * @param layoutId //布局id
     * @param data     //数据源
     */
    public MyNewsAdapter(Context context, int layoutId, List<Eimdata> data) {
        super(context, R.layout.fragment_news_list, data);
        mContext = context;
    }

    public MyNewsAdapter(Context context, List<Eimdata> mNewsBean) {

        super(context,  mNewsBean);
        mContext = context;
    }

    @Override
    protected <T extends BaseBean> void convert(BaseViewHolder holder, BaseBean bean) {
        Eimdata news  = (Eimdata) bean;
        holder.setText(R.id.tv_title_news, news.getTitle());
        holder.setText(R.id.tv_org_news, news.getOrg());
        holder.setText(R.id.tv_timeval_news, news.getTimeval().subSequence(0,10).toString());
//        iv = ((ImageView) holder.itemView.findViewById(R.id.iv_newslist));
//        if (news.getPicpath() != null) {
//            gil.displayImage(mContext, P.IP + P.PORT + news.getPicpath(), iv);
//        }
        Log.i("cole_in", "convert: ____________");
    }
}
