package io.kubernetes.client;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.*;

public class ParserTests {

	@Test
	public void testServiceInstanceList() throws Exception {
		String response = "{" + 
				"   \"kind\":\"ServiceInstanceList\"," + 
				"   \"apiVersion\":\"servicecatalog.k8s.io/v1beta1\"," + 
				"   \"metadata\":{" + 
				"      \"selfLink\":\"/apis/servicecatalog.k8s.io/v1beta1/namespaces/myproject/serviceinstances\"," + 
				"      \"resourceVersion\":\"121\"" + 
				"   }," + 
				"   \"items\":[" + 
				"      {" + 
				"         \"metadata\":{" + 
				"            \"name\":\"postgresql-persistent-bjwrf\"," + 
				"            \"generateName\":\"postgresql-persistent-\"," + 
				"            \"namespace\":\"myproject\"," + 
				"            \"selfLink\":\"/apis/servicecatalog.k8s.io/v1beta1/namespaces/myproject/serviceinstances/postgresql-persistent-bjwrf\"," + 
				"            \"uid\":\"d6ea4d5d-ddec-11e7-ba7e-0242ac110002\"," + 
				"            \"resourceVersion\":\"106\"," + 
				"            \"generation\":1," + 
				"            \"creationTimestamp\":\"2017-12-10T20:58:14Z\"," + 
				"            \"finalizers\":[" + 
				"               \"kubernetes-incubator/service-catalog\"" + 
				"            ]" + 
				"         }," + 
				"         \"spec\":{" + 
				"            \"clusterServiceClassExternalName\":\"postgresql-persistent\"," + 
				"            \"clusterServicePlanExternalName\":\"default\"," + 
				"            \"clusterServiceClassRef\":{" + 
				"               \"name\":\"64adb927-ddd4-11e7-8adc-b288dc85dfe9\"" + 
				"            }," + 
				"            \"clusterServicePlanRef\":{" + 
				"               \"name\":\"64adb927-ddd4-11e7-8adc-b288dc85dfe9\"" + 
				"            }," + 
				"            \"parametersFrom\":[" + 
				"               {" + 
				"                  \"secretKeyRef\":{" + 
				"                     \"name\":\"postgresql-persistent-parametersztvvm\"," + 
				"                     \"key\":\"parameters\"" + 
				"                  }" + 
				"               }" + 
				"            ]," + 
				"            \"externalID\":\"61c293bb-f413-4440-9579-a9c248c5f24c\"," + 
				"            \"userInfo\":{" + 
				"               \"username\":\"admin\"," + 
				"               \"uid\":\"\"," + 
				"               \"groups\":[" + 
				"                  \"system:authenticated:oauth\"," + 
				"                  \"system:authenticated\"" + 
				"               ]," + 
				"               \"extra\":{" + 
				"                  \"scopes.authorization.openshift.io\":[" + 
				"                     \"user:full\"" + 
				"                  ]" + 
				"               }" + 
				"            }," + 
				"            \"updateRequests\":0" + 
				"         }," + 
				"         \"status\":{" + 
				"            \"conditions\":[" + 
				"               {" + 
				"                  \"type\":\"Ready\"," + 
				"                  \"status\":\"True\"," + 
				"                  \"lastTransitionTime\":\"2017-12-10T20:58:48Z\"," + 
				"                  \"reason\":\"ProvisionedSuccessfully\"," + 
				"                  \"message\":\"The instance was provisioned successfully\"" + 
				"               }" + 
				"            ]," + 
				"            \"asyncOpInProgress\":false," + 
				"            \"orphanMitigationInProgress\":false," + 
				"            \"reconciledGeneration\":1," + 
				"            \"externalProperties\":{" + 
				"               \"clusterServicePlanExternalName\":\"default\"," + 
				"               \"clusterServicePlanExternalID\":\"64adb927-ddd4-11e7-8adc-b288dc85dfe9\"," + 
				"               \"parameters\":{" + 
				"                  \"DATABASE_SERVICE_NAME\":\"\\u003credacted\\u003e\"," + 
				"                  \"MEMORY_LIMIT\":\"\\u003credacted\\u003e\"," + 
				"                  \"NAMESPACE\":\"\\u003credacted\\u003e\"," + 
				"                  \"POSTGRESQL_DATABASE\":\"\\u003credacted\\u003e\"," + 
				"                  \"POSTGRESQL_VERSION\":\"\\u003credacted\\u003e\"," + 
				"                  \"VOLUME_CAPACITY\":\"\\u003credacted\\u003e\"" + 
				"               }," + 
				"               \"parameterChecksum\":\"3ac3e630964e28334c74c7e8ec5a57eaa669244f3009907d7d93da6b49069211\"," + 
				"               \"userInfo\":{" + 
				"                  \"username\":\"admin\"," + 
				"                  \"uid\":\"\"," + 
				"                  \"groups\":[" + 
				"                     \"system:authenticated:oauth\"," + 
				"                     \"system:authenticated\"" + 
				"                  ]," + 
				"                  \"extra\":{" + 
				"                     \"scopes.authorization.openshift.io\":[" + 
				"                        \"user:full\"" + 
				"                     ]" + 
				"                  }" + 
				"               }" + 
				"            }," + 
				"            \"deprovisionStatus\":\"Required\"" + 
				"         }" + 
				"      }" + 
				"   ]" + 
				"}";
		
        ServiceInstanceList list = new ObjectMapper()
                .readerFor(ServiceInstanceList.class)
                .readValue(response);
        
        ServiceInstance si = list.getItems().get(0);
        assertTrue(si.getStatus().isReady());
	}

}
