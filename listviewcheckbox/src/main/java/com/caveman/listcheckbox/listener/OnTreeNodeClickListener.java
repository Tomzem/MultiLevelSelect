package com.caveman.listcheckbox.listener;

import com.caveman.listcheckbox.bean.Node;

/**
 * Created by Administrator on 2018/10/22.
 * <p>
 * Description:条目点击的回调
 */
public interface OnTreeNodeClickListener {
    void onClick(Node node, int position);
}
