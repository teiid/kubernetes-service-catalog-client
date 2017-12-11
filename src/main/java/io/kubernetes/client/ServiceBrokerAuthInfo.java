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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ServiceBrokerAuthInfo is a union type that contains information on one of
 * the authentication methods the the service catalog and brokers may
 * support, according to the OpenServiceBroker API specification
 * (https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md).
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ServiceBrokerAuthInfo {
    private BasicAuthConfig basic;
    private BearerTokenAuthConfig bearer;

    /**
     * Basic provides configuration for basic authentication.
     */
    @JsonProperty("basic")
    public BasicAuthConfig getBasic() {
        return basic;
    }

    @JsonProperty("basic")
    public void setBasic(BasicAuthConfig basic) {
        this.basic = basic;
    }

    /**
     * BearerTokenAuthConfig provides configuration to send an opaque value as a
     * bearer token. The value is referenced from the 'token' field of the given
     * secret. This value should only contain the token value and not the
     * `Bearer` scheme.
     */
    @JsonProperty("bearer")
    public BearerTokenAuthConfig getBearer() {
        return bearer;
    }

    @JsonProperty("bearer")
    public void setBearer(BearerTokenAuthConfig bearer) {
        this.bearer = bearer;
    }
    @Override
    public String toString() {
        return "ServiceBrokerAuthInfo [basic=" + basic + ", bearer=" + bearer + "]";
    }
}