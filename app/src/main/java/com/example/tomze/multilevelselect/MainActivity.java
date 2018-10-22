package com.example.tomze.multilevelselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.caveman.listcheckbox.adapter.ListViewAdapter;
import com.caveman.listcheckbox.listener.OnTreeNodeCheckedChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ListView mLvMultiSelect;
    private ListViewAdapter mAdapter;
    private List<Item> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLvMultiSelect = findViewById(R.id.lv_select);
        mItems = new ArrayList<>();
        initData();
        mAdapter = new ListViewAdapter(mLvMultiSelect, this, mItems, 0,
                R.drawable.ic_check, R.drawable.ic_nor);

        mAdapter.setCheckedChangeListener(new OnTreeNodeCheckedChangeListener() {
            @Override
            public void onCheckChange(String id, String name, int position, boolean isChecked) {
                Log.d(TAG, "onCheckChange: " + name);
            }
        });

    }

    private void initData() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(0, -1, "菜单1"));
        items.add(new Item(1, -1, "菜单2"));
        items.add(new Item(2, -1, "菜单3"));
        items.add(new Item(3, -1, "菜单4"));

        items.add(new Item(4, 0, "菜单1-1"));
        items.add(new Item(5, 0, "菜单1-2"));
        items.add(new Item(6, 0, "菜单1-3"));
        items.add(new Item(7, 1, "菜单2-1"));

        mItems.addAll(items);
    }
}
