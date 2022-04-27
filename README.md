# geoforceapp
REST service for geoforce app


## How it works:
### **1. Docker. First, you need to install docker**
* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on windows and restart;
* Then open powershell and check:
```bash
docker info
```
or check docker version
```bash
docker -v
```
or docker compose version
```bash
docker-compose -v
```
### **2. Spring boot app**
* Clone the repository:
```bash
git clone https://github.com/niiMarrion/geoforceapp.git
```
* Build the maven project:
```bash
mvn clean install
```
* Running the containers:
  
This command will build the docker containers and start them.
```bash
docker-compose up
```
or

This is a similar command as above, except it will run all the processes in the background.
```bash
docker-compose -f docker-compose.yml up
```

Appendix A.

All commands should be run from project root (where docker-compose.yml locates)

* If you have to want to see running containers. Checklist docker containers
```bash
docker container list -a
```
or
```bash
docker-compose ps
```

![Screenshot docker containers list](/images/screenshot1.png)
*Screenshot with runnings containers*


Go to [http://localhost:8088/demo/api/automobiles](http://localhost:8080/api/locations) to test and would specify OAuth 2.0 authorization redirect a username: `oleg` and password: `admin` 

* GET request to `/api/locations/` returns a list of "locations";
* GET request to `/api/locations/1` returns the "location" with ID 1;
* POST request to `/api/locations/` with a "location" object as JSON creates a new "location";
* PUT request to `/api/locations/3` with a "location" object as JSON updates the "location" with ID 3;
* DELETE request to `/api/locations/4` deletes the "location" with ID 4;
* DELETE request to `/api/locations/` deletes all the "locations".
* GET request to `/api/advertisement/{latitude}/{longitude}` returns a list of "advertisement by longitude and latitude";
*  GET request to `/api//advertisement/{id}` returns the "advertisement" with ID 1;
*   DELETE request to `/api/advertisement/{id}' deletes the "advertisement" with ID ;
*   PUT request to `/api/advertisement/{id}3` with a "advertisement" object as JSON updates the "advertisement" with ID ;
*   POST request to `/api//location/{locationId}/advertisement` with an "advertisement" object as JSON creates a new "advertisement";


* To access the pg4Admin use http://localhost:5050/ with username and password provided in the docker-compose file.



### **4. Docker control commands**
* Check all the images you have:
```bash
docker images
```
### **5. End stop app**
*  Stop containers:
```bash
docker-compose down
```
* Remove old stopped containers of docker-compose
```bash
docker-compose rm -f
```



