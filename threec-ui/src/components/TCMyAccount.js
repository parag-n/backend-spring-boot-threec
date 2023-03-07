
export default function TCMyAccount() {

    return (
        <div className="container bg-light my-2 rounded-3 p-2">

            <div className="inline-flex">
                <h4 className="text-center">Your Posts</h4>
                <table className="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">ID</th><th scope="col">Title</th><th scope="col">Description</th><th scope="col">Bids</th>
                        </tr>
                    </thead>
                    <tbody className="table-light">
                        <tr>
                            <td><button className="btn btn-success">New Post</button></td><td>{ }</td><td>{ }</td><td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <hr/>
            <hr/>
            <div className="">
                <h4 className="text-center">Your Profile Details</h4>
                <table className="table table-dark">
                    <thead>
                        <tr>
                            <th>Name</th><th>Email</th><th>Phone</th>
                        </tr>
                    </thead>
                    <tbody className="table-light">
                        <tr>
                            <td>{ }</td><td>{ }</td><td>{ }</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    )
}