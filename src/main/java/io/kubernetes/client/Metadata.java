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

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Metadata {
    private String name;
    private String namespace;
    private String selfLink;
    private String uid;
    private String resourceVersion;
    private long generation;
    private Date creationTimestamp;
    private String[] finalizers;
    private Map<String, String> others;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    
    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("generation")
    public long getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(long generation) {
        this.generation = generation;
    }

    @JsonProperty("creationTimestamp")
    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @JsonProperty("finalizers")
    public String[] getFinalizers() {
        return finalizers;
    }

    @JsonProperty("finalizers")
    public void setFinalizers(String[] finalizers) {
        this.finalizers = finalizers;
    }

    @JsonAnyGetter
    public Map<String, String> getOthers() {
        return others;
    }

    @JsonAnySetter
    public void setOthers(Map<String, String> others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Metadata [name=" + name + ", selfLink=" + selfLink + ", uid=" + uid + ", resourceVersion="
                + resourceVersion + ", generation=" + generation + ", creationTimestamp=" + creationTimestamp
                + ", finalizers=" + Arrays.toString(finalizers) + ", others=" + others + "]";
    }
}
