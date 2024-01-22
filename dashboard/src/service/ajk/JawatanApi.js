import axios from 'axios'
import { config } from '../../Config'
const apiServer = config.url.AJK_API_BASE_URL

export const saveJawatan = async (jawatan) => {
  const response = await axios.post(`${apiServer}/jawatan/new`, jawatan)
  return response.data
}

export const searchJawatan = async () => {
  const response = await axios.get(`${apiServer}/jawatan/all`)
  return response.data
}

export const searchJawatanByTagId = async (id) => {
  const response = await axios.get(`${apiServer}/jawatan/${id}`)
  return response.data
}

export const updateJawatan = async (id) => {
  const response = await axios.put(`${apiServer}/jawatan/${id}`)
  return response.data
}

export const deleteJawatan = async (id) => {
  const response = await axios.delete(`${apiServer}/jawatan/${id}`)
  return response.data
}
