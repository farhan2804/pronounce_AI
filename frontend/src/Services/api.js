import axios from "axios";

const API = axios.create({
  baseURL: "https://pronounceai-production-fe5d.up.railway.app/api",
});
export default API;
