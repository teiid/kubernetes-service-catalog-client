package io.kubernetes.client;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ServiceBrokerCondition contains condition information for a Broker.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceBrokerCondition {
    public enum ServiceBrokerConditionType {
        Ready, Failed
    }
    private ServiceBrokerConditionType type;
    private ConditionStatus status;
    private Date lastTransitionTime;
    private String reason;
    private String message;

    /**
     * Type of the condition, currently ('Ready').
     * @return
     */
    @JsonProperty("type")
    public ServiceBrokerConditionType getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(ServiceBrokerConditionType type) {
        this.type = type;
    }

    /**
     * Status of the condition, one of ('True', 'False', 'Unknown').
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
     * LastTransitionTime is the timestamp corresponding to the last status
     * change of this condition.
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
     * Reason is a brief machine readable explanation for the condition's last
     * transition.
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
     * Message is a human readable description of the details of the last
     * transition, complementing reason.
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
        return "ServiceBrokerCondition [type=" + type + ", status=" + status + ", lastTransitionTime="
                + lastTransitionTime + ", reason=" + reason + ", message=" + message + "]";
    }
}