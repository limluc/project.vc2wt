package com.limluc.vc2wt.wt;

import java.util.List;

public interface WorkTool<T extends WorkItem> {

    List<T> getIssues(WIQuery query);
}
