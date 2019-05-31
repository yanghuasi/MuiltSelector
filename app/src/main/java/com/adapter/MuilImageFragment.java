package com.adapter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.test.R;

import java.util.ArrayList;
import java.util.List;

public class MuilImageFragment extends Fragment {
    /**
     * 网格布局的　Recyclerview
     */
    private RecyclerView mRcv;
    /**
     * 显示所保存数据的按钮
     */
    private Button mBtn;
    /**
     * recyclerview 的适配器
     */
    private RecAdapter adapter;
    /**
     * 实际开发中用来保存联网获取的图片数据
     */
    private List<String> list;
    /**
     * 是否显示ｃｈｅｃｋｂｏｘ
     */
    private boolean isShowCheck;
    /**
     * 记录选中的ｃｈｅｃｋｂｏｘ
     */
    private List<String> checkList;
    /**
     * 屏幕宽度
     */
    private int screenWidth;
    private CheckBox checkBox;
    public static MuilImageFragment newInstance() {
        Bundle bundle = new Bundle();
        MuilImageFragment filesFragment = new MuilImageFragment();
//        bundle.putString("path", imgpath);
//        bundle.putString("name", name);
////        Bitmap bm = BitmapFactory.decodeFile(imgpath);
//        filesFragment.setArguments(bundle);
        return filesFragment;

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_photo, null);
        //view.findViewById();
        mBtn = (Button) view.findViewById(R.id.btn);
        mRcv = (RecyclerView) view.findViewById(R.id.rcv);
        initData();
        adapter = new RecAdapter( getActivity(),list,screenWidth);
        mRcv.setAdapter(adapter);
        mRcv.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        initListener();
        return view;

    }

    /**
     * 点击监听
     */
    private void initListener() {
        //button的点击
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), checkList.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //ａｄａｐｔｅｒ中定义的监听事件　可以根据isShowCheck判断当前状态，设置点击Ｉｔｅｍ之后是查看大图（未实现　跳到下一个Ａｃｔｉｖｉｔｙ即可）还是选中ｃｈｅｃｋｂｏｘ*/

        adapter.setOnItemClickListener(new RecAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (checkList.contains(String.valueOf(position))) {
                    checkList.remove(String.valueOf(position));
                } else {
                    checkList.add(String.valueOf(position));
                }
                Toast.makeText(getActivity(), "点击了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onLongClick(View view, int position) {
                if (isShowCheck) {
                    mBtn.setVisibility(View.GONE);
                    adapter.setShowCheckBox(false);
                    refreshUI();
                    checkList.clear();
                } else {
                    adapter.setShowCheckBox(true);
                    refreshUI();
                    mBtn.setVisibility(View.VISIBLE);
                }
                isShowCheck = !isShowCheck;
                Toast.makeText(getActivity(), "长按了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
                return false;
            }
        });




    }

    /**
     * 适配器
     */
    private void refreshUI() {
        if (adapter == null) {
            adapter = new RecAdapter( getActivity(),list,screenWidth);
            mRcv.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        list = new ArrayList<>();
        checkList = new ArrayList<>();
        list.add("16");
        //屏幕宽度
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
    }


}