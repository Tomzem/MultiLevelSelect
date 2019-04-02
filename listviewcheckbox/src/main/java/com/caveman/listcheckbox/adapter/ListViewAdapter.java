package com.caveman.listcheckbox.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.caveman.listcheckbox.R;
import com.caveman.listcheckbox.bean.Node;
import com.caveman.listcheckbox.listener.OnTreeNodeCheckedChangeListener;
import com.caveman.listcheckbox.utils.ListUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description:
 */
public class ListViewAdapter<T> extends TreeListViewAdapter {

    private OnTreeNodeCheckedChangeListener checkedChangeListener;
    private int layoutItem = R.layout.item_list;

    public void setCheckedChangeListener(OnTreeNodeCheckedChangeListener checkedChangeListener) {
        this.checkedChangeListener = checkedChangeListener;
    }

    /**
     *
     * @param listView
     * @param context
     * @param datas 数据源
     * @param defaultExpandLevel 默认开启级别
     */
    public ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel){
        super(listView, context, ListUtils.getInstance().toListObject(datas), defaultExpandLevel);
    }

    public ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(listView, context, ListUtils.getInstance().toListObject(datas), defaultExpandLevel, iconExpand, iconNoExpand);
    }

    /**
     *
     * @param listView
     * @param context
     * @param datas 数据源
     * @param defaultExpandLevel 默认开启级别
     * @param layoutItem item布局
     * @param iconExpand 收缩
     * @param iconNoExpand 展开
     */
    public ListViewAdapter(ListView listView, Context context, List<T> datas, int defaultExpandLevel,int layoutItem, int iconExpand, int iconNoExpand) {
        super(listView, context, ListUtils.getInstance().toListObject(datas), defaultExpandLevel, iconExpand, iconNoExpand);
        this.layoutItem = layoutItem;
    }

    @Override
    public View getConvertView(final Node node, final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, layoutItem, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText(node.getName());

        if (node.getIcon() == -1) {
            holder.ivExpand.setVisibility(View.INVISIBLE);
        } else {
            holder.ivExpand.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(node.getIcon());
        }


        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(node, holder.checkBox.isChecked());
                if (checkedChangeListener != null) {
                    checkedChangeListener.onCheckChange(node.getId(),node.getName(), position,holder.checkBox.isChecked());
                }
            }
        });

        if (layoutItem == R.layout.item_list){
            //如果没又自定义UI替换选中按钮
            if (singleCheck) {
                holder.checkBox.setButtonDrawable(R.drawable.radiobox_style);
            }else{
                holder.checkBox.setButtonDrawable(R.drawable.checkbox_style);
            }
        }

        if (singleCheck) {
            if (node.getChildren().size() != 0) {
                holder.checkBox.setEnabled(false);
            } else {
                holder.checkBox.setEnabled(true);
            }
        }

        if (node.isChecked()) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        return convertView;
    }

    static class ViewHolder {
        private CheckBox checkBox;
        private TextView tvName;
        private ImageView ivExpand;

        public ViewHolder(View convertView) {
            checkBox = (CheckBox) convertView.findViewById(R.id.cb);
            tvName = (TextView) convertView.findViewById(R.id.tv_name);
            ivExpand = (ImageView) convertView.findViewById(R.id.iv_expand);
        }
    }
}
