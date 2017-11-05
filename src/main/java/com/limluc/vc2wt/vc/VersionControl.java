package com.limluc.vc2wt.vc;

import java.util.List;

public interface VersionControl<T extends Commit> {
    List<T> getHistory(VCQuery query);
}
