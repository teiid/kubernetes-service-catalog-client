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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ServiceBindingStatus represents the current status of a ServiceBinding.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceBindingStatus {
    public enum ServiceBindingOperation {
        Bind, Unbind;
    }

    private List<ServiceBindingCondition> conditions;
    private ServiceBindingOperation currentOperation;
    private long reconciledGeneration;
    private Date operationStartTime;
    private ServiceBindingPropertiesState inProgressProperties;
    private ServiceBindingPropertiesState externalProperties;
    private boolean orphanMitigationInProgress;

    public boolean isReady() {
    	List<ServiceBindingCondition> conditions = getConditions();
    	for (ServiceBindingCondition condition : conditions) {
    		if (condition.getType() == ServiceBindingCondition.ServiceBindingConditionType.Ready) {
    			return condition.getStatus() == ConditionStatus.True;
    		}
    	}
    	return false;
    }    
    
    @JsonProperty("conditions")
    public List<ServiceBindingCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<ServiceBindingCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * // CurrentOperation is the operation the Controller is currently performing
     * // on the ServiceBinding.
     *
     * @return
     */
    @JsonProperty("currentOperation")
    public ServiceBindingOperation getCurrentOperation() {
        return currentOperation;
    }

    @JsonProperty("currentOperation")
    public void setCurrentOperation(ServiceBindingOperation currentOperation) {
        this.currentOperation = currentOperation;
    }

    /**
     * // ReconciledGeneration is the 'Generation' of the // ServiceBindingSpec that
     * was last processed by the controller. // The reconciled generation is updated
     * even if the controller failed to // process the spec.
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
     * // InProgressProperties is the properties state of the // ServiceBinding when
     * a Bind is in progress. If the current // operation is an Unbind, this will be
     * nil.
     *
     * @return
     */
    @JsonProperty("inProgressProperties")
    public ServiceBindingPropertiesState getInProgressProperties() {
        return inProgressProperties;
    }

    @JsonProperty("inProgressProperties")
    public void setInProgressProperties(ServiceBindingPropertiesState inProgressProperties) {
        this.inProgressProperties = inProgressProperties;
    }

    /**
     *
     * // ExternalProperties is the properties state of the // ServiceBinding which
     * the broker knows about.
     *
     * @return
     */
    @JsonProperty("externalProperties")
    public ServiceBindingPropertiesState getExternalProperties() {
        return externalProperties;
    }

    @JsonProperty("externalProperties")
    public void setExternalProperties(ServiceBindingPropertiesState externalProperties) {
        this.externalProperties = externalProperties;
    }

    /**
     * // OrphanMitigationInProgress is a flag that represents whether orphan //
     * mitigation is in progress.
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

    @Override
    public String toString() {
        return "ServiceBindingStatus [conditions=" + conditions + ", currentOperation=" + currentOperation
                + ", reconciledGeneration=" + reconciledGeneration + ", operationStartTime=" + operationStartTime
                + ", inProgressProperties=" + inProgressProperties + ", externalProperties=" + externalProperties
                + ", orphanMitigationInProgress=" + orphanMitigationInProgress + "]";
    }
}