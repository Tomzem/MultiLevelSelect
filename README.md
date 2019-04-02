# ![](https://assets-cdn.github.com/images/icons/emoji/octocat.png)MultiLevelSelect [![](https://jitpack.io/v/Tomzem/MultiLevelSelect.svg)](https://jitpack.io/#Tomzem/MultiLevelSelect)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
[![Badge](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu/#/zh_CN)

🍎多级选择控件，支持：单级单选，单级多选，多级单选，多级多选等

## 使用说明
### 依赖
在app/build.gradle中添加:
```
dependencies {
    implementation 'com.github.Tomzem:MultiLevelSelect:1.0.4'
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

### 调用
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
![](https://github.com/Tomzem/MultiLevelSelect/blob/master/Image/20181023-1451-52.png?raw=true)  ![](https://github.com/Tomzem/MultiLevelSelect/blob/master/Image/20181024-1755-11.png?raw=true)

## Adapter构造方法
```
ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel)
ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand)      
ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel,int layoutItem, int iconExpand, int iconNoExpand)
```
#### 参数说明：
|参数名称        | 含 义   |
| --------   | -----  |
| ListView listView    | ListView |	
| Context context    | 上下文 |
| List<T> datas    | 数据源 |
| int defaultExpandLevel    | 默认展开级别（0） |
| int layoutItem    | Item自定义布局 |
| int iconExpand    | 展开图标 |
| int iconNoExpand    | 收缩图标 |
	

## API说明
| API 名称        | 含 义   |
| --------   | -----  |
| setSingleCheck(boolean singleCheck)    | 设置是否单选（默认false） |
| getSelectedNode()        |   获取所有选中节点  |
| getSelectedChildNode()        |    获取所有选中子节点（不含父节点）    |
| addData(T t)    | 添加单个item |
| addData(T t, int defaultExpandLevel)        |   添加单个item，并设置展开级别  |
| addData(List<T> mlists)        |    添加更多数据    |
| addData(List<T> mlists, int defaultExpandLevel)    | 添加更多数据，并设置展开级别 |
| addData(int index, List<T> mlists)        |  在index位置添加更多数据  |
| addData(int index, List<T> mlists, int defaultExpandLevel)       |    在index位置添加更多数据，并设置展开级别    |
| addDataAll(List<T> mlists, int defaultExpandLevel)    | 清空之前数据，重新加载数据，并设置展开级别 |
| expandOrCollapse(int position)        |   展开或收缩第position项（父级别）  |
	
## 注意事项
1.Item当中必须要有的两个字段名（可以是String或Long类型）：
```
   ***private int id; //当前 item ID
   ***private int pid; //当前item父ID
   private String name;
```
2.item中展示的文字由toString获取：
```
    @Override
    public String toString() {
        return this.name;
    }
```  
    
