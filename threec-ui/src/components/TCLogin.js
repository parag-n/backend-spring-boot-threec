import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router-dom";

export default function TCLogin() {
    
    // states to keep the username and password
    let [user, setU]=useState();
    let [pass, setP]=useState();

    // navigate to user account
    let navi=useNavigate();

    // consumer object to be sent to the REST API
    let consumer={
        "username":user,
        "password":pass
    }

    // callback function to send the login request to the REST API
    let loginHandler= (e)=>{

        // prevents the data from being shown in the url
        e.preventDefault();
        
        // using post method to send the login request
        axios.post("http://localhost:7070/consumer/login", consumer)
        
        .then(
            // print the response data on console if the promise if fulfilled
            (response)=>{
                console.log(response.data)
                navi("/myaccount", response.data)
            },
            // print message if promise is rejected
            ()=>{
                console.log("wrong user credentials")
            }
        )
    }
    return (
        <div>
            <div className="container-fluid mt-5 w-50 p-5 rounded-5 bg-secondary">
                <h2 className="text-center pb-2">CONSUMER LOGIN</h2>

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