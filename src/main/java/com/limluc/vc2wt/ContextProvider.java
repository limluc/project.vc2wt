package com.limluc.vc2wt;

import com.limluc.vc2wt.vc.VCQuery;
import com.limluc.vc2wt.wt.WIQuery;

public interface ContextProvider {
    VCQuery getVersionControlQuery();

    WIQuery getWorkItemQuery();
}
