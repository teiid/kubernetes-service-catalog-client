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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ServiceBindingCondition condition information for a ServiceBinding.
 */
public class ServiceBindingCondition {
    public enum ServiceBindingConditionType {
        ready, Failed
    }

    private ServiceBindingConditionType type;
    private ConditionStatus status;
    private Date lastTransitionTime;
    private String reason;
    private String message;

    /**
     * Type of the condition, currently ('Ready').
     *
     * @return
     */
    @JsonProperty("type")
    public ServiceBindingConditionType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(ServiceBindingConditionType type) {
        this.type = type;
    }

    /**
     * Status of the condition, one of ('True', 'False', 'Unknown').
     *
     * @return
     */
    @JsonProperty("status")
    public ConditionStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(ConditionStatus status) {
        this.status = status;
    }

    /**
     * LastTransitionTime is the timestamp corresponding to the last status //
     * change of this condition.
     *
     * @return
     */
    @JsonProperty("lastTransitionTime")
    public Date getLastTransitionTime() {
        return lastTransitionTime;
    }

    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(Date lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * Reason is a brief machine readable explanation for the condition's last //
     * transition.
     *
     * @return
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * // Message is a human readable description of the details of the last //
     * transition, complementing reason.
     *
     * @return
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ServiceBindingCondition [type=" + type + ", status=" + status + ", lastTransitionTime="
                + lastTransitionTime + ", reason=" + reason + ", message=" + message + "]";
    }
}