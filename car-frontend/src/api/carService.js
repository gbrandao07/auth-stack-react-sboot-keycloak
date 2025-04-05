import axiosInstance from './axiosConfig';

const getCars = async () => {
  try {
    const response = await axiosInstance.get('/cars');
    return response.data;
  } catch (error) {
    throw new Error(error.response?.data?.message || 'Erro ao buscar os carros');
  }
};

export { getCars };