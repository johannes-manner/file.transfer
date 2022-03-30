# Web Service for Transferring Files

This is a simple dockerized web service for transferring requested files to the caller implemented with SpringBoot.

Via `HOST:PORT/v1/files?name=linpack-openfaas-100-0.log` a user can request any file which is included in the build context of the corresponding container.
Application properties allow to override the server port (default 9090) and the calibration path (default /usr/calibration within the containers filesystem).
There is no mount to the host's filesystem to provide data access restrictions. 
A user of this service has to copy the files to the build context before building the container (see the Dockerfile).
