
# DevOps-Automation
HandsOn Project regarding 
 1) Checkout of the code
 2) Code Analysis using SonarQube
 3) Building and creating the image of application using docker
 4) Pushing the image to the docker registry i.e. dockerhub
 5) Updating the deployment file in the repo with the new image
 6) Deploying to kubernetes using ArgoCD

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
3) http://localhost:9000/projects -> sonar make sure, sonaruqube container is up
   Command to make it up :
   docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 
4) kubectl port-forward svc/argocd-server -n argocd 8082:443
