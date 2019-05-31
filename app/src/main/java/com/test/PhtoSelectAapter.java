package com.test;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PhtoSelectAapter extends BaseQuickAdapter<DataEntity, BaseViewHolder> {
    private Set<Integer> checkStatus;//保证元素不重复
    //控制是否显示Checkbox。true 显示 false 隐藏
    private boolean showCheckBox = false;
    //显示checkbox
    public void setShowCheckBox(boolean showCheckBox) {
        this.showCheckBox = showCheckBox;
    }
    //设置选中状态
    public void setCheckStatus(int pos){
        checkStatus.add(pos);
    }
    //
    public boolean getShowCheckBox(){return showCheckBox;}
    //取消选中
    public void removeCheckBoxStuaus(int pos){
        if (checkStatus.contains(pos)){
            checkStatus.remove(pos);
        }
    }

    public PhtoSelectAapter(@Nullable List<DataEntity> data) {
        super(R.layout.item_muiltselect, data);
        checkStatus = new HashSet<>();
    }


   @Override
    protected void convert(final BaseViewHolder helper, DataEntity item) {
        ImageView imageView = helper.itemView.findViewById(R.id.img);
        Glide.with(mContext).load(R.mipmap.imgv_fitness_girl).into(imageView);
        helper.setVisible(R.id.cb,showCheckBox);//初次进入，隐藏checkbox
        CheckBox checkBox = helper.itemView.findViewById(R.id.cb);
        //当前进入选中状态，且当前item是被选中
        //getLayoutPosition获取当前item的position
        //boolean contains(Object o);判断集合中是否存在某个元素
        if (showCheckBox && checkStatus.contains( helper.getLayoutPosition())){
            checkBox.setChecked(true);//勾选
        }else {
            checkBox.setChecked(false);//不勾选
        }


    }

}
