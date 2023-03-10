import { BsPersonCircle as PersonFill } from "react-icons/bs"
import { Link, useNavigate } from "react-router-dom"
import { useDispatch, useSelector } from "react-redux"


export default function TCBtnLoggedIn() {

    // method to dispatch the logout flag
    let logoutDis = useDispatch();

    // method to check if the user is logged in or not
    let userflag = useSelector((state) => {return state.user;});

    let who=useSelector((state)=>{
        if(state.consumer.consumerId===0) return "sp"
        else return "consumer";
    })

    // method to navigate user to another component
    let navi = useNavigate();

    // handler to dispatch logout flag
    let logout = () => {
        navi("/login", "successfully logged out");
        logoutDis({ type: "logout", consumer: { consumerId: 0 }, user: false })
    }

    return (
        <div className="btn">
            {
                userflag ?
                    <>
                    <select className="select">
                        <option>Hello 1</option>
                        <option>Hello 1</option>
                    </select>
                    <Link to={who==="sp"?"/spaccount":"/myaccount"} ><PersonFill size="2em"></PersonFill></Link>
                        <button className="btn btn-danger" onClick={logout}>Logout</button></>
                    : ""
            }

        </div>
    )
}