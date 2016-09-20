package qianfeng.com.fragment_ceshi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list;

    public BlankFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        initData();
        return view;
    }

    private void initData(){
        list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("田七");
        list.add("王八");
        List<MyFargment> myfragment = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            myfragment.add(MyFargment.newInstance(list.get(i)));
        }
        BlankFragmentAdapter a = new BlankFragmentAdapter(myfragment, list, getChildFragmentManager(), getContext());
        viewPager.setAdapter(a);
        tabLayout.setupWithViewPager(viewPager);
    }
}