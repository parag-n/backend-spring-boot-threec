import axios from "axios";
import { useState } from "react"

export default function TCLogin() {

    let [user, setU]=useState("");
    let [pass, setP]=useState("");

    let consumer={
        "username":user,
        "password":pass
    }
    let [flag, setFlag]=useState(false);
    let alert=<h6 className="alert alert-danger show" >Wrong username or password</h6>

    let loginHandler= (e)=>{
        e.preventDefault();
        axios.post("http://localhost:7070/consumer/login", consumer)
        .then((response)=>{
            console.log(response.data)
        })
        .catch(()=>{
            setFlag(true);
        })
    }
    return (
        <div>
            <div className="container-fluid mt-5 w-50 px-5 py-5 rounded-5 bg-secondary">
                {flag?alert:<></>}
                <h2>Consumer Login</h2>
                <form onSubmit={loginHandler}>
                    <div className="row">
                        <div className="mb-3 col">
                            <label htmlFor="username" className="form-label">Username</label>
                            <input type="text" className="form-control" id="username" onChange={(e) => { setU(e.target.value) }}></input>
                        </div>
                        <div className="mb-3 col">
                            <label htmlFor="password" className="form-label">Password</label>
                            <input type="password" className="form-control" id="password" onChange={(e) => { setP(e.target.value) }} ></input>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-success">Login</button>
                </form>
            </div>
        </div>
    )
}