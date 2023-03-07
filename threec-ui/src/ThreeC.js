import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TCHome from "./components/TCHome";
import TCLogin from "./components/TCLogin";
import TCMyAccount from "./components/TCMyAccount";
import TCNavbar from "./components/TCNavbar";
import TCRegisterConsumer from "./components/TCRegisterConsumer";

export default function ThreeC() {
    return (<div>

        {/* writing navbar outside browser router to keep it visible the whole time */}
        <TCNavbar></TCNavbar>

        <BrowserRouter>

            {/* Defining routes to different components */}
            <Routes>
                <Route path="/" element={<TCHome/>}></Route>

                <Route path="/register" element={<TCRegisterConsumer/>}></Route>
                
                <Route path="/login" element={<TCLogin/>}></Route>
                
                <Route path="/myaccount" element={<TCMyAccount/>}  ></Route>
            </Routes>
        </BrowserRouter>
    </div>)
}