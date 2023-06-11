# ht-backend-task

This backend app for Shipment Tracking was written in Java Spring Boot given the swagger.yaml configuration.
All defined models and requested CRUD mappings are implemented as given.

### Test

On every run the database is initialized and filled up with mock data.
In `test/resources` there are examples of possible Patch and Post request that can be run as well as an url example that will filter all Shipment Trackings between certain dates.
Furthermore there are tests for both Shipment Tracking Controller and Service implemented in the `test` directory.

### Usage

To run the app with its database there is a defined docker-compose.yml file.
Position yourself into the root of project and run the command `docker compose up`.
The app is then exposed on port `8080` and you can send the defined CRUD requests on it.
