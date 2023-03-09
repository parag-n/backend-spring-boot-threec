import Toast from 'react-bootstrap/Toast';
import { useState } from 'react'
import { useLocation } from 'react-router-dom';
import TCCLogin from './TCCLogin';
import TCSLogin from './TCSLogin';
export default function Login() {

  // retrieving state from <Link> tag
  let linkstate=useLocation();

  let message=linkstate.message;

  let [showMessage, toggleShow]=useState(true)
  // toggleShow(linkstate.show);

  let toggle=()=>{toggleShow(!showMessage)}
  // storing flag in state to switch between consumer and service provider login on click
  const [isConsumer, setIsConsumer] = useState(true);

  // handler for consumer tab click
  const consumerHandler = () => {
    setIsConsumer(true)
  };

  // handler for service provider click
  const spHandler = () => {
    setIsConsumer(false);
  };

  let myalert =
    <Toast show={showMessage} onClose={toggle}>
      <Toast.Header>
        {/* <img src="holder.js/20x20?text=%20" className="rounded me-2" alt="" /> */}
        <strong className="me-auto">Bootstrap</strong>
        <small>11 mins ago</small>
      </Toast.Header>
      <Toast.Body>{message}</Toast.Body>
    </Toast>

  return (
    <div className="container mt-5 d-flex flex-column">
      {showMessage?myalert:<></>}
      <div className='btn-group mx-auto w-100' role="group" style={{ maxWidth: "25rem" }}>
        <button className='btn btn-primary' onClick={consumerHandler}>Consumer</button>
        <button className='btn btn-primary' onClick={spHandler}>Service Provider</button>
      </div>
      {isConsumer ? <TCCLogin type="consumer" /> : <TCSLogin type="service-provider" />}
    </div>
  );
}

