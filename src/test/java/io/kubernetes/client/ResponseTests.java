package io.kubernetes.client;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;


public class ResponseTests {
    String baseUrl = "https://192.168.42.29:8443";
    String apiVersion = "v1beta1";
    String authHeader = "YuwfKfQkEN8uTeeBoK6yEGq0oDboNvzxAndmq_jDD8Y";

    @Test
    public void createBinding() throws IOException {
		String obj = ServiceCatalogClient.createBinding(baseUrl, apiVersion, authHeader, "postgresql-persistent-n7jm8",
				"test");
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

        String obj = ServiceCatalogClient.createServiceInstance(baseUrl, apiVersion, authHeader,
                "foo-postgresql", "myproject", serviceClass, servicePlan, p);
        System.out.println(obj);

    }

    @Test
    public void getServiceClasses() throws IOException {
        String obj = ServiceCatalogClient.getClusterServiceClasses(baseUrl, apiVersion, authHeader);
        System.out.println(obj);
    }

    @Test
    public void getServicePlans() throws IOException {
        String obj = ServiceCatalogClient.getClusterServicePlan(baseUrl, apiVersion, authHeader,
                "80028d15-b4d1-11e7-a18b-c85b76df3a86");
        System.out.println(obj);
    }

    @Test
    public void getServiceInstances() throws IOException {
        String obj = ServiceCatalogClient.getServiceInstances(baseUrl, apiVersion, authHeader, "myproject");
        System.out.println(obj);
    }

    @Test
    public void getServiceBindings() throws IOException {
        String obj = ServiceCatalogClient.getServiceBindings(baseUrl, apiVersion, authHeader, "myproject");
        System.out.println(obj);
    }

    @Test
    public void deleteServiceBinding() throws IOException {
        String obj = ServiceCatalogClient.deleteServiceBinding(baseUrl, apiVersion, authHeader, "myproject",
                "postgresql-persistent-8m6gx-75cgx");
        System.out.println(obj);
    }

    @Test
    public void deleteServiceInstance() throws IOException {
        String obj = ServiceCatalogClient.deleteServiceInstance(baseUrl, apiVersion, authHeader, "myproject",
                "postgresql-persistent-8m6gx");
        System.out.println(obj);
    }

    @Test
    public void testClusterServiceBrokers() throws Exception {
        ModelServiceCatalogClient client = new ModelServiceCatalogClient(baseUrl, apiVersion, authHeader);
        ClusterServiceClassList list = client.getClusterServiceClasses();
        ServiceBindingList plans = client.getServiceBindings("myproject");
        System.out.println(plans);
    }
    
    @Test
    public void testSecret() throws IOException {
        ModelServiceCatalogClient client = new ModelServiceCatalogClient(baseUrl, apiVersion, authHeader);
        Secret s = client.getSecret("myproject", "postgresql-persistent-parametersf73b4");
        System.out.println(s);
    }    
}
