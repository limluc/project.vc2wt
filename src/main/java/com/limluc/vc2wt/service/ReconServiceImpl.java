package com.limluc.vc2wt.service;

import com.limluc.vc2wt.ContextProvider;
import com.limluc.vc2wt.vc.Commit;
import com.limluc.vc2wt.vc.VCQuery;
import com.limluc.vc2wt.vc.VersionControl;
import com.limluc.vc2wt.wt.WIQuery;
import com.limluc.vc2wt.wt.WorkItem;
import com.limluc.vc2wt.wt.WorkTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReconServiceImpl implements ReconService {

    private final VersionControl<Commit> versionControl;
    private final WorkTool<WorkItem> workTool;

    @Autowired
    public ReconServiceImpl(VersionControl control, WorkTool workTool) {
        this.versionControl = control;
        this.workTool = workTool;
    }

    @Override
    public Object resolve() {
        return null;
    }

    @Override
    public void compare(ContextProvider sc) {
        this.compare(sc.getVersionControlQuery(), sc.getWorkItemQuery());
    }

    private void compare(VCQuery vcQuery, WIQuery wiQuery) {
        //retrieve commit
        final List<Commit> commitList = versionControl.getHistory(vcQuery);
        commitList.forEach(System.out::println);

        //retrieve work items
        final List<WorkItem> issueList = workTool.getIssues(wiQuery);
        issueList.forEach(System.out::println);

        //do something here
    }
}
