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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ServiceBindingSpec represents the desired state of a // ServiceBinding. // //
 * The spec field cannot be changed after a ServiceBinding is // created.
 * Changes submitted to the spec field will be ignored.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceBindingSpec {
    private LocalObjectReference serviceInstanceRef;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String parameters;
    private List<ParametersFromSource> parametersFrom;
    private String secretName;
    private String externalID;
    private UserInfo userInfo;

    /**
     * ServiceInstanceRef is the reference to the Instance this ServiceBinding is
     * to.
     *
     * @return
     */
    @JsonProperty("instanceRef")
    public LocalObjectReference getServiceInstanceRef() {
        return serviceInstanceRef;
    }

    @JsonProperty("instanceRef")
    public void setServiceInstanceRef(LocalObjectReference serviceInstanceRef) {
        this.serviceInstanceRef = serviceInstanceRef;
    }

    /**
     * // Parameters is a set of the parameters to be passed to the underlying //
     * broker. The inline YAML/JSON payload to be translated into equivalent // JSON
     * object. If a top-level parameter name exists in multiples sources // among
     * `Parameters` and `ParametersFrom` fields, it is considered to be // a user
     * error in the specification. // // The Parameters field is NOT secret or
     * secured in any way and should // NEVER be used to hold sensitive information.
     * To set parameters that // contain secret information, you should ALWAYS store
     * that information // in a Secret and use the ParametersFrom field. // //
     * +optional
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
     * // List of sources to populate parameters. // If a top-level parameter name
     * exists in multiples sources among // `Parameters` and `ParametersFrom`
     * fields, it is // considered to be a user error in the specification. //
     * +optional
     *
     * @return
     */
    @JsonProperty("parametersFrom")
    public List<ParametersFromSource> getParametersFrom() {
        return parametersFrom;
    }

    @JsonProperty("parametersFrom")
    public void setParametersFrom(List<ParametersFromSource> parametersFrom) {
        this.parametersFrom = parametersFrom;
    }

    /**
     * // SecretName is the name of the secret to create in the ServiceBinding's //
     * namespace that will hold the credentials associated with the ServiceBinding.
     *
     * @return
     */
    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    /**
     * // ExternalID is the identity of this object for use with the OSB API. // //
     * Immutable.
     *
     * @return
     */
    @JsonProperty("externalID")
    public String getExternalID() {
        return externalID;
    }

    @JsonProperty("externalID")
    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }

    /**
     * // Currently, this field is ALPHA: it may change or disappear at any time //
     * and its data will not be migrated. // // UserInfo contains information about
     * the user that last modified this // ServiceBinding. This field is set by the
     * API server and not // settable by the end-user. User-provided values for this
     * field are not saved. // +optional
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
        return "ServiceBindingSpec [serviceInstanceRef=" + serviceInstanceRef + ", parameters=" + parameters
                + ", parametersFrom=" + parametersFrom + ", secretName=" + secretName + ", externalID=" + externalID
                + ", userInfo=" + userInfo + "]";
    }
}