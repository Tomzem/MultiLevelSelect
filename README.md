# MultiLevelSelect
Multistage multiplexed control

## How to use ?
### Install
Add this to your app build.gradle
```
dependencies {
    implementation 'com.github.Tomzem:MultiLevelSelect:1.0.0'
}
```
You will also need support renderscript, also in your build.gradle :
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

## Method of Calling
activity_main.xml：
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
MainActivity.class
```
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
## Implementation effect
![](https://github.com/Tomzem/MultiLevelSelect/blob/master/Image/20181023-1451-52.png?raw=true)  

## The Custom
The first two parameters are not interpreted
```
/**
     * @param listView
     * @param context
     * @param datas The data source
     * @param defaultExpandLevel Default on level
     * @param layoutItem Item custom layout
     * @param iconExpand Contraction icon
     * @param iconNoExpand An icon
     */
    public ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel,int layoutItem, int iconExpand, int iconNoExpand) {
    }
```
The last three parameters can be left unwritten by default
