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

@JsonIgnoreProperties(ignoreUnknown=true)
public class OwnerReferences {
	private String apiVersion;
	private String kind;
	private String name;
	private String uid;
	private boolean controller;
	private boolean blockOwnerDeletion;
	
    @JsonProperty("apiVersion")
	public String getApiVersion() {
		return apiVersion;
	}
    
    @JsonProperty("apiVersion")
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
    
    @JsonProperty("kind")
	public String getKind() {
		return kind;
	}
    
    @JsonProperty("kind")
	public void setKind(String kind) {
		this.kind = kind;
	}
    
    @JsonProperty("name")
	public String getName() {
		return name;
	}
    
    @JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
    
    @JsonProperty("uid")
	public String getUid() {
		return uid;
	}
    
    @JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}
    
    @JsonProperty("controller")
	public boolean isController() {
		return controller;
	}
    
    @JsonProperty("controller")
	public void setController(boolean controller) {
		this.controller = controller;
	}
    
    @JsonProperty("blockOwnerDeletion")
	public boolean isBlockOwnerDeletion() {
		return blockOwnerDeletion;
	}
    
    @JsonProperty("blockOwnerDeletion")
	public void setBlockOwnerDeletion(boolean blockOwnerDeletion) {
		this.blockOwnerDeletion = blockOwnerDeletion;
	}

	@Override
	public String toString() {
		return "OwnerReferences [apiVersion=" + apiVersion + ", kind=" + kind + ", name=" + name + ", uid=" + uid
				+ ", controller=" + controller + ", blockOwnerDeletion=" + blockOwnerDeletion + "]";
	}
}
