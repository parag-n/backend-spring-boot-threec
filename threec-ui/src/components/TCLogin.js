import { useState } from "react"

export default function TCLogin() {

    let [user, setU]=useState("");
    let [pass, setP]=useState("");
    return (
        <div>
            <div className="container mt-5 w-50 px-5 py-5 rounded-5 bg-secondary">
                <form>
                    <div class="row">
                        <div class="mb-3 col">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" onChange={(e) => { setU(e.target.value) }}></input>
                        </div>
                        <div class="mb-3 col">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" onChange={(e) => { setP(e.target.value) }} ></input>
                        </div>
                    </div>
                    <button type="submit" className="btn btn-success">Login</button>
                </form>
            </div>
        </div>
    )
}