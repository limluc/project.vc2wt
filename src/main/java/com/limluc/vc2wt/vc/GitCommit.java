package com.limluc.vc2wt.vc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limluc.vc2wt.service.Versionable;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommit implements Commit, Versionable, Serializable {
    private CommitObject commit;

    public GitCommit() {
    }

    public CommitObject getCommit() {
        return commit;
    }

    public void setCommit(CommitObject commit) {
        this.commit = commit;
    }


    public String getVersion() {
        return null;
    }

    @Override
    public String getAuthorName() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public String toString() {
        return "GitCommit{" +
                "commit=" + commit +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class CommitObject implements Serializable {
        private CommitterObject committer;
        private String message;

        public CommitObject() {
        }

        public CommitterObject getCommitter() {
            return committer;
        }

        public void setCommitter(CommitterObject committer) {
            this.committer = committer;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "CommitObject{" +
                    "committer=" + committer +
                    ", message='" + message.replace("\n", "") + '\'' +
                    '}';
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public class CommitterObject implements Serializable {
            private String name;
            private String date;

            public CommitterObject() {
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            @Override
            public String toString() {
                return "CommitterObject{" +
                        "name='" + name + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }
        }
    }
}
