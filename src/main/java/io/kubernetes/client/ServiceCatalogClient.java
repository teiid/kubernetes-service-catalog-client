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
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.UUID;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

public class ServiceCatalogClient {

    public static String getClusterServiceBrokers(String baseUrl, String apiVersion, String authHeader) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/clusterservicebrokers";
        return executeGET(url, authHeader);
    }

    public static String getClusterServiceBrokerStatus(String baseUrl, String apiVersion, String authHeader,
            String serviceBrokerName) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/clusterservicebrokers/"
                + serviceBrokerName + "/status";
        return executeGET(url, authHeader);
    }

    public static String getClusterServiceClasses(String baseUrl, String apiVersion, String authHeader) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/clusterserviceclasses";
        return executeGET(url, authHeader);
    }

    public static String getClusterServicePlans(String baseUrl, String apiVersion, String authHeader) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/"+apiVersion+"/clusterserviceplans";
        return executeGET(url, authHeader);
    }

    public static String getClusterServicePlans(String baseUrl, String apiVersion, String authHeader,
            String serviceClass) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/"+apiVersion+"/clusterserviceplans/"+serviceClass;
        return executeGET(url, authHeader);
    }

    public static String getServiceInstance(String baseUrl, String apiVersion, String authHeader, String namespace,
            String serviceName) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/serviceinstances/" + serviceName;
        return executeGET(url, authHeader);
    }

    public static String getServiceInstances(String baseUrl, String apiVersion, String authHeader,
            String namespace) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/serviceinstances";
        return executeGET(url, authHeader);
    }

    public static String getServiceBindings(String baseUrl, String apiVersion, String authHeader,
            String namespace) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/servicebindings";
        return executeGET(url, authHeader);
    }

    public static String getServiceBinding(String baseUrl, String apiVersion, String authHeader,
            String namespace, String bindingName) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/servicebindings/"+bindingName;
        return executeGET(url, authHeader);
    }

    //    private static JsonObject readExecute(String url, String authHeader) {
    //        try {
    //            CloseableHttpClient client = buildHttpClient();
    //            HttpGet request = new HttpGet(url);
    //            request.addHeader("Authorization", bearer(authHeader));
    //            HttpResponse response = client.execute(request);
    //            if (response.getStatusLine().getStatusCode() != 200) {
    //                throw new RuntimeException(response.getStatusLine().getReasonPhrase());
    //            }
    //            JsonReader jsonReader = Json.createReader(response.getEntity().getContent());
    //            JsonObject result = jsonReader.readObject();
    //            jsonReader.close();
    //            return result;
    //        } catch (UnsupportedOperationException | IOException | KeyManagementException | NoSuchAlgorithmException
    //                | KeyStoreException e) {
    //            throw new RuntimeException(e);
    //        }
    //    }

    private static String executeGET(String url, String authHeader) {
        try {
            CloseableHttpClient client = buildHttpClient();
            HttpGet request = new HttpGet(url);
            request.addHeader("Authorization", bearer(authHeader));
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(response.getStatusLine().getReasonPhrase());
            }
            BasicResponseHandler handler = new BasicResponseHandler();
            return handler.handleResponse(response);
        } catch (UnsupportedOperationException | IOException | KeyManagementException | NoSuchAlgorithmException
                | KeyStoreException e) {
            throw new RuntimeException(e);
        }
    }

    private static JsonObject deleteExecute(String url, String authHeader) {
        try {
            CloseableHttpClient client = buildHttpClient();
            HttpDelete request = new HttpDelete(url);
            request.addHeader("Authorization", bearer(authHeader));
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(response.getStatusLine().getReasonPhrase());
            }
            JsonReader jsonReader = Json.createReader(response.getEntity().getContent());
            JsonObject result = jsonReader.readObject();
            jsonReader.close();
            return result;
        } catch (UnsupportedOperationException | IOException | KeyManagementException | NoSuchAlgorithmException
                | KeyStoreException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bearer(String auth) {
        return "bearer " + auth;
    }

    public static JsonObject createServiceInstance(String baseUrl, String apiVersion, String authHeader, String name,
            String namespace, String serviceClassName, String planName, Properties properties) {

        String version = "servicecatalog.k8s.io/"+apiVersion;
        String secretName = serviceClassName + "-parameters-"+UUID.randomUUID().toString().substring(0, 5);
        if (properties == null || properties.isEmpty()) {
            secretName = null;
        }

        JsonObjectBuilder payload = Json.createObjectBuilder()
                .add("apiVersion", version)
                .add("kind", "ServiceInstance")
                .add("metadata", Json.createObjectBuilder()
                        .add("generateName", serviceClassName+"-")
                        .add("namespace", namespace));
        JsonObjectBuilder spec = Json.createObjectBuilder()
                .add("externalClusterServiceClassName", serviceClassName)
                .add("externalClusterServicePlanName", planName);
        if (secretName != null) {
            spec.add("parametersFrom", Json.createArrayBuilder().add(Json.createObjectBuilder()
                    .add("secretKeyRef", Json.createObjectBuilder()
                            .add("name", secretName)
                            .add("key", "parameters"))));
        }
        payload.add("spec", spec);
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/serviceinstances";
        JsonObject serviceInstance = executeCreate(authHeader, payload.build(), url);
        createServiceInstanceSecret(baseUrl, authHeader, secretName, version, serviceInstance, properties);
        return serviceInstance;
    }

    public static JsonObject deleteServiceInstance(String baseUrl, String apiVersion, String authHeader,
            String namespace, String serviceInstanceName) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/serviceinstances/"+serviceInstanceName;
        return deleteExecute(url, authHeader);
    }

    private static JsonObject executeCreate(String authHeader, JsonObject payload, String url) {
        try {
            System.out.println("URL = " + url);
            System.out.println("PAYLOAD = " + payload);

            CloseableHttpClient client = buildHttpClient();
            HttpPost request = new HttpPost(url);
            HttpEntity payloadEntity = new StringEntity(payload.toString(), "UTF-8");
            request.setEntity(payloadEntity);
            request.addHeader("Authorization", bearer(authHeader));
            request.addHeader("Content-Type", "application/json");

            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException(response.getStatusLine().getReasonPhrase());
            }
            JsonReader jsonReader = Json.createReader(response.getEntity().getContent());
            JsonObject result = jsonReader.readObject();
            jsonReader.close();
            System.out.println("RESPONSE = "+result);
            return result;
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException | UnsupportedOperationException
                | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static JsonObject createServiceInstanceSecret(String baseUrl, String authHeader, String secretName, String version,
            JsonObject serviceInstance, Properties properties) {
        JsonObjectBuilder parametersJson = Json.createObjectBuilder();
        for (String key:properties.stringPropertyNames()) {
            parametersJson.add(key, properties.getProperty(key));
        }
        String serviceInstanceName = serviceInstance.getJsonObject("metadata").getString("name");
        String serviceInstanceUid = serviceInstance.getJsonObject("metadata").getString("uid");
        String namespace = serviceInstance.getJsonObject("metadata").getString("namespace");

        JsonObjectBuilder payload = Json.createObjectBuilder()
                .add("apiVersion", "v1")
                .add("kind", "Secret")
                .add("metadata", Json.createObjectBuilder()
                        .add("name", secretName)
                        .add("namespace", namespace)
                        .add("ownerReferences", Json.createArrayBuilder().add(Json.createObjectBuilder()
                                .add("apiVersion", version)
                                .add("kind", "ServiceInstance")
                                .add("name", serviceInstanceName)
                                .add("uid", serviceInstanceUid)
                                .add("controller", Boolean.FALSE)
                                .add("blockOwnerDeletion", Boolean.FALSE)))
                        )
                .add("type", "Opaque")
                .add("stringData", Json.createObjectBuilder()
                        .add("parameters", parametersJson.build().toString()));

        String url = baseUrl + "/api/v1/namespaces/"+namespace+"/secrets";
        return executeCreate(authHeader, payload.build(), url);
    }

    public static JsonObject createBinding(String baseUrl, String apiVersion, String authHeader,
            JsonObject serviceInstance) {

        String version = "servicecatalog.k8s.io/"+apiVersion;
        String serviceInstanceName = serviceInstance.getJsonObject("metadata").getString("name");
        String namespace = serviceInstance.getJsonObject("metadata").getString("namespace");
        String secretName = serviceInstanceName + "-credentials-"+UUID.randomUUID().toString().substring(0, 5);

        JsonObjectBuilder payload = Json.createObjectBuilder()
                .add("apiVersion", version)
                .add("kind", "ServiceBinding")
                .add("metadata", Json.createObjectBuilder().add("generateName", serviceInstanceName+"-"));
        JsonObjectBuilder spec = Json.createObjectBuilder()
                .add("instanceRef", Json.createObjectBuilder().add("name", serviceInstanceName))
                .add("secretName", secretName);
        payload.add("spec", spec);
        if (secretName != null) {
            spec.add("parametersFrom", Json.createArrayBuilder().add(Json.createObjectBuilder()
                    .add("secretKeyRef", Json.createObjectBuilder()
                            .add("name", secretName)
                            .add("key", "parameters"))));
        }

        String url = baseUrl + "/apis/servicecatalog.k8s.io/"+apiVersion+"/namespaces/"+namespace+"/servicebindings";
        JsonObject serviceBinding =  executeCreate(authHeader, payload.build(), url);
        return serviceBinding;
    }

    public static JsonObject deleteServiceBinding(String baseUrl, String apiVersion, String authHeader,
            String namespace, String bindingName) {
        String url = baseUrl + "/apis/servicecatalog.k8s.io/" + apiVersion + "/namespaces/" + namespace
                + "/servicebindings/"+bindingName;
        return deleteExecute(url, authHeader);
    }

    private static CloseableHttpClient buildHttpClient()
            throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
        // no verification of host for now.
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true)
                .build();

        CloseableHttpClient client = HttpClients.custom().setSSLContext(sslContext)
                .setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        return client;
    }

    public static class Status {
        public String status;
        public String lastTransitionTime;
        public String reason;
        public String message;
    }

    public static Status checkStatus(JsonObject json) {
        if (json == null) {
            return null;
        }
        JsonObject status = json.getJsonObject("status");
        if (status == null) {
            return null;
        }

        JsonArray conditions = status.getJsonArray("conditions");
        if (conditions == null || conditions.isEmpty()) {
            return null;
        }

        for (int i = 0; i < conditions.size(); i++) {
            JsonObject condition = conditions.getJsonObject(i);
            String type = condition.getString("type");
            if (type != null && type.equals("Ready")) {
                ServiceCatalogClient.Status s = new Status();
                s.status = condition.getString("status");
                s.lastTransitionTime = condition.getString("lastTransitionTime");
                s.reason = condition.getString("reason");
                s.message = condition.getString("message");
                return s;
            }
        }
        return null;
    }
}
