package com.limluc.vc2wt.wt;

import com.limluc.vc2wt.service.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class JiraRestApi extends JiraApi {
    private final HttpClient httpClient;

    @Autowired
    public JiraRestApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public List<JiraItem> getIssues(WIQuery query) {
        String jql = String.format("project=\"%s\"&fixVersion=\"%s\"", query.getProject(), query.getFixVersion());
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(query.getUrl())
                .pathSegment("rest", "api", "2", "search")
                .queryParam("jql", jql);

        //call
        JiraJqlResponse body = httpClient.getRequest(builder.build().encode().toUri(), JiraJqlResponse.class).getBody();
        if (body == null) {
            return new ArrayList<>();
        }
        return body.getIssues();
    }
}
