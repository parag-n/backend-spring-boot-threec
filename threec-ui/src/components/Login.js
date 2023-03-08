import React, { useState } from 'react'
import TCLogin from './TCLogin';
import TCSLogin from './TCSLogin';
export default function Login() {

  const [isConsumer, setIsConsumer] = useState(true);

  const handleConsumerClick = () => {
    setIsConsumer(true);
  }

  const handleServiceProviderClick = () => {
    setIsConsumer(false);
  }

  return (
    <div>
      <button onClick={handleConsumerClick}>Consumer</button>
      <button onClick={handleServiceProviderClick}>Service Provider</button>
      {isConsumer ? <TCLogin type="consumer" /> : <TCSLogin type="service-provider" />}
    </div>
  );
}
