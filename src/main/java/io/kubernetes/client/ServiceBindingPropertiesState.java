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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * // ServiceBindingPropertiesState is the state of a // ServiceBinding that the
 * ClusterServiceBroker knows about.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceBindingPropertiesState {
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String parameters;
    private String parametersChecksum;
    private UserInfo userInfo;

    /**
     * // Parameters is a blob of the parameters and their values that the broker //
     * knows about for this ServiceBinding. If a parameter was // sourced from a
     * secret, its value will be "<redacted>" in this blob.
     *
     * @return
     */
    @JsonProperty("parameters")
    public String getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * // ParametersChecksum is the checksum of the parameters that were sent.
     *
     * @return
     */
    @JsonProperty("parameterChecksum")
    public String getParametersChecksum() {
        return parametersChecksum;
    }

    @JsonProperty("parameterChecksum")
    public void setParametersChecksum(String parametersChecksum) {
        this.parametersChecksum = parametersChecksum;
    }

    /**
     * // UserInfo is information about the user that made the request.
     *
     * @return
     */
    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "ServiceBindingPropertiesState [parameters=" + parameters + ", parametersChecksum=" + parametersChecksum
                + ", userInfo=" + userInfo + "]";
    }
}