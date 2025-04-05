import axios from 'axios';

const axiosCarInstance = axios.create({
  baseURL: 'http://localhost:8120/api',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Interceptor
axiosCarInstance.interceptors.request.use(
  (config) => {

    const accessToken = localStorage.getItem('accessToken');

    // Adiciona o token de acesso ao cabeçalho da requisição
    if (accessToken) {
      config.headers['Authorization'] = `Bearer ${accessToken}`;
    }
    
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

axiosCarInstance.interceptors.response.use(
  (response) => response,
  (error) => {
    return Promise.reject(error);
  }
);

export default axiosCarInstance;