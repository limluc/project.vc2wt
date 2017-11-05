package com.limluc.vc2wt.wt;

public class WIQueryImpl implements WIQuery {

    private String url;
    private String project;
    private String fixVersion;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setFixVersion(String fixVersion) {
        this.fixVersion = fixVersion;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getProject() {
        return project;
    }

    @Override
    public String getFixVersion() {
        return fixVersion;
    }
}
