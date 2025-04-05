import '../style/WelcomePage.css';
import CarPng from './../resources/car.png';
import Header from './Header';

function WelcomePage() {

    return (
        <div className="container">
            <Header />
            <div className="content">
                <p>Encontre seu próximo carro aqui!</p>
                <img src={CarPng} alt="Carros" style={{width: 750, height: 300}} />
            </div>
        </div>
    );
}

export default WelcomePage;