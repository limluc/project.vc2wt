package com.limluc.vc2wt.vc;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

public abstract class GithubApi implements VersionControl<GitCommit> {
    static final ParameterizedTypeReference<List<GitCommit>> RESPONSE_TYPE = new ParameterizedTypeReference<List<GitCommit>>() {{
    }};
}
