# MultiLevelSelect
多级选择控件，支持：单级单选，单级多选，多级单选，多级多选等

## 使用说明
### 依赖
在app/build.gradle中添加:
```
dependencies {
    implementation 'com.github.Tomzem:MultiLevelSelect:1.0.0'
}
```
还需要在Project的build.gradle中添加:
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

## 调用
在activity_main.xml中只用写一个listView，其余什么都不需要：
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ListView
        android:id="@+id/lv_select"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</android.support.constraint.ConstraintLayout>
```
在java中，和正常的使用Adapter一样（默认情况多级多选）：
```
        mLvMultiSelect = findViewById(R.id.lv_select);

        mItems = new ArrayList<>();
        initData();
				
        mAdapter = new ListViewAdapter(mLvMultiSelect, this, mItems, 0);
        mLvMultiSelect.setAdapter(mAdapter);
	//点击选中监听
        mAdapter.setCheckedChangeListener(new OnTreeNodeCheckedChangeListener() {
            @Override
            public void onCheckChange(String id, String name, int position, boolean isChecked) {
                Log.d(TAG, "onCheckChange: " + name);
                List<Node> selectedNode = mAdapter.getSelectedNode();
                for (Node node : selectedNode){
                    Log.d(TAG, "selectedNode: " + node.getId());
                }
            }
        });

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
        items.add(new Item(8, 1, "菜单2-2"));
        items.add(new Item(9, 1, "菜单2-3"));

        items.add(new Item(10, 2, "菜单3-1"));
        items.add(new Item(11, 2, "菜单3-2"));
        items.add(new Item(12, 2, "菜单3-3"));

        items.add(new Item(14, 3, "菜单4-1"));
        items.add(new Item(15, 3, "菜单4-2"));
        items.add(new Item(16, 3, "菜单4-3"));

        mItems.addAll(items);
    }
}
```
## 实际效果
![](https://github.com/Tomzem/MultiLevelSelect/blob/master/Image/20181023-1451-52.png?raw=true)  
