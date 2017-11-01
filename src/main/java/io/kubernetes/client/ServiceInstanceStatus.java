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

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ServiceInstanceStatus represents the current status of an Instance.
 */
public class ServiceInstanceStatus {
    public static enum ServiceInstanceOperation {
        Provision, Update, Deprovision;
    }

    public static enum ServiceInstanceDeprovisionStatus {
        NotRequired, Required, Succeeded, Failed;
    }

    private List<ServiceInstanceCondition> conditions;
    private boolean asyncOpInProgress;
    private boolean orphanMitigationInProgress;
    private String lastOperation;
    private String dashboardURL;
    private ServiceInstanceOperation currentOperation;
    private long reconciledGeneration;
    private Date operationStartTime;
    private ServiceInstancePropertiesState inProgressProperties;
    private ServiceInstancePropertiesState externalProperties;
    private ServiceInstanceDeprovisionStatus deprovisionStatus;

    /**
     * // Conditions is an array of ServiceInstanceConditions capturing aspects of
     * an // ServiceInstance's status.
     *
     * @return
     */
    @JsonProperty("conditions")
    public List<ServiceInstanceCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ServiceInstanceCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * // AsyncOpInProgress is set to true if there is an ongoing async operation //
     * against this Service Instance in progress.
     *
     * @return
     */
    @JsonProperty("asyncOpInProgress")
    public boolean isAsyncOpInProgress() {
        return asyncOpInProgress;
    }

    @JsonProperty("asyncOpInProgress")
    public void setAsyncOpInProgress(boolean asyncOpInProgress) {
        this.asyncOpInProgress = asyncOpInProgress;
    }

    /**
     * // OrphanMitigationInProgress is set to true if there is an ongoing orphan //
     * mitigation operation against this ServiceInstance in progress.
     *
     * @return
     */
    @JsonProperty("orphanMitigationInProgress")
    public boolean isOrphanMitigationInProgress() {
        return orphanMitigationInProgress;
    }

    @JsonProperty("orphanMitigationInProgress")
    public void setOrphanMitigationInProgress(boolean orphanMitigationInProgress) {
        this.orphanMitigationInProgress = orphanMitigationInProgress;
    }

    /**
     * // LastOperation is the string that the broker may have returned when // an
     * async operation started, it should be sent back to the broker // on poll
     * requests as a query param.
     *
     * @return
     */
    @JsonProperty("lastOperation")
    public String getLastOperation() {
        return lastOperation;
    }

    @JsonProperty("lastOperation")
    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    /**
     * // DashboardURL is the URL of a web-based management user interface for //
     * the service instance.
     *
     * @return
     */
    @JsonProperty("dashboardURL")
    public String getDashboardURL() {
        return dashboardURL;
    }

    @JsonProperty("dashboardURL")
    public void setDashboardURL(String dashboardURL) {
        this.dashboardURL = dashboardURL;
    }

    /**
     * // CurrentOperation is the operation the Controller is currently performing
     * // on the ServiceInstance.
     *
     * @return
     */
    @JsonProperty("currentOperation")
    public ServiceInstanceOperation getCurrentOperation() {
        return currentOperation;
    }

    @JsonProperty("currentOperation")
    public void setCurrentOperation(ServiceInstanceOperation currentOperation) {
        this.currentOperation = currentOperation;
    }

    /**
     *
     * // ReconciledGeneration is the 'Generation' of the serviceInstanceSpec that
     * // was last processed by the controller. The reconciled generation is updated
     * // even if the controller failed to process the spec.
     *
     * @return
     */
    @JsonProperty("reconciledGeneration")
    public long getReconciledGeneration() {
        return reconciledGeneration;
    }

    @JsonProperty("reconciledGeneration")
    public void setReconciledGeneration(long reconciledGeneration) {
        this.reconciledGeneration = reconciledGeneration;
    }

    /**
     * // OperationStartTime is the time at which the current operation began.
     *
     * @return
     */
    @JsonProperty("operationStartTime")
    public Date getOperationStartTime() {
        return operationStartTime;
    }

    @JsonProperty("operationStartTime")
    public void setOperationStartTime(Date operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    /**
     * InProgressProperties is the properties state of the ServiceInstance when // a
     * Provision or Update is in progress. If the current operation is a //
     * Deprovision, this will be nil.
     *
     * @return
     */
    @JsonProperty("inProgressProperties")
    public ServiceInstancePropertiesState getInProgressProperties() {
        return inProgressProperties;
    }

    @JsonProperty("inProgressProperties")
    public void setInProgressProperties(ServiceInstancePropertiesState inProgressProperties) {
        this.inProgressProperties = inProgressProperties;
    }

    /**
     * ExternalProperties is the properties state of the ServiceInstance which the
     * // broker knows about.
     *
     * @return
     */
    @JsonProperty("externalProperties")
    public ServiceInstancePropertiesState getExternalProperties() {
        return externalProperties;
    }

    @JsonProperty("externalProperties")
    public void setExternalProperties(ServiceInstancePropertiesState externalProperties) {
        this.externalProperties = externalProperties;
    }

    /**
     * DeprovisionStatus describes what has been done to deprovision the //
     * ServiceInstance.
     *
     * @return
     */
    @JsonProperty("deprovisionStatus")
    public ServiceInstanceDeprovisionStatus getDeprovisionStatus() {
        return deprovisionStatus;
    }

    @JsonProperty("deprovisionStatus")
    public void setDeprovisionStatus(ServiceInstanceDeprovisionStatus deprovisionStatus) {
        this.deprovisionStatus = deprovisionStatus;
    }

    @Override
    public String toString() {
        return "ServiceInstanceStatus [conditions=" + conditions + ", asyncOpInProgress=" + asyncOpInProgress
                + ", orphanMitigationInProgress=" + orphanMitigationInProgress + ", lastOperation=" + lastOperation
                + ", dashboardURL=" + dashboardURL + ", currentOperation=" + currentOperation
                + ", reconciledGeneration=" + reconciledGeneration + ", operationStartTime=" + operationStartTime
                + ", inProgressProperties=" + inProgressProperties + ", externalProperties=" + externalProperties
                + ", deprovisionStatus=" + deprovisionStatus + "]";
    }
}