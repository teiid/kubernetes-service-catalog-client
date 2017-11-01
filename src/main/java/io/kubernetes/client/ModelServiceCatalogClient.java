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

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelServiceCatalogClient {
    private String baseUrl;
    private String apiVersion;
    private String authHeader;

    public ModelServiceCatalogClient(String baseUrl, String apiVersion, String authHeader) {
        this.baseUrl = baseUrl;
        this.apiVersion = apiVersion;
        this.authHeader = authHeader;
    }

    public ClusterServiceBrokerList getClusterServiceBrokers() throws IOException {
        String response = ServiceCatalogClient.getClusterServiceBrokers(baseUrl, apiVersion, authHeader);
        return new ObjectMapper()
                .readerFor(ClusterServiceBrokerList.class)
                .readValue(response);
    }

    public ClusterServiceBroker getClusterServiceBrokerStatus(String serviceBrokerName) throws IOException {
        String response = ServiceCatalogClient.getClusterServiceBrokerStatus(baseUrl, apiVersion, authHeader,
                serviceBrokerName);
        return new ObjectMapper()
                .readerFor(ClusterServiceBroker.class)
                .readValue(response);
    }

    public ClusterServiceClassList getClusterServiceClasses() throws IOException {
        String response = ServiceCatalogClient.getClusterServiceClasses(baseUrl, apiVersion, authHeader);
        return new ObjectMapper()
                .readerFor(ClusterServiceClassList.class)
                .readValue(response);
    }

    public ClusterServicePlanList getClusterServicePlans() throws IOException {
        String response = ServiceCatalogClient.getClusterServicePlans(baseUrl, apiVersion, authHeader);
        return new ObjectMapper()
                .readerFor(ClusterServicePlanList.class)
                .readValue(response);
    }

    // TODO: this method seems wrong; needs to be plural
    public ClusterServicePlan getClusterServicePlan(ClusterServiceClass svcClass) throws IOException {
        String response = ServiceCatalogClient.getClusterServicePlans(baseUrl, apiVersion, authHeader,
                svcClass.getMetadata().getName());
        return new ObjectMapper()
                .readerFor(ClusterServicePlan.class)
                .readValue(response);
    }

    public ServiceInstanceList getServiceInstances(String namespace) throws IOException {
        String response = ServiceCatalogClient.getClusterServicePlans(baseUrl, apiVersion, authHeader,namespace);
        return new ObjectMapper()
                .readerFor(ServiceInstanceList.class)
                .readValue(response);
    }

    public ServiceInstance getServiceInstance(String namespace, String serviceName) throws IOException {
        String response = ServiceCatalogClient.getServiceInstance(baseUrl, apiVersion, authHeader,namespace, serviceName);
        return new ObjectMapper()
                .readerFor(ServiceInstanceList.class)
                .readValue(response);
    }

    public ServiceBindingList getServiceBindings(String namespace) throws IOException {
        String response = ServiceCatalogClient.getServiceBindings(baseUrl, apiVersion, authHeader,namespace);
        return new ObjectMapper()
                .readerFor(ServiceBindingList.class)
                .readValue(response);
    }

    public ServiceBinding getServiceBinding(String namespace, String bindingName) throws IOException {
        String response = ServiceCatalogClient.getServiceBinding(baseUrl, apiVersion, authHeader,namespace, bindingName);
        return new ObjectMapper()
                .readerFor(ServiceBinding.class)
                .readValue(response);
    }
}

