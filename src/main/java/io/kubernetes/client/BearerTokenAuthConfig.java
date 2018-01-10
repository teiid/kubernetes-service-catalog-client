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
 * BearerTokenAuthConfig provides config for the bearer token authentication.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class BearerTokenAuthConfig {
    private ObjectReference secretRef;

    /**
     * SecretRef is a reference to a Secret containing information the catalog
     * should use to authenticate to this ServiceBroker. Required field:
     *  - Secret.Data["token"] - bearer token for authentication
     *  @return ObjectReference
     */
    @JsonProperty("secretRef")
    public ObjectReference getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(ObjectReference secretRef) {
        this.secretRef = secretRef;
    }

    @Override
    public String toString() {
        return "BearerTokenAuthConfig [secretRef=" + secretRef + "]";
    }
}