package com.limluc.vc2wt.vc;

import com.limluc.vc2wt.service.HttpClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//@Component
public class FisheyeApi implements VersionControl<ChangeSetCommit> {
    private static final ParameterizedTypeReference<List<ChangeSetCommit>> RESPONSE_TYPE = new ParameterizedTypeReference<List<ChangeSetCommit>>() {{
    }};

    private final HttpClient httpClient;

    public FisheyeApi(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Reference
     * https://docs.atlassian.com/fisheye-crucible/latest/wadl/fisheye.html#rest-service-fe:commit-graph-v1:details:repository:[^:]+
     *
     * @param query VCQuery
     * @return List of Change Set
     */
    @Override
    public List<ChangeSetCommit> getHistory(VCQuery query) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(query.getUrl())
                .pathSegment("repos", query.getUser(), query.getRepo(), "commits")
                .queryParam("since", query.getSinceDate())
                .queryParam("sha", query.getBranch());

        //call
        return httpClient.getRequest(builder.build().encode().toUri(), RESPONSE_TYPE).getBody();
    }
}
