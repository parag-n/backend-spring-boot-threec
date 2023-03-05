// import Button from 'react-bootstrap/Button';
// import Form from 'react-bootstrap/Form';

import { useState } from "react";

export default function TCRegister() {

  let [name, setName] = useState("");
  let [phone, setPhone]=useState("");
  let [email, setEmail]=useState("");
  let [username, setUsername]=useState("");
  let [password, setPassword]=useState("");
  let [reenter, setReenter]=useState("");
  let checkHandler=()=>{
    if(password===reenter) return true;
    console.log(consumer);
    return false;
  }

  let consumer ={
    "fullname":name,
    "phone":phone,
    "email":email,
    "username":username,
    "password":password
  };

  


  return (
    <div className="container mt-5 w-50 px-5 py-5 rounded-5 bg-secondary">
      <form>
        <div class="row">
          <div class="mb-3 col">
            <label for="fullname" class="form-label">Name</label>
            <input type="text" class="form-control" id="fullname" onChange={(e)=>{ setName(e.target.value) }}></input>
          </div>
          <div class="mb-3 col">
            <label for="phone" class="form-label">Mobile</label>
            <input type="text" class="form-control" id="phone" onChange={(e)=>{ setPhone(e.target.value) }} ></input>
          </div>
        </div>

        <div class="row">
          <div class="mb-3 col">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" onChange={(e)=>{ setEmail(e.target.value) }} ></input>
          </div>
          <div class="mb-3 col">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" onChange={(e)=>{ setUsername(e.target.value) }} ></input>
          </div>
        </div>
        
        <div class="row">
          <div class="mb-3 col">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" onChange={(e)=>{ setPassword(e.target.value) }} ></input>
          </div>
          <div class="mb-3 col">
            <label for="reenter" class="form-label">Re-enter password</label>
            <input type="password" class="form-control" id="reenter" onChange={(e)=>{ setReenter(e.target.value) }}></input>
          </div>
        </div>
        
        <button type="submit" class="btn btn-success" onClick={checkHandler} >Register</button>
      </form>
    </div>
  )
}