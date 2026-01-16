import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_URL || '/api'

export const getPhotos = async () => {
  const response = await axios.get(`${API_BASE_URL}/photos`)
  return response.data
}

export const getPhoto = async (id) => {
  const response = await axios.get(`${API_BASE_URL}/photos/${id}`)
  return response.data
}

export const uploadPhoto = async (formData) => {
  const response = await axios.post(`${API_BASE_URL}/photos`, formData)
  return response.data
}

export const deletePhoto = async (id) => {
  await axios.delete(`${API_BASE_URL}/photos/${id}`)
}
