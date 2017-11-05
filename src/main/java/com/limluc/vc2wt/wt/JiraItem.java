package com.limluc.vc2wt.wt;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limluc.vc2wt.model.Versionable;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JiraItem implements WorkItem, Versionable, Serializable {

    private String key;
    private Field fields;
//    private Map<String, ?> fields;

    @Override
    public String getVersion() {
        return fields.getFixVersion();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Field getFields() {
        return fields;
    }

    public void setFields(Field fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "JiraIssue{" +
                "key='" + key + '\'' +
                ", fields=" + fields +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Field implements Serializable{
        private String summary;
        private String fixVersion;
        private Map<String, ?> reporter;
        private Map<String, ?> issuetype;


        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFixVersion() {
            return fixVersion;
        }

        public void setFixVersion(String fixVersion) {
            this.fixVersion = fixVersion;
        }

        public Map<String, ?> getReporter() {
            return reporter;
        }

        public void setReporter(Map<String, ?> reporter) {
            this.reporter = reporter;
        }

        public Map<String, ?> getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(Map<String, ?> issuetype) {
            this.issuetype = issuetype;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "summary='" + summary + '\'' +
                    ", fixVersion='" + fixVersion + '\'' +
                    ", reporter=" + reporter +
                    ", issuetype=" + issuetype +
                    '}';
        }
    }
}
