import { BsPersonCircle as PersonFill } from "react-icons/bs"

export default function TCNavbar() {
    return (
        <div style={{ backgroundColor: "rgb(157, 192, 139)" }}>
            <nav className="navbar navbar-expand-lg navbar-light bg-light pt-3 pb-3" >
                <div className="container-fluid mx-4">
                    <a className="navbar-brand" href="/">Connect Contact Conduct</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link active" href="/">Home</a>
                            </li>
                            <li className="nav-item">
                                <a href="/register" className="btn btn-warning me-2">Register</a>
                            </li>
                            <li className="nav-item">
                                <a href="/login" className="btn btn-warning me-2">Login</a>
                            </li>
                            
                        </ul>
                        <a href="/myaccount" ><PersonFill size="2em"></PersonFill></a>
                    </div>
                    
                </div>
            </nav>
        </div>
    )
}