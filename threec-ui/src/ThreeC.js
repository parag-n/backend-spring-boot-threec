import "bootstrap/dist/css/bootstrap.min.css";
import { Provider, useSelector } from "react-redux";
import { BrowserRouter, Navigate, Route, Routes, useNavigate } from "react-router-dom";
import TCHome from "./components/TCHome";
import Login from "./components/Login";
import TCMyAccount from "./components/TCMyAccount";
import TCNavbar from "./components/TCNavbar";
import TCCAddPost from "./components/TCCAddPost";
import TCCRegister from "./components/TCCRegister";
import TCReduxStore from "./components/TCReduxStore"
import { useState } from "react";
import TCSRegister from "./components/TCSRegister";

export default function ThreeC() {

    // let navi = useNavigate();
    // let user = useSelector((state) => { console.log(state.user); return state.user; })
    // let [loggedIn, setLogin]=useState(false);
    // useSelector(()=>{})


    return (
        <div>
            <Provider store={TCReduxStore}>
                {/* <ThreeC></ThreeC> */}
                <BrowserRouter>

                    <TCNavbar></TCNavbar>

                    {/* Defining routes to different components */}
                    <Routes>

                        <Route path="/" element={<TCHome />}></Route>

                        <Route path="/register" element={<TCCRegister />}></Route>

                        <Route path="/login" element={<Login />}></Route>

                        <Route path="/myaccount" element={<TCMyAccount/>}></Route>

                        <Route path="/newpost" element={<TCCAddPost />}></Route>

                        <Route path="/spregister" element={<TCSRegister/>}></Route>

                        <Route path="*" element={<TCHome/>}></Route>
                    </Routes>
                </BrowserRouter>
            </Provider>
        </div>
    )
}