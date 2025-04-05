import React, { useState, useEffect } from 'react';
import '../style/MainPage.css';
import { useKeycloak } from "@react-keycloak/web";
import Header from './Header';
import ReactJson from 'react-json-view';
import { getCars } from '../api/carService';


function MainPage() {
    const { keycloak } = useKeycloak();

    const shouldExpandNode = (keyName, data, level) => {
        return true; // Retorna true para expandir todos os nós
    };

    const [cars, setCars] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const carsData = await getCars();
                setCars(carsData);
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, []);

    return (
        <div className="container">
            <Header />
            <div className="container-sec">
                <h2>Carros:</h2>
                <div className="car-list-container">
                    <div className="car-list">
                        {cars.map(car => (
                            <div className="car-card" key={car.id}>
                                <h3>{car.name}</h3>
                                <p><strong>Ano:</strong> {car.year}</p>
                            </div>
                        ))}
                    </div>
                </div>
                <h2>Tokens:</h2>
                <div className="token">
                    <strong>Access Token:</strong>
                    <br />
                    <br />
                    <big>{keycloak.token}</big>
                </div>
                <div className="token">
                    <strong>Decoded Access Token:</strong>
                    <br />
                    <br />
                    <ReactJson src={JSON.parse(atob(keycloak.token.split('.')[1]))} shouldExpandNode={shouldExpandNode} />
                </div>
                <div className="token">
                    <strong>Refresh Token:</strong>
                    <br />
                    <br />
                    <big>{keycloak.refreshToken}</big>
                </div>
                <div className="token">
                    <strong>Decoded Refresh Token:</strong>
                    <br />
                    <br />
                    <ReactJson src={JSON.parse(atob(keycloak.refreshToken.split('.')[1]))} shouldExpandNode={shouldExpandNode} />
                </div>
            </div>
        </div>
    );
}

export default MainPage;