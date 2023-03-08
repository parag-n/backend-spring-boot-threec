import { BsPersonCircle as PersonFill } from "react-icons/bs"
import { useDispatch, useSelector } from "react-redux"
import { Link, useNavigate } from "react-router-dom"

export default function TCNavbar() {

    let logoutDis=useDispatch();

    let navi=useNavigate();

    let logout=()=>{
        navi("/login", "successfully logged out");
        logoutDis({type:"logout", consumer:{consumerId:0}, user:false})
    }

    let user=useSelector((state)=>{
        // return state.user;               // this line is causing the problem
    });
    return (
        <div style={{ backgroundColor: "rgb(157, 192, 139)" }}>

            {/* Navigation bar */}
            <nav className="navbar navbar-expand-lg navbar-light bg-light pt-3 pb-3" >

                <div className="container-fluid mx-4">
                    <Link to={"/"} className="navbar-brand">Connect Contact Conduct</Link>
                    <Link to={"/"} className="nav-link active">Home</Link>
                    <Link to={"/register"} className="btn btn-warning me-2">Register</Link>
                    <Link to={"/login"} className="btn btn-warning me-2">Login</Link>
                    <Link to={"/myaccount"} ><PersonFill size="2em"></PersonFill></Link>
                    <Link to={"/spregister"} className="btn btn-warning">SP REG</Link>

                    <button className="btn btn-danger" onClick={logout}>Logout</button>
                        
                </div>
            </nav>
        </div>
    )
}