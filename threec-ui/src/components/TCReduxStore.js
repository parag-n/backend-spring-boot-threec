import { configureStore } from "@reduxjs/toolkit"


const TCReducer = (
    state={
        consumer:{
            consumerId:0,
            fullname:"",
            phone:"",
            email:"",
            username:"",
            addresses:[],
            posts:[]
        },
        SP:{
            serviceProviderId:0,
            fullname:"",
            phone:"",
            email:"",
            city:"",
            username:"",
            expertise:[],
            bids:[]
        },  

        user:false
    }, 
    action)=>{

    if(action.type==="login"){
        return {...state, consumer:action.consumer, user:action.user}
    }
    else if(action.type==="logout"){
        return {...state, consumer:action.consumer, user:action.user}
    }
    else if(action.type==="savepost"){
        return {...state, consumer:{...state.consumer, posts:[...state.consumer.posts, action.newpost]}}
    
    }

}

const store = configureStore({reducer:TCReducer})

export default store;  