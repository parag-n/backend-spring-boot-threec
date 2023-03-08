import { useSelector } from "react-redux";
import { BsHouseAddFill } from "../../node_modules/react-icons/bs"
export default function TCCAddresses(props) {
    let addresses = props.addresses;
    // let postss=useSelector(state=>state)

    // console.log(postss);
    return (
        <div className="card">
            <h5 className="text-center" >YOUR ADDRESSES</h5>
            <div className="card-body d-flex flex-wrap bg-light p-2 rounded">
                <div className="card text-white bg-dark" style={{ maxWidth: "23rem" }}>
                    <div className="card-header text-center">Add New Address</div>
                    <div className="card-body">
                        {/* <h5 className="card-title">Checking the title</h5> */}
                        {/* <h5 className="card-title">Hello this is title</h5> */}
                        <p className="card-text text-center"> <BsHouseAddFill size="2em"></BsHouseAddFill> </p>
                    </div>
                </div>
                {
                    addresses.map((address) => {
                        return <div className="card text-white bg-dark" style={{ maxWidth: "23rem" }}>
                            <div className="card-header text-center">{address.city}</div>
                            <div className="card-body">
                                {/* <h5 className="card-title">Checking the title</h5> */}
                                {/* <h5 className="card-title">Hello this is title</h5> */}
                                <p className="card-text">{address.details}, {address.city} - {address.pincode}</p>
                            </div>
                        </div>
                    })
                }
            </div>
        </div>

    )
}