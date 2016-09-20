package qianfeng.com.fragment_ceshi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by liujie on 2016/7/2.
 */
public class MyFargment extends Fragment{

    private TextView tv;

    public static MyFargment newInstance(String title){
        MyFargment fragment = new MyFargment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.one, null);
        tv = (TextView) view.findViewById(R.id.tv);
     if(getArguments().getString("title").equals("王五")){
         tv.setText("dsada");
     }
        return view;
    }

}
