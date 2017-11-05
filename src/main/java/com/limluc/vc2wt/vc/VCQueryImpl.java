package com.limluc.vc2wt.vc;

public class VCQueryImpl implements VCQuery {

    private String url;
    private String user;
    private String repo;
    private String sinceDate;
    private String branch;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public void setSinceDate(String sinceDate) {
        this.sinceDate = sinceDate;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getRepo() {
        return repo;
    }

    @Override
    public String getSinceDate() {
        return sinceDate;
    }

    @Override
    public String getBranch() {
        return branch;
    }
}
