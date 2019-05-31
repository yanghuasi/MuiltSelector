package com.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class OutSideFragment extends Fragment {
    private Button btn;
    private ImageView show;
    RecyclerView recyclerView;


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate( R.layout.fragment_outside, null );
            //view.findViewById();
            btn = (Button) view.findViewById (R.id.btn);
            show=(ImageView)view.findViewById(R.id.show);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取fragment的实例
                    MuiltSelectFragment fragment=new MuiltSelectFragment();
                    //获取Fragment的管理器
                    FragmentManager fragmentManager=getFragmentManager();
                    //开启fragment的事物,在这个对象里进行fragment的增删替换等操作。
                    FragmentTransaction ft=fragmentManager.beginTransaction();
                    //跳转到fragment，第一个参数为所要替换的位置id，第二个参数是替换后的fragment
                    ft.replace(R.id.container,fragment);
                    //提交事物
                    ft.commit();

                }
            });
            return view;
        }


    }


