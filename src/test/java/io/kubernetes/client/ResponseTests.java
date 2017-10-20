package io.kubernetes.client;

import java.io.IOException;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.junit.Test;


public class ResponseTests {
    String baseUrl = "https://172.17.0.1:8443";
    String apiVersion = "v1beta1";
    String authHeader = "bebfVwAh4IYNB8Lgzl1NqJukRVTO9ELYkPSdqSShzrM";
    
    @Test
    public void createBinding() throws IOException {
        JsonObjectBuilder payload = Json.createObjectBuilder()
                .add("apiVersion", "v1")
                .add("kind", "ServiceInstance")
                .add("metadata", Json.createObjectBuilder()
                    .add("name", "postgresql-persistent-tgzln")
                    .add("namespace", "myproject")
                    .add("uid", "c8d5a232-b4d2-11e7-bd47-0242ac110005"));
        JsonObject obj = ServiceCatalogClient.createBinding(baseUrl, apiVersion, authHeader, payload.build());
        System.out.println(obj);
    }
    
    @Test
    public void createServiceInstance() {
        Properties p = new Properties();
        p.setProperty("DATABASE_SERVICE_NAME", "postgresql");
        p.setProperty("MEMORY_LIMIT", "512Mi");
        p.setProperty("NAMESPACE", "openshift");
        p.setProperty("POSTGRESQL_DATABASE", "sampledb");
        p.setProperty("POSTGRESQL_PASSWORD", "user");
        p.setProperty("POSTGRESQL_USER", "user");
        p.setProperty("POSTGRESQL_VERSION", "9.5");
        p.setProperty("VOLUME_CAPACITY", "1Gi");

        String serviceClass = "postgresql-persistent";
        String servicePlan = "default";
        
        JsonObject obj = ServiceCatalogClient.createServiceInstance(baseUrl, apiVersion, authHeader,
                "Ramesh-postgresql", "myproject", serviceClass, servicePlan, p);
        System.out.println(obj);
        
    }
    
    @Test
    public void getServiceClasses() throws IOException {
        JsonObject obj = ServiceCatalogClient.getClusterServiceClasses(baseUrl, apiVersion, authHeader);
        System.out.println(obj);
    } 
    
    @Test
    public void getServicePlans() throws IOException {
        JsonObject obj = ServiceCatalogClient.getClusterServicePlans(baseUrl, apiVersion, authHeader,
                "80028d15-b4d1-11e7-a18b-c85b76df3a86");
        System.out.println(obj);
    }
    
    @Test
    public void getServiceInstances() throws IOException {
        JsonObject obj = ServiceCatalogClient.getServiceInstances(baseUrl, apiVersion, authHeader, "myproject");
        System.out.println(obj);
    }    
    
    @Test
    public void getServiceBindings() throws IOException {
        JsonObject obj = ServiceCatalogClient.getServiceBindings(baseUrl, apiVersion, authHeader, "myproject");
        System.out.println(obj);
    }     

    @Test
    public void deleteServiceBinding() throws IOException {
        JsonObject obj = ServiceCatalogClient.deleteServiceBinding(baseUrl, apiVersion, authHeader, "myproject",
                "postgresql-persistent-8m6gx-75cgx");
        System.out.println(obj);
    }   
    
    @Test
    public void deleteServiceInstance() throws IOException {
        JsonObject obj = ServiceCatalogClient.deleteServiceInstance(baseUrl, apiVersion, authHeader, "myproject",
                "postgresql-persistent-8m6gx");
        System.out.println(obj);
    }     
}
