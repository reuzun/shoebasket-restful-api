import axios from "axios";

export default class ShoeService {

    getRandomShoes() {
        return axios.get("http://localhost:8080/api/models/list");
    }

}