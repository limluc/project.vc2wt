package com.limluc.vc2wt.vc;

public class VCQueryBuilder {
    private VCQueryImpl vcQuery = new VCQueryImpl();

    public VCQueryBuilder withUrl(String vcUrl) {
        vcQuery.setUrl(vcUrl);
        return this;
    }

    public VCQueryBuilder withUser(String thisUser) {
        vcQuery.setUser(thisUser);
        return this;
    }

    public VCQueryBuilder withRepo(String thisRepo) {
        vcQuery.setRepo(thisRepo);
        return this;
    }

    public VCQueryBuilder withSinceDate(String thisSinceDate) {
        vcQuery.setSinceDate(thisSinceDate);
        return this;
    }

    public VCQueryBuilder withBranch(String thisBranch) {
        vcQuery.setBranch(thisBranch);
        return this;
    }

    public VCQuery build() {
        return vcQuery;
    }
}
