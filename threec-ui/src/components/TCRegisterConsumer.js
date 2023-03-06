// import Button from 'react-bootstrap/Button';
// import Form from 'react-bootstrap/Form';

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";


export default function TCRegisterConsumer() {
  let nav=useNavigate();

  // let [name, setName] = useState("");
  // let [phone, setPhone]=useState("");
  // let [email, setEmail]=useState("");
  // let [username, setUsername]=useState("");
  // let [password, setPassword]=useState("");
  // let [reenter, setReenter]=useState("");
  
  // let consumer ={
  //   "fullname":name,
  //   "phone":phone,
  //   "email":email,
  //   "username":username,
  //   "password":password
  // };
  
  let [consumer, setConsumer] = useState();
  let [reenter, setRE] = useState();

  let inputHandler=(e)=>{
    setConsumer({...consumer, [e.target.name] : e.target.value})
  }

  let checkHandler=(e)=>{
    e.preventDefault();
    console.log(consumer);

    axios.post("http://localhost:7070/consumer/consumers", consumer)
    .then((res)=>{console.log(res.data)});
    
    if(consumer.password===reenter){
      nav("/login");
    } 
  }


  return (
    <div className="container mt-5 w-50 px-5 py-5 rounded-5 bg-secondary">
      <h2 className="w-100 mb-3" >Consumer Registration</h2>
      <form onSubmit={checkHandler}>
        <div className="row">
          <div className="mb-3 col">
            <label htmlFor="fullname" className="form-label">Name</label>
            <input type="text" className="form-control" name="fullname" id="fullname" onChange={inputHandler} required></input>
          </div>
          <div className="mb-3 col">
            <label htmlFor="phone" className="form-label">Mobile</label>
            <input type="text" className="form-control" name="phone" id="phone" onChange={inputHandler} required></input>
          </div>
        </div>

        <div className="row">
          <div className="mb-3 col">
            <label htmlFor="email" className="form-label">Email address</label>
            <input type="email" className="form-control" name="email" id="email" onChange={inputHandler} required></input>
          </div>
          <div className="mb-3 col">
            <label htmlFor="username" className="form-label">Username</label>
            <input type="text" className="form-control" name="username" id="username" onChange={inputHandler} required></input>
          </div>
        </div>
        
        <div className="row">
          <div className="mb-3 col">
            <label htmlFor="password" className="form-label">Password</label>
            <input type="password" className="form-control" name="password" id="password" onChange={inputHandler} required></input>
          </div>
          <div className="mb-3 col">
            <label htmlFor="reenter" className="form-label">Re-enter password</label>
            <input type="password" className="form-control" name="reenter" id="reenter" onChange={(e)=>{setRE(e.target.value)}} required></input>
          </div>
        </div>
        
        <button type="submit" className="btn btn-success">Register</button>
      </form>
    </div>
  )
}