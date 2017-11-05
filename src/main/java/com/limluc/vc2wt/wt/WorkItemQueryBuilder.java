package com.limluc.vc2wt.wt;

public class WorkItemQueryBuilder {
    private WIQueryImpl query = new WIQueryImpl();

    public WorkItemQueryBuilder withUrl(String vcUrl) {
        query.setUrl(vcUrl);
        return this;
    }

    public WorkItemQueryBuilder withProject(String thisProject) {
        query.setProject(thisProject);
        return this;
    }

    public WorkItemQueryBuilder withFixVersion(String thisFixVersion) {
        query.setFixVersion(thisFixVersion);
        return this;
    }

    public WIQuery build() {
        return query;
    }
}
