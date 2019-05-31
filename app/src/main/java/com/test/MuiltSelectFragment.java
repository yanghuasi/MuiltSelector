package com.test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;


public class MuiltSelectFragment extends Fragment {
    private RecyclerView mRcv;
    private Button mBtn;
    private CheckBox all;
    private PhtoSelectAapter mPhotoSeletorAdapter;
    private List<String> list;

    /**
     * 记录选中的ｃｈｅｃｋｂｏｘ
     */
    private List<String> checkList;

    private List<DataEntity> entities;
    public static MuiltSelectFragment newInstance() {
        Bundle bundle = new Bundle();
        MuiltSelectFragment filesFragment = new MuiltSelectFragment();
        return filesFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_photo, null);
        //view.findViewById();
        mBtn = (Button) view.findViewById(R.id.btn);
        mRcv = (RecyclerView) view.findViewById(R.id.rcv);
        all = view.findViewById(R.id.all);
        checkList = new ArrayList<>();

        entities = new ArrayList<> ();
        DataEntity newEntity = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963681&di=e7247350673c1e4dca62862ee9c3368b&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F0%2F53b4b747b9094.jpg");
        DataEntity newEntity1 = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963681&di=47f5c7a5dfcec7a144dabf36f04b3a8d&imgtype=0&src=http%3A%2F%2Fwww.znsfagri.com%2Fuploadfile%2Feditor%2Fimage%2F20170626%2F20170626151136_11631.jpg");
        DataEntity newEntity2 = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963680&di=e574b93a7e706f5bb8463b2adac00959&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201501%2F02%2F20150102204647_dj2t8.jpeg");
        DataEntity newEntity3 = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963679&di=94b173763aa94c330fe8168f8fd63d78&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201505%2F06%2F20150506112813_skniy.jpeg");
        DataEntity newEntity4 = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963679&di=3ebaa5dac1253587243605900ee1c114&imgtype=0&src=http%3A%2F%2Fimg0.ph.126.net%2FoM3Ux_qm9BNW6fp1HxJ8_Q%3D%3D%2F1687723960457254251.jpg");
        DataEntity newEntity5 = new DataEntity ( "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542721963678&di=c0b6cf83e73f0d587671ac2cfe74d9fd&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201409%2F15%2F20140915215605_WZwQW.jpeg");

        entities.add (newEntity);
        entities.add (newEntity1);
        entities.add (newEntity2);
        entities.add (newEntity3);
        entities.add (newEntity4);
        entities.add (newEntity5);
        mPhotoSeletorAdapter = new PhtoSelectAapter(entities);

        mRcv.setAdapter(mPhotoSeletorAdapter);
        mRcv .setLayoutManager(new GridLayoutManager(getActivity(),5));
        //点击
//        all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPhotoSeletorAdapter.setAllCheckBox(true);
//                mPhotoSeletorAdapter.notifyDataSetChanged();//刷新
//            }
//        });
        mPhotoSeletorAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d("ADAPTER","0");
                Toast.makeText(getActivity(), "点击了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
                if (checkList.contains(String.valueOf(position))) {
                    checkList.remove(String.valueOf(position));
                    //觉得难看不想选择则移除，取消选中框选中状态
                    mPhotoSeletorAdapter.removeCheckBoxStuaus(position);
                } else {
                    checkList.add(String.valueOf(position));
                    //position就刷新第几个的checkbox的选中状态
                    mPhotoSeletorAdapter.setCheckStatus(position);
                }
                //只刷新点击的那一条记录
                mPhotoSeletorAdapter.notifyItemChanged(position);

            }
        });

        mPhotoSeletorAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                mPhotoSeletorAdapter.setShowCheckBox(true);//长按Item出现勾选框checkbox
                all.setVisibility(View.VISIBLE);
                mPhotoSeletorAdapter.notifyDataSetChanged();//刷新
                return false;
            }
        });


        return view;


    }




}