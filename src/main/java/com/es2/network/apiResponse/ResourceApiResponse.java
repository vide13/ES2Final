package com.es2.network.apiResponse;

import com.es2.data.Resource;

public class ResourceApiResponse {
    private final Resource data;

    public ResourceApiResponse(Resource data) {
        this.data = data;
    }

    public Resource getData() {
        return data;
    }
}
