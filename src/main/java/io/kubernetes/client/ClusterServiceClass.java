/*
 * Copyright Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags and
 * the COPYRIGHT.txt file distributed with this work.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.kubernetes.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ClusterServiceClass represents an offering in the service catalog.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ClusterServiceClass {
    private Metadata metadata;
    private ClusterServiceClassSpec spec;
    private ClusterServiceClassStatus status;

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("spec")
    public ClusterServiceClassSpec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(ClusterServiceClassSpec spec) {
        this.spec = spec;
    }

    @JsonProperty("status")
    public ClusterServiceClassStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(ClusterServiceClassStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClusterServiceClass [metadata=" + metadata + ", spec=" + spec + ", status=" + status + "]";
    }
}