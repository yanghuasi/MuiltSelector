package com.test;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login;
    public static FragmentChanger fragmentChanger;//Fragment切换接口实现
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        getFragmentManager()    //
                .beginTransaction()
                .add(R.id.fragment_container,new OutSideFragment())   // 此处的R.id.fragment_container是要盛放fragment的父容器
                .commit();
//        btn=(Button)findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //显示选择相册的dialog
//                MultiImageDialogFragment editNameDialogFragment = MultiImageDialogFragment.newInstance("名字");
//                editNameDialogFragment.show(getSupportFragmentManager(), "edit");
//            }
//        });
    }
    public interface FragmentChanger {
        void changeFragment(Fragment fragment);
    }

}
