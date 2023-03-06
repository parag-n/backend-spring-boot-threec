import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TCHome from "./components/TCHome";
import TCLogin from "./components/TCLogin";
import TCMyAccount from "./components/TCMyAccount";
import TCNavbar from "./components/TCNavbar";
import TCRegisterConsumer from "./components/TCRegisterConsumer";

export default function ThreeC() {
    return (<div>
        <TCNavbar></TCNavbar>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<TCHome></TCHome>}></Route>
                <Route path="/register" element={<TCRegisterConsumer></TCRegisterConsumer>}>
                </Route>
                <Route path="/login" element={<TCLogin></TCLogin>}></Route>
                <Route path="/myaccount" element={<TCMyAccount></TCMyAccount>}></Route>
            </Routes>
        </BrowserRouter>
    </div>)
}