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
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ClusterServiceBrokerStatus represents the current status of a Broker.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ClusterServiceBrokerStatus {
    private ArrayList<ServiceBrokerCondition> conditions = new ArrayList<>();
    private long reconciledGeneration;
    private Date operationStartTime;

    @JsonProperty("conditions")
    public ArrayList<ServiceBrokerCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(ArrayList<ServiceBrokerCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ReconciledGeneration is the 'Generation' of the ClusterServiceBrokerSpec
     * that was last processed by the controller. The reconciled generation is
     * updated even if the controller failed to process the spec.
     * @return long
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
     * OperationStartTime is the time at which the current operation began.
     * @return date
     */
    @JsonProperty("operationStartTime")
    public Date getOperationStartTime() {
        return operationStartTime;
    }

    @JsonProperty("operationStartTime")
    public void setOperationStartTime(Date operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    @Override
    public String toString() {
        return "ClusterServiceBrokerStatus [conditions=" + conditions + ", reconciledGeneration=" + reconciledGeneration
                + ", operationStartTime=" + operationStartTime + "]";
    }
}