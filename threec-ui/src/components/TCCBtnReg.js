import { Link } from "react-router-dom";
import TCCRegister from "./TCCRegister";

export default function TCCBtnReg(){
    return(
        <Link className="btn btn-primary" to={<TCCRegister></TCCRegister>}></Link>
    )
}