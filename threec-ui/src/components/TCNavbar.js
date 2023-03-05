export default function TCNavbar() {
    return (
        <div style={{backgroundColor: "rgb(157, 192, 139)"}}>
            <nav class="navbar navbar-expand-lg navbar-light bg-light pt-3 pb-3" >
                <div class="container-fluid mx-4">
                    <a class="navbar-brand" href="/">Connect Contact Conduct</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="/">Home</a>
                            </li>
                        </ul>
                        <a href="/register" className="btn btn-warning me-2">Register</a>
                        <a href="/login" className="btn btn-warning me-2">Login</a>
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
                                <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
    )
}