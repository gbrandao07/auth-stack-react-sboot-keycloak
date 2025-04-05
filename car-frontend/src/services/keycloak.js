import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
    url: "http://localhost:8999/",
    realm: "car-realm",
    clientId: "car-customer-client",
});

export default keycloak;