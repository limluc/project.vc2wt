package com.limluc.vc2wt.wt;

import java.io.Serializable;
import java.util.List;

public class JiraJqlResponse implements Serializable {
    private List<JiraItem> issues;

    public List<JiraItem> getIssues() {
        return issues;
    }
}
