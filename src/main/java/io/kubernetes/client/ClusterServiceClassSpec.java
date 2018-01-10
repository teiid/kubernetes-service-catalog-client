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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterServiceClassSpec represents details about the ClusterServicePlan
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ClusterServiceClassSpec {
    private String clusterServiceBrokerName;
    private String externalName;
    private String externalID;
    private String description;
    private boolean bindable;
    private boolean planUpdatable;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String externalMetadata;
    private String[] tags;
    private String[] requires;

    /**
     * ClusterServiceBrokerName is the reference to the Broker that provides this
     * ClusterServiceClass. Immutable.
     * @return string
     */
    @JsonProperty("clusterServiceBrokerName")
    public String getClusterServiceBrokerName() {
        return clusterServiceBrokerName;
    }

    @JsonProperty("clusterServiceBrokerName")
    public void setClusterServiceBrokerName(String clusterServiceBrokerName) {
        this.clusterServiceBrokerName = clusterServiceBrokerName;
    }

    /**
     * ExternalName is the name of this object that the Service Broker exposed
     * this Service Class as. Mutable.
     * @return string
     */
    @JsonProperty("externalName")
    public String getExternalName() {
        return externalName;
    }

    @JsonProperty("externalName")
    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    /**
     * ExternalID is the identity of this object for use with the OSB API.
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
     * Description is a short description of this ClusterServiceClass.
     * @return string
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Bindable indicates whether a user can create bindings to an
     * ServiceInstance provisioned from this service. ClusterServicePlan  has an
     * optional field called Bindable which overrides the value of  this field.
     * @return boolean
     */
    @JsonProperty("bindable")
    public boolean isBindable() {
        return bindable;
    }

    @JsonProperty("bindable")
    public void setBindable(boolean bindable) {
        this.bindable = bindable;
    }

    /**
     * PlanUpdatable indicates whether instances provisioned from this
     * ClusterServiceClass may change ClusterServicePlans after being
     * provisioned.
     * @return boolean
     */
    @JsonProperty("planUpdatable")
    public boolean isPlanUpdatable() {
        return planUpdatable;
    }

    @JsonProperty("planUpdatable")
    public void setPlanUpdatable(boolean planUpdatable) {
        this.planUpdatable = planUpdatable;
    }

    /**
     * ExternalMetadata is a blob of information about the ClusterServiceClass,
     * meant to be user-facing content and display instructions. This field may
     * contain platform-specific conventional values
     * @return string
     */
    @JsonProperty("externalMetadata")
    public String getExternalMetadata() {
        return externalMetadata;
    }

    @JsonProperty("externalMetadata")
    public void setExternalMetadata(String externalMetadata) {
        this.externalMetadata = externalMetadata;
    }

    /**
     * Currently, this field is ALPHA: it may change or disappear at any time
     * and its data will not be migrated. Tags is a list of strings that
     * represent different classification attributes of the ClusterServiceClass.
     * These are used in Cloud Foundry in a way similar to Kubernetes labels, but
     * they currently have no special meaning in Kubernetes.
     *
     * @return string array
     */
    @JsonProperty("tags")
    public String[] getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Currently, this field is ALPHA: it may change or disappear at any time and
     * its data will not be migrated. Requires exposes a list of Cloud
     * Foundry-specific 'permissions' that must be granted to an instance of this
     * service within Cloud Foundry. These 'permissions' have no meaning within
     * Kubernetes and an ServiceInstance provisioned from this
     * ClusterServiceClass will not work correctly.
     * @return string array
     */
    @JsonProperty("requires")
    public String[] getRequires() {
        return requires;
    }

    @JsonProperty("requires")
    public void setRequires(String[] requires) {
        this.requires = requires;
    }

    @Override
    public String toString() {
        return "ClusterServiceClassSpec [clusterServiceBrokerName=" + clusterServiceBrokerName + ", externalName="
                + externalName + ", externalID=" + externalID + ", description=" + description + ", bindable="
                + bindable + ", planUpdatable=" + planUpdatable + ", externalMetadata=" + externalMetadata + ", tags="
                + Arrays.toString(tags) + ", requires=" + Arrays.toString(requires) + "]";
    }
}