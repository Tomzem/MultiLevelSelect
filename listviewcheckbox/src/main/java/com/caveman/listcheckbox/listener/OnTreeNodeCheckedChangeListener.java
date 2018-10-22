package com.caveman.listcheckbox.listener;

import com.caveman.listcheckbox.bean.Node;

/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description:选中状态改变的回调
 */
public interface OnTreeNodeCheckedChangeListener {

    void onCheckChange(String id,String name, int position, boolean isChecked);
}