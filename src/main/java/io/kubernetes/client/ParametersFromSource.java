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

/**
 * // ParametersFromSource represents the source of a set of Parameters
 *
 *
 */
public class ParametersFromSource {
    private SecretKeyReference secretKeyRef;

    /**
     * // The Secret key to select from. // The value must be a JSON object.
     * //+optional
     *
     * @return
     */
    @JsonProperty("secretKeyRef")
    public SecretKeyReference getSecretKeyRef() {
        return secretKeyRef;
    }

    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(SecretKeyReference secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }
}
