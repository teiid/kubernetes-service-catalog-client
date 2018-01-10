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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceInstanceSpec {
    private String clusterServiceClassExternalName;
    private String clusterServicePlanExternalName;
    private String clusterServiceClassName;
    private String clusterServicePlanName;
    private ClusterObjectReference clusterServiceClassRef;
    private ClusterObjectReference ClusterServicePlanRef;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String parameters;
    private List<ParametersFromSource> parametersFrom = new ArrayList<>();
    private String externalID;
    private UserInfo userInfo;
    private long updateRequests;

    /**
     *  ClusterServiceClassExternalName is the human-readable name of the 
     * service as reported by the broker. Note that if the broker changes  the
     * name of the ClusterServiceClass, it will not be reflected here,  and to see
     * the current name of the ClusterServiceClass, you should  follow the
     * ClusterServiceClassRef below.
     *
     * @return String
     */
    @JsonProperty("clusterServiceClassExternalName")
    public String getClusterServiceClassExternalName() {
        return clusterServiceClassExternalName;
    }

    @JsonProperty("clusterServiceClassExternalName")
    public void setClusterServiceClassExternalName(String clusterServiceClassExternalName) {
        this.clusterServiceClassExternalName = clusterServiceClassExternalName;
    }

    /**
     *  ClusterServicePlanExternalName is the human-readable name of the plan 
     * as reported by the broker. Note that if the broker changes the name  of the
     * ClusterServicePlan, it will not be reflected here, and to see  the current
     * name of the ClusterServicePlan, you should follow the 
     * ClusterServicePlanRef below.
     *
     * @return String
     */
    @JsonProperty("clusterServicePlanExternalName")
    public String getClusterServicePlanExternalName() {
        return clusterServicePlanExternalName;
    }

    @JsonProperty("clusterServicePlanExternalName")
    public void setClusterServicePlanExternalName(String clusterServicePlanExternalName) {
        this.clusterServicePlanExternalName = clusterServicePlanExternalName;
    }

    /**
     * / ClusterServiceClassName is the kubernetes name of the 
     * ClusterServiceClass.
     *
     * @return String
     */
    @JsonProperty("clusterServiceClassName")
    public String getClusterServiceClassName() {
        return clusterServiceClassName;
    }

    @JsonProperty("clusterServiceClassName")
    public void setClusterServiceClassName(String clusterServiceClassName) {
        this.clusterServiceClassName = clusterServiceClassName;
    }

    /**
     * ClusterServicePlanName is kubernetes name of the ClusterServicePlan.
     *
     * @return String
     */
    @JsonProperty("clusterServicePlanName")
    public String getClusterServicePlanName() {
        return clusterServicePlanName;
    }

    @JsonProperty("clusterServicePlanName")
    public void setClusterServicePlanName(String clusterServicePlanName) {
        this.clusterServicePlanName = clusterServicePlanName;
    }

    /**
     *  ClusterServiceClassRef is a reference to the ClusterServiceClass  that
     * the user selected.  This is set by the controller based on 
     * ClusterServiceClassExternalName
     *
     * @return ClusterObjectReference
     */
    @JsonProperty("clusterServiceClassRef")
    public ClusterObjectReference getClusterServiceClassRef() {
        return clusterServiceClassRef;
    }

    @JsonProperty("clusterServiceClassRef")
    public void setClusterServiceClassRef(ClusterObjectReference clusterServiceClassRef) {
        this.clusterServiceClassRef = clusterServiceClassRef;
    }

    /**
     *  ClusterServicePlanRef is a reference to the ClusterServicePlan  that the
     * user selected.  This is set by the controller based on 
     * ClusterServicePlanExternalName
     *
     * @return ClusterObjectReference
     */
    @JsonProperty("clusterServicePlanRef")
    public ClusterObjectReference getClusterServicePlanRef() {
        return ClusterServicePlanRef;
    }

    @JsonProperty("clusterServicePlanRef")
    public void setClusterServicePlanRef(ClusterObjectReference clusterServicePlanRef) {
        ClusterServicePlanRef = clusterServicePlanRef;
    }

    /**
     *  Parameters is a set of the parameters to be passed to the underlying 
     * broker. The inline YAML/JSON payload to be translated into equivalent  JSON
     * object. If a top-level parameter name exists in multiples sources  among
     * `Parameters` and `ParametersFrom` fields, it is considered to be  a user
     * error in the specification.   The Parameters field is NOT secret or
     * secured in any way and should  NEVER be used to hold sensitive information.
     * To set parameters that  contain secret information, you should ALWAYS store
     * that information  in a Secret and use the ParametersFrom field.  
     * +optional
     *
     * @return String
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
     *  List of sources to populate parameters.  If a top-level parameter name
     * exists in multiples sources among  `Parameters` and `ParametersFrom`
     * fields, it is  considered to be a user error in the specification 
     * +optional
     *
     * @return list of ParametersFromSource
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
     * ExternalID is the identity of this object for use with the OSB SB API.
     *
     * @return string
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
     * Currently, this field is ALPHA: it may change or disappear at any time  and
     * its data will not be migrated.   UserInfo contains information about the
     * user that last modified this  instance. This field is set by the API server
     * and not settable by the  end-user. User-provided values for this field are
     * not saved.
     *
     * @return UserInfo
     */
    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     *  UpdateRequests is a strictly increasing, non-negative integer counter that
     *  can be manually incremented by a user to manually trigger an update. This
     *  allows for parameters to be updated with any out-of-band changes that have
     *  been made to the secrets from which the parameters are sourced. 
     * +optional
     *
     * @return long
     */
    @JsonProperty("updateRequests")
    public long getUpdateRequests() {
        return updateRequests;
    }

    @JsonProperty("updateRequests")
    public void setUpdateRequests(long updateRequests) {
        this.updateRequests = updateRequests;
    }

    @Override
    public String toString() {
        return "ServiceInstanceSpec [clusterServiceClassExternalName=" + clusterServiceClassExternalName
                + ", clusterServicePlanExternalName=" + clusterServicePlanExternalName + ", clusterServiceClassName="
                + clusterServiceClassName + ", clusterServicePlanName=" + clusterServicePlanName
                + ", clusterServiceClassRef=" + clusterServiceClassRef + ", ClusterServicePlanRef="
                + ClusterServicePlanRef + ", parameters=" + parameters + ", parametersFrom=" + parametersFrom
                + ", externalID=" + externalID + ", userInfo=" + userInfo + ", updateRequests=" + updateRequests + "]";
    }

}