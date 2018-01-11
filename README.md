# kubernetes-service-catalog-client
This is a Java Client for Kubernetes Service Catalog access. Using this library you can list Service Brokers, Service Instances in a given Service Broker, Provision a Service, Bind to a Service. This library is incomplete in terms of creating Service Brokers and some other functions but could be easily added based on the need.

Mainly take look at the following classes and usage is trivial.
```
ServiceCatalogClient
ModelServiceCatalogClient
```

# How to do a release
git pull upstream master
mvn -DautoVersionSubmodules=true -P release clean package release:prepare
mvn -P release release:perform
