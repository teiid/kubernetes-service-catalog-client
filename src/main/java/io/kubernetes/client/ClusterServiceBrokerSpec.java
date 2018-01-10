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

@JsonIgnoreProperties(ignoreUnknown=true)
public class ClusterServiceBrokerSpec {
    enum ServiceBrokerRelistBehavior {Duration, Manual};
    private String url;
    private ServiceBrokerAuthInfo authInfo;
    private boolean insecureSkipTLSVerify;
    private byte[] caBundle;
    private ServiceBrokerRelistBehavior relistBehavior;
    private String relistDuration;
    private long relistRequests;

    /**
     * URL is the address used to communicate with the ClusterServiceBroker.
     * @return string
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * AuthInfo contains the data that the service catalog should use to
     * authenticate with the ClusterServiceBroker.
     * @return ServiceBrokerAuthInfo
     */
    @JsonProperty("authInfo")
    public ServiceBrokerAuthInfo getAuthInfo() {
        return authInfo;
    }

    @JsonProperty("authInfo")
    public void setAuthInfo(ServiceBrokerAuthInfo authInfo) {
        this.authInfo = authInfo;
    }

    /**
     * InsecureSkipTLSVerify disables TLS certificate verification when
     * communicating with this Broker. This is strongly discouraged. You should
     * use the CABundle instead. optional
     * @return boolean
     */
    @JsonProperty("insecureSkipTLSVerify")
    public boolean isInsecureSkipTLSVerify() {
        return insecureSkipTLSVerify;
    }

    @JsonProperty("insecureSkipTLSVerify")
    public void setInsecureSkipTLSVerify(boolean insecureSkipTLSVerify) {
        this.insecureSkipTLSVerify = insecureSkipTLSVerify;
    }

    /**
     * CABundle is a PEM encoded CA bundle which will be used to validate a Broker's
     * serving certificate. +optional
     * @return byte array
     */
    @JsonProperty("caBundle")
    public byte[] getCaBundle() {
        return caBundle;
    }

    @JsonProperty("caBundle")
    public void setCaBundle(byte[] caBundle) {
        this.caBundle = caBundle;
    }

    /**
     * RelistBehavior specifies the type of relist behavior the catalog should
     * exhibit when relisting ClusterServiceClasses available from a broker.
     * @return ServiceBrokerRelistBehavior
     */
    @JsonProperty("relistBehavior")
    public ServiceBrokerRelistBehavior getRelistBehavior() {
        return relistBehavior;
    }

    @JsonProperty("relistBehavior")
    public void setRelistBehavior(String behavior) {
        this.relistBehavior = ServiceBrokerRelistBehavior.valueOf(behavior);
    }

    /**
     * RelistDuration is the frequency by which a controller will relist the //
     * broker when the RelistBehavior is set to ServiceBrokerRelistBehaviorDuration.
     * @return string
     */
    @JsonProperty("relistDuration")
    public String getRelistDuration() {
        return relistDuration;
    }

    @JsonProperty("relistDuration")
    public void setRelistDuration(String relistDuration) {
        this.relistDuration = relistDuration;
    }

    /**
     * RelistRequests is a strictly increasing, non-negative integer counter that
     * can be manually incremented by a user to manually trigger a relist. 
     * optional
     * @return long
     */
    @JsonProperty("relistRequests")
    public long getRelistRequests() {
        return relistRequests;
    }

    @JsonProperty("relistRequests")
    public void setRelistRequests(long relistRequests) {
        this.relistRequests = relistRequests;
    }

    @Override
    public String toString() {
        return "ClusterServiceBrokerSpec [url=" + url + ", authInfo=" + authInfo + ", insecureSkipTLSVerify="
                + insecureSkipTLSVerify + ", caBundle=" + Arrays.toString(caBundle) + ", relistBehavior="
                + relistBehavior + ", relistDuration=" + relistDuration + ", relistRequests=" + relistRequests + "]";
    }
}