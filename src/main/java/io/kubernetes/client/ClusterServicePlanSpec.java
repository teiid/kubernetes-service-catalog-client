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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterServicePlanSpec represents details about a ClusterServicePlan.
 */
public class ClusterServicePlanSpec {
    private String clusterServiceBrokerName;
    private String externalName;
    private String externalID;
    private String description;
    private boolean bindable;
    private Boolean free;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String externalMetadata;
    private ClusterObjectReference clusterServiceClassRef;

    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String serviceInstanceCreateParameterSchema;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String serviceInstanceUpdateParameterSchema;
    @JsonDeserialize(using = RawJsonDeserializer.class)
    private String serviceBindingCreateParameterSchema;

    /**
     * ClusterServiceBrokerName is the name of the ClusterServiceBroker that
     * offers this ClusterServicePlan.
     *
     * @return
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
     * this Service Plan as. Mutable.
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
     * Description is a short description of this ClusterServicePlan.
     * @return
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
     * ServiceInstance using this ClusterServicePlan. If set, overrides the value
     * of the ClusterServiceClass.Bindable field.
     *
     * @return
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
     * Free indicates whether this plan is available at no cost.
     * @return
     */
    @JsonProperty("free")
    public Boolean getFree() {
        return free;
    }

    @JsonProperty("free")
    public void setFree(Boolean free) {
        this.free = free;
    }

    /**
     * ExternalMetadata is a blob of information about the plan, meant to be
     * user-facing content and display instructions. This field may contain
     * platform-specific conventional values
     *
     * @return
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
     * ClusterServiceClassRef is a reference to the service class that owns this
     * plan.
     *
     * @return
     */
    @JsonProperty("clusterServiceClassRef")
    public ClusterObjectReference getClusterServiceClassRef() {
        return clusterServiceClassRef;
    }

    @JsonProperty("clusterServiceClassRef")
    public void setClusterServiceClassRef(ClusterObjectReference clusterServiceClassRef) {
        this.clusterServiceClassRef = clusterServiceClassRef;
    }

    @JsonProperty("instanceCreateParameterSchema")
    public String getServiceInstanceCreateParameterSchema() {
        return serviceInstanceCreateParameterSchema;
    }

    /**
     * Currently, this field is ALPHA: it may change or disappear at any time and
     * its data will not be migrated. ServiceInstanceCreateParameterSchema is
     * the schema for the parameters that may be supplied when provisioning a new
     * ServiceInstance on this plan.
     *
     * @param serviceInstanceCreateParameterSchema
     */
    @JsonProperty("instanceCreateParameterSchema")
    public void setServiceInstanceCreateParameterSchema(String serviceInstanceCreateParameterSchema) {
        this.serviceInstanceCreateParameterSchema = serviceInstanceCreateParameterSchema;
    }

    /**
     * Currently, this field is ALPHA: it may change or disappear at any time and
     * its data will not be migrated. ServiceInstanceUpdateParameterSchema is
     * the schema for the parameters that may be updated once an ServiceInstance
     * has been provisioned on this plan. This field only has meaning if the
     * ClusterServiceClass is PlanUpdatable.
     *
     * @return
     */
    @JsonProperty("instanceUpdateParameterSchema")
    public String getServiceInstanceUpdateParameterSchema() {
        return serviceInstanceUpdateParameterSchema;
    }

    @JsonProperty("instanceUpdateParameterSchema")
    public void setServiceInstanceUpdateParameterSchema(String serviceInstanceUpdateParameterSchema) {
        this.serviceInstanceUpdateParameterSchema = serviceInstanceUpdateParameterSchema;
    }

    /**
     * Currently, this field is ALPHA: it may change or disappear at any time and
     * its data will not be migrated. ServiceBindingCreateParameterSchema is
     * the schema for the parameters that may be supplied binding to an
     * ServiceInstance on this plan.
     *
     * @return
     */
    @JsonProperty("serviceBindingCreateParameterSchema")
    public String getServiceBindingCreateParameterSchema() {
        return serviceBindingCreateParameterSchema;
    }

    @JsonProperty("serviceBindingCreateParameterSchema")
    public void setServiceBindingCreateParameterSchema(String serviceBindingCreateParameterSchema) {
        this.serviceBindingCreateParameterSchema = serviceBindingCreateParameterSchema;
    }

    @Override
    public String toString() {
        return "ClusterServicePlanSpec [clusterServiceBrokerName=" + clusterServiceBrokerName + ", externalName="
                + externalName + ", externalID=" + externalID + ", description=" + description + ", bindable="
                + bindable + ", free=" + free + ", externalMetadata=" + externalMetadata + ", clusterServiceClassRef="
                + clusterServiceClassRef + ", serviceInstanceCreateParameterSchema="
                + serviceInstanceCreateParameterSchema + ", serviceInstanceUpdateParameterSchema="
                + serviceInstanceUpdateParameterSchema + ", serviceBindingCreateParameterSchema="
                + serviceBindingCreateParameterSchema + "]";
    }
}