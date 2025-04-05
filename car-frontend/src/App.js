import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { ReactKeycloakProvider } from "@react-keycloak/web";
import WelcomePage from './components/WelcomePage';
import keycloak from "./services/keycloak";
import MainPage from './components/MainPage';
import PrivateRoute from './helpers/PrivateRoute';



function App() {
  return (
    <ReactKeycloakProvider authClient={keycloak}>
      <Router>
        <Routes>
          <Route path="/" element={<WelcomePage />} />
          <Route path="/list" element={
              <PrivateRoute>
                <MainPage />
              </PrivateRoute>
            }
          />
        </Routes>
      </Router>
    </ReactKeycloakProvider>
  );
}

export default App;