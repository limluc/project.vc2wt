package com.limluc.vc2wt;

import com.limluc.vc2wt.vc.VCQuery;
import com.limluc.vc2wt.vc.VCQueryBuilder;
import com.limluc.vc2wt.wt.WIQuery;
import com.limluc.vc2wt.wt.WorkItemQueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({
        "classpath:${appTarget:application}.properties"
})
public class SpringContextProvider implements ContextProvider {

    //vc
    @Value("${github.vcUrl}")
    private String vcUrl;
    @Value("${github.vcUser}")
    private String vcUser;
    @Value("${github.vcRepo}")
    private String vcRepo;
    @Value("${github.vcSinceDate}")
    private String vcSinceDate;
    @Value("${github.vcBranch}")
    private String vcBranch;

    private VCQuery createVCQuery() {
        return new VCQueryBuilder()
                .withUrl(vcUrl)
                .withBranch(vcBranch)
                .withRepo(vcRepo)
                .withSinceDate(vcSinceDate)
                .withUser(vcUser)
                .build();
    }

    //wt
    @Value("${jira.wtUrl}")
    private String wtUrl;
    @Value("${jira.wtProject}")
    private String wtProject;
    @Value("${jira.wtFixVersion}")
    private String wtFixVersion;

    private WIQuery createWIQuery() {
        return new WorkItemQueryBuilder()
                .withUrl(wtUrl)
                .withProject(wtProject)
                .withFixVersion(wtFixVersion)
                .build();
    }

    @Override
    public VCQuery getVersionControlQuery() {
        return createVCQuery();
    }

    @Override
    public WIQuery getWorkItemQuery() {
        return createWIQuery();
    }
}
