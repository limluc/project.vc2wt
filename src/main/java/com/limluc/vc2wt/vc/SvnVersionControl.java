package com.limluc.vc2wt.vc;

import com.limluc.vc2wt.exception.VCClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SvnVersionControl implements VersionControl<SvnCommitLog> {

    private static final int HEAD = -1;

    ISVNAuthenticationManager authManager;

    @Autowired
    public SvnVersionControl(ISVNAuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @Override
    public List<SvnCommitLog> getHistory(VCQuery query) {
        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(readRepoUrl(query)));
            repository.setAuthenticationManager(authManager);
            Collection<SVNLogEntry> logEntries = repository.log(new String[]{""}, null, asStartRevision(query), HEAD, true, true);
            return logEntries.stream()
                    .map(this::asSvnCommitLog)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new VCClientException("Unable to retrieve Commit History from SVN", e);
        }
    }

    private String readRepoUrl(VCQuery query) {
        String url = query.getUrl();
        String repo = query.getRepo();
        String branch = query.getBranch();
        return url + "/" + repo + "/" + branch;
    }

    private Long asStartRevision(VCQuery query) {
//        return query.getSinceDate();
        return 10000L;
    }

    private SvnCommitLog asSvnCommitLog(SVNLogEntry logEntry) {
        return new SvnCommitLog(logEntry.getAuthor(), logEntry.getDate(), logEntry.getMessage());
    }
}
