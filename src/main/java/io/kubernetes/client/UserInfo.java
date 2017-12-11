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
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserInfo holds information about the user that last changed a resource's
 * spec.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserInfo {
    private String username;
    private String UID;
    private String[] groups;
    private Map<String, Object> extra;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("uid")
    public String getUID() {
        return UID;
    }

    @JsonProperty("uid")
    public void setUID(String uID) {
        UID = uID;
    }

    @JsonProperty("groups")
    public String[] getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    @JsonProperty("extra")
    public Map<String, Object> getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "UserInfo [username=" + username + ", UID=" + UID + ", groups=" + Arrays.toString(groups) + ", extra="
                + extra + "]";
    }
}