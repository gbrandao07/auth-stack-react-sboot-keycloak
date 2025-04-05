import { useKeycloak } from "@react-keycloak/web";
import NotAuthenticated from "../components/NotAuthenticated";

const PrivateRoute = ({ children }) => {

    const { keycloak } = useKeycloak();

    const isLoggedIn = keycloak.authenticated;

    return isLoggedIn ? children : <NotAuthenticated />;
};

export default PrivateRoute;