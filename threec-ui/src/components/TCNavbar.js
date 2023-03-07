import { BsPersonCircle as PersonFill } from "react-icons/bs"

export default function TCNavbar() {
    return (
        <div style={{ backgroundColor: "rgb(157, 192, 139)" }}>

            {/* Navigation bar */}
            <nav className="navbar navbar-expand-lg navbar-light bg-light pt-3 pb-3" >

                <div className="container-fluid mx-4">
                    
                    <a className="navbar-brand" href="/">Connect Contact Conduct</a>
                    <a className="nav-link active" href="/">Home</a>
                    <a href="/register" className="btn btn-warning me-2">Register</a>
                    <a href="/login" className="btn btn-warning me-2">Login</a>
                    <a href="/myaccount" ><PersonFill size="2em"></PersonFill></a>

                </div>
            </nav>
        </div>
    )
}