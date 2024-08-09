# DevOps-Automation Project

# Assignment is mentioned below

## CI/CD Pipeline Development 
## Objective: 

Create a Continuous Integration/Continuous Deployment (CI/CD) pipeline using one of the specified tools (Jenkins, GitHub Actions, GitLab CI, AWS CodePipeline, GCP Cloud Build, or Azure Pipeline). The pipeline should automate the deployment of a containerized application to a Kubernetes cluster, ensuring that the application is accessible via a web browser. 

# Pipeline Stages: 

## Checkout Application Code: 
Retrieve the latest code from the version control system (e.g., GitHub, GitLab, BitBucket). 
## Code Analysis using SonarQube: 
Analyze the code quality and security vulnerabilities using SonarQube. 
(Optional) Fail the build if specified quality thresholds are not met.  

## Build Docker Image: 
Build a Docker image from the application code. 
Tag the image appropriately. 

## Push into Image Registry: 
Push the built Docker image to a specified public or private container image registry (e.g., Docker Hub, AWS ECR, GCP Container Registry). 

## Deploy into Kubernetes Cluster using ArgoCD: 
Use ArgoCD to deploy the Docker image to a Kubernetes cluster. 
The deployment should trigger automatically upon a new docker image tag being updated into deployment.yaml file. 

## Kubernetes Exposition: 
Configure Kubernetes services or an Ingress controller to expose the application. Ensure the application is accessible from the browser. 

# Technical Specifications: 
## Tools and Technologies: 
Choose a CI/CD tool suitable for your infrastructure and familiarity. 
Use Docker for containerization. 
Kubernetes for orchestration. 
ArgoCD for Kubernetes deployment synchronization. 
SonarQube for code quality and security analysis.


Prerequisite:
 1) Minikube setup on local -> [https://minikube.sigs.k8s.io/docs/start/?arch=%2Flinux%2Fx86-64%2Fstable%2Fbinary+download](https://minikube.sigs.k8s.io/docs/start/?arch=%2Flinux%2Fx86-64%2Fstable%2Fbinary+download)
 2) Setup Jenkins, Sonar
 3) Setup ArgoCD
     Some good resource links:
          1) Follow the below doc to setup ArgoCD
             https://medium.com/@eftech93/installing-argo-cd-on-minikube-gitops-with-argo-cd-c451d4a06459
             https://medium.com/@eftech93/deploying-a-chat-application-in-minikube-with-argo-cd-a-comprehensive-guide-a7e252fc38a0

             For Best CICD Project (jenkins, sonarqube, docker, kubernetes, argocd, image updater):
             https://www.youtube.com/watch?v=JGQI5pkK82w&t=2170s![image](https://github.com/user-attachments/assets/2997cc83-018e-4f50-ab90-c36e88715438)

   
Links to be opened
1) minikube start --force
2) http://localhost:8080/ -> jenkins 
3) http://localhost:9000/projects -> sonar, make sure sonaruqube container is up
     Command to make it up :
     docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 
5) kubectl port-forward svc/argocd-server -n argocd 8082:443

   Good Content still need to be added
