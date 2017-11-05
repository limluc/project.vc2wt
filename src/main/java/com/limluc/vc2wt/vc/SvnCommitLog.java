package com.limluc.vc2wt.vc;

import java.util.Date;

public class SvnCommitLog implements Commit {

    private final String author;
    private final Date date;
    private final String message;

    public SvnCommitLog(String author, Date date, String message) {

        this.author = author;
        this.date = date;
        this.message = message;
    }

    @Override
    public String getAuthorName() {
        return author;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
