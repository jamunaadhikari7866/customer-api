<!--
  Copyright 2025 Jamuna Adhikari

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->

Customer API – Spring Boot Docker Example
=========================================

This is a sample Spring Boot microservice to manage customer data via a REST API. It can be containerized and deployed using Docker, Kubernetes, and integrated with CI/CD tools. Includes a CLI client and observability support.

This is not an official Google product.

Building
========
Regular Maven build:

    mvn package

Build Docker container:

    docker build -t customer-api .

Running
=======
Java
----
Run locally:

    mvn spring-boot:run

Docker
------
Run API container:

    docker run -p 8080:8080 customer-api

Docker Compose
--------------
Navigate to the project root and use Docker Compose:

    docker-compose up

Kubernetes
----------
The following assumes you have a Kubernetes cluster running (e.g., via Minikube).

Navigate to the Kubernetes config folder:

    cd k8s

Apply resources:

    kubectl apply -f deployment.yaml
    kubectl apply -f service.yaml

Expose the service using:

    minikube service customer-api-service

CI/CD
-----
CI/CD is defined via GitHub Actions. On push to main:

- Builds
- Runs tests
- Optionally deploys Docker image

See: `.github/workflows/ci.yml`

Google App Engine (Optional)
----------------------------
If deploying to GAE using gcloud CLI:

1. Configure your Redis host in:
    `src/main/resources/application-gae.properties`

2. Build the Docker image:

    mvn package
    docker build -t gcr.io/YOUR_PROJECT_ID/customer-api .

3. Deploy using gcloud:

    gcloud app deploy
