import { Link } from "react-router-dom";
import TCRegister from "./TCRegisterConsumer";

export default function TCBtnRegConsumer(){
    return(
        <Link className="btn btn-primary" to={<TCRegister></TCRegister>}></Link>
    )
}