import axios from "axios"
import { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";


export default function TCCAddPost(){


    // storing list of categories in state
    let [categories, setCats]=useState([]);

    let navi=useNavigate();

    // storing list of addresses in state
    let [addresses, setAdds]=useState([])

    // fetching all the categories as soon as the component is mounted
    useEffect(()=>
    {
        axios.get("http://192.168.1.100:7070/expertise/expertises")
        .then(
            (response)=>{
                setCats(response.data)
            },
            ()=>{
                // registering callback function for when the promise is rejected
                setCats([])
            }
        )
        
        axios.get("http://192.168.1.100:7070/address/addresses")
        .then(
            (response)=>{
                setAdds(response.data)
            },
            ()=>{
                // registering callback function for when the promise is rejected
                setAdds([])
            }
        )
    },[])

    // storing expertiseId in state for using it in the dummy post
    let [expertiseId,setExp]=useState();

    // storing addressId in state for using it in the dummy post
    let [addressId, setAddId]=useState();

    let consumerId=useSelector((state)=>{
        return state.consumer.consumerId
    })

    let savePost=useDispatch();

    // creating a dummy post to use it in json
    let dummypost={
        category:{
            expertiseId
        },
        address:{
            addressId
        },
        consumer:{
            consumerId
        }
    }

    // keeping almost final post in state to use it in final post object
    let [post,setPost]=useState({});

    // callback function to store input in the post object
    let inputHandler=(e)=>{
        setPost({...post, ...dummypost, [e.target.name]: e.target.value})
        console.log(e.target.value)
        console.log(post)
    }

    // callback function to set the expertise when a category is selected
    let categorySelect=(e)=>{
        setExp(e.target.value);
        console.log(post)
    }

    // callback function to set the address when an address is selected
    let addressSelect=(e)=>{
        setAddId(e.target.value);
    }
    
    // callback function to create a new post and post it to server
    let createPost=(e)=>{
        e.preventDefault();
        setPost({...post, ...dummypost})
        // console.log(post);
        axios.post("http://192.168.1.100:7070/post/posts", post)
        .then((response)=>{
            savePost({type:"savepost", newpost:response.data})
            navi("/myaccount")

        })
        .catch(()=>{})
        
    }

    return(
        <div className="container m-4 mx-auto bg-light p-3 rounded-3">
            <table className="table table-dark table-responsive-sm">
                <thead className="table-dark">
                    <tr>
                        <th>Category</th><th>Address</th><th>Title</th><th>Description</th>
                    </tr>
                </thead>
                <tbody className="table-light">
                    <tr>
                        <td>
                            <select className="form-select form-select-sm" name="category" onChange={categorySelect} required>
                            <option selected disabled>select category</option>
                                {
                                    categories.map((cat)=>{
                                        return <option key={cat.expertiseId} value={cat.expertiseId}>{cat.name}</option>
                                    })
                                }
                            </select>
                            
                        </td>
                        <td>
                            <select className="form-select form-select-sm" name="address" onChange={addressSelect} required>
                                <option selected disabled>select address</option>
                                
                                {
                                    addresses.map((add)=>{
                                        return <option key={add.addressId} value={add.addressId}>{add.details+", "+add.city+" - "+add.pincode}</option>
                                    })
                                }
                                <option className="">Add New Address</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="title" id="title" onChange={inputHandler} required></input>
                        </td>
                        <td>
                            <input type="text" name="description" id="description" onChange={inputHandler} required></input>
                        </td>
                    </tr>
                    <tr className="table-dark">
                        <button type="button" className="btn btn-success" onClick={createPost}>Submit</button>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}