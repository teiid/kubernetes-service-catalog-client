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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SecretMetadata extends Metadata {
    private List<OwnerReferences> ownerReferences;

    @JsonProperty("ownerReferences")
	public List<OwnerReferences> getOwnerReferences() {
		return ownerReferences;
	}

    @JsonProperty("ownerReferences")
	public void setOwnerReferences(List<OwnerReferences> ownerReferences) {
		this.ownerReferences = ownerReferences;
	}

	@Override
	public String toString() {
		return "SecretMetadata [ownerReferences=" + ownerReferences + ", toString()=" + super.toString() + "]";
	}


}