package com.android.pronetway.schoolnet.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.pronetway.schoolnet.R;
import com.android.pronetway.schoolnet.activity.DetailNewsActivity;
import com.android.pronetway.schoolnet.adapter.BaseAdapter;
import com.android.pronetway.schoolnet.adapter.BaseHolder;
import com.android.pronetway.schoolnet.adapter.ItemClickSupport;
import com.android.pronetway.schoolnet.adapter.MyNewsAdapter;
import com.android.pronetway.schoolnet.bean.Eimdata;
import com.android.pronetway.schoolnet.bean.GlideImageLoader;


import com.android.pronetway.schoolnet.bean.NewsBean;
import com.android.pronetway.schoolnet.bean.P;
import com.android.pronetway.schoolnet.utils.HttpUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Coleman on 2016/12/7.
 */
public class NewsFragment extends Fragment {

    String url = "http://192.168.20.154:8006/pronline/Msg?FunName@ict_school_indexNews&page=1&dir=1&start=1&type=&limit=10";
    private String position;
    private String TAG = "cole";
    private RecyclerView newsRecyclerView;
    Context context;
    private List<NewsBean.EimdataBean> mListNews;
    private List<Eimdata> mNewsBean = new ArrayList<>();
    List<String> mpicList = null;
    MyNewsAdapter newsAdapter;

    public static NewsFragment getInstance(String position) {
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.position = position;
        return newsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_news, null);
            newsRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_fragment_home_news);
            newsRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        Log.i(TAG, "=几次了————————————- ");
    }

    protected void initData() {
        getNetBean();
//        newsBean();
        Log.i(TAG, "out: 1111-");
    }

    private void newsBean() {
//        ItemClickSupport lisenter = null;
//        SingleAdapter   my = new SingleAdapter(mNewsBean,lisenter);
    }

    public void getNetBean() {
        Log.i(TAG, "CHttpUtils=- in__________");
        HttpUtils.get(url, new AsyncHttpResponseHandler() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                        Log.i(TAG, "onSuccess: 1111-" + responseBody.toString());
                        mNewsBean = paseNews(new String(responseBody).toString());
//                        Log.i(TAG, "=000000000000000000- " +  mNewsBean.size());
//                        Log.i(TAG, "=inadtapter    - " +  mNewsBean.size());
                        ItemClickSupport lisenter  = new ItemClickSupport(newsRecyclerView);
                        lisenter.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                            @Override
                            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                                Intent in  = new Intent(context, DetailNewsActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("news", mNewsBean.get(position));
                                in.putExtras(bundle);
//                                in.putExtra("news",mNewsBean.get(position));
                                startActivity(in);
                                Log.i(TAG, "onItemClicked: "+mNewsBean.get(position).toString());
                            }
                        });
                        final SingleAdapter   my = new SingleAdapter(mNewsBean,  lisenter);
                        newsRecyclerView.setAdapter(my);
                        Log.i(TAG, "onItemClicked: "+  my.toString());


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.i(TAG, "onFailure=- out__________");
                    }
                }
        );
        Log.i(TAG, "CHttpUtils=- out__________");
    }

    /**
     * @param st
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Eimdata> paseNews(String st) {
        List<Eimdata> mList = new ArrayList<>();
        try {
            JSONObject obj = new JSONObject(st);
            String status = obj.getString("result");
            JSONObject bean;
            Eimdata news;
            if (status.equals("0")) {
                JSONArray newsbean   = obj.getJSONArray("eimdata");
                for (int i = 0; i < newsbean.length(); i++) {
                    bean = (JSONObject) newsbean.get(i);
                    news = new Eimdata();
                    news.setId(bean.getString("id"));
                    news.setTitle(bean.getString("title"));
                    news.setPicpath(bean.getString("picpath"));
//                    mpicList.add(P.IP + P.PORT + bean.getString("picpath"));
                    news.setOrg(bean.getString("org"));
                    news.setContent(bean.getString("content"));
                    news.setView(bean.getString("view"));
                    news.setType(bean.getString("type"));
                    news.setTimeval(bean.getString("timeval"));
                    mList.add(news);
                }
                return mList;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mList;
    }


    private class SingleAdapter  extends  BaseAdapter<Eimdata, SingleHolder>  {
        /**
         * 设置数据,并设置点击回调接口
         *
         * @param list     数据集合
         * @param listener 回调接口
         */
        public SingleAdapter (@Nullable List list,  ItemClickSupport  listener) {
            super(list, listener);
//            Log.i(TAG, "list 回调接口 : "+ list.size());
        }


        @Override
        public SingleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.i(TAG, "onCreateViewHolder  viewType   : "+ viewType);
            return new SingleHolder(parent, R.layout.fragment_news_list);
        }

    }

    /**
     * 一种View的Holder
     *
     */
    public class SingleHolder extends BaseHolder<Eimdata> {
        TextView titleView;
        TextView timeView;
        TextView orgView;
        ImageView imgView;
        GlideImageLoader gil = new GlideImageLoader();
        public SingleHolder(ViewGroup parent, @LayoutRes int resId) {
            super(parent, resId);
            titleView = getView(R.id.tv_title_news);
            timeView = getView(R.id.tv_timeval_news);
            orgView = getView(R.id.tv_org_news);
            imgView = getView(R.id.iv_newslist);
        }

        @Override
        public void setData(Eimdata data) {
//            Log.i(TAG, "url__________img  : "+data.toString());
            titleView.setText(data.getTitle());
            timeView.setText(data.getTimeval().subSequence(0,10).toString() );
            orgView.setText( data.getOrg());
            if (data.getPicpath() != null) {
                String url = "https://www.baidu.com/img/bd_logo1.png";
                String igurl = P.HTTP+P.IP + P.PORT + data.getPicpath();

                Picasso.with(getActivity()).load(igurl).into(imgView); //fit,size都不适用,就是用自己的规则
//            gil.displayImage(context, "https://www.baidu.com/img/bd_logo1.png", imgView);
//                Log.i(TAG, "url__________img  : "+igurl);

           }else {
//                Log.i(TAG, " _img                    null          : ");
            }
        }
    }


}
