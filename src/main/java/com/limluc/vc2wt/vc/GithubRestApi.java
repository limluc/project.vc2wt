package com.limluc.vc2wt.vc;

import com.limluc.vc2wt.service.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Component
public class GithubRestApi extends GithubApi {

    private final HttpClient httpClient;

    @Autowired
    public GithubRestApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<GitCommit> getHistory(VCQuery query) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(query.getUrl())
                .pathSegment("repos", query.getUser(), query.getRepo(), "commits")
                .queryParam("since", query.getSinceDate())
                .queryParam("sha", query.getBranch());

        //call
        return httpClient.getRequest(builder.build().encode().toUri(), RESPONSE_TYPE).getBody();
    }
}
