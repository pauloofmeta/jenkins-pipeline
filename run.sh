#!/bin/bash

echo "Setting the maximum number of memory map areas a process may have"
sudo sysctl -w vm.max_map_count=262144

echo "Starting the docker containers"
docker compose up -d