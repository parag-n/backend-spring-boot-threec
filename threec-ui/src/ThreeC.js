import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TCHome from "./components/TCHome";
import TCLogin from "./components/TCLogin";
import TCNavbar from "./components/TCNavbar";
import TCRegister from "./components/TCRegister";

export default function ThreeC() {
    return (<div>
        <TCNavbar></TCNavbar>
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<TCHome></TCHome>}></Route>
                <Route path="/register" element={<TCRegister></TCRegister>}>
                </Route>
                <Route path="/login" element={<TCLogin></TCLogin>}></Route>
            </Routes>
        </BrowserRouter>
    </div>)
}