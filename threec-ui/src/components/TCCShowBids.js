import axios from "axios";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useLocation, useNavigate } from "react-router-dom";


export default function TCCShowBids() {

    // retrieving the link to server from redux store
    let link = useSelector((state) => { return state.link })

    // method to navigate to another component
    let navi=useNavigate();

    // retrieving state passed from the <Link> tag
    let linkstate = useLocation();

    // retrieving the post from the state
    let post = linkstate.state;

    // a random key for making the elements generated by map method unique
    let keyunique = 98989;

    // storing the bids in a state variable
    let [bids, setBids] = useState([])

    // retrieving all the bids related to the given bid from the server as soon as the component is loaded
    useEffect(() => {

        axios.get(link + `/bid/post/` + post.postId)

            .then((response) => {
                console.log(response.data)
                setBids(response.data)
            })

            .catch(() => { })

    }, [link, post])

    let accepted={
        accepted:true
    }

    // handler to call when accepts a bid
    let acceptBid = (e) => {
        console.log(e.target.id)

        axios.put(link+`/bid/accept/`+e.target.id, accepted)

        .then((response)=>{
            console.log(response.data)
            navi("/myaccount")
        })

        .catch(()=>{})

        

    }

    return (
        <div className="container">
            <table className="table">
                <thead className="table-dark">
                    <tr>
                        <th>Amount</th><th>Note</th><th>Service Provider Name</th><th>Action</th>
                    </tr>
                </thead>
                <tbody className="table-light">
                    {
                        bids.map((bid) => {
                            console.log(bid)
                            keyunique++;
                            return <tr key={keyunique}><td>{bid.amount}</td>
                                <td>{bid.note}</td>
                                <td>loading</td>
                                <td>
                                    {
                                        bid.accepted?<button className="btn btn-secondary" disabled> Accepted</button>:<button className="btn btn-warning" id={bid.bidId} name={bid.Id} onClick={acceptBid}>Accept Bid</button>
                                    }
                                </td>
                            </tr>
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}