import React,  {useEffect} from 'react';
import '../style/WelcomePage.css';
import { useKeycloak } from "@react-keycloak/web";

function Header() {

    const { keycloak } = useKeycloak();

    useEffect(() => {
        if (keycloak && keycloak.token) {
            localStorage.setItem('accessToken', keycloak.token);
        }
    }, [keycloak.token]);

    return (
        <div className="header">
            <h1>Lista de Carros</h1>
            <div className="buttons">
                {!keycloak.authenticated && (
                    <button
                        type="button"
                        className="btn"
                        onClick={() => keycloak.register({ redirectUri: window.location.origin + "/list" })}
                    >
                        Cadastrar
                    </button>
                )}
                {!keycloak.authenticated && (
                    <button
                        type="button"
                        className="btn"
                        onClick={() =>  keycloak.login({ redirectUri: window.location.origin + "/list" })}
                    >
                        Login
                    </button>
                )}
                {!!keycloak.authenticated && (
                    <button
                        type="button"
                        className="btn"
                        onClick={() => keycloak.logout()}
                    >
                        Logout ({keycloak.tokenParsed.preferred_username})
                    </button>
                )}
            </div>
        </div>
    )
}


export default Header;