#!/bin/bash
mvn clean package
native-image -jar target/app-1.0-SNAPSHOT.jar