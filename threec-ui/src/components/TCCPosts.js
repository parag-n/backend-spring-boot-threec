import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { BsFillPlusSquareFill } from "../../node_modules/react-icons/bs"
export default function TCCPosts(props) {
    let posts = props.posts;
    // let postss=useSelector(state=>state)

    // console.log(postss);
    return (
        <div className="card">
            <h5 className="text-center">YOUR POSTS</h5>
            <div className="card-body d-flex flex-wrap bg-light p-2 rounded">
                <div className="card text-white bg-dark" style={{ maxWidth: "23rem" }}>
                    <div className="card-header text-center">Create New Post</div>
                    <div className="card-body">
                        {/* <h5 className="card-title">Checking the title</h5> */}
                        {/* <h5 className="card-title">Hello this is title</h5> */}
                        <p className="card-text text-center"> <Link to="/newpost"><BsFillPlusSquareFill size="2em"></BsFillPlusSquareFill></Link> </p>
                    </div>
                </div>
                {
                    posts.map((post) => {
                        return <div className="card text-white bg-dark" style={{ maxWidth: "23rem" }}>
                            <div className="card-header text-center">{post.title}</div>
                            <div className="card-body">
                                {/* <h5 className="card-title">Checking the title</h5> */}
                                {/* <h5 className="card-title">Hello this is title</h5> */}
                                <p className="card-text">{post.description}</p>
                            </div>
                        </div>
                    })
                }
            </div>
        </div>

    )
}