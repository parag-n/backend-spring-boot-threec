import { useState } from 'react';
import TCCRegister from './TCCRegister';
import TCSRegister from './TCSRegister';

export default function Register() {
  const [showConsumerForm, setShowConsumerForm] = useState(false);
  const [showServiceProviderForm, setShowServiceProviderForm] = useState(false);

  const handleConsumerClick = () => {
    setShowConsumerForm(true);
    setShowServiceProviderForm(false);
  };

  const handleServiceProviderClick = () => {
    setShowConsumerForm(false);
    setShowServiceProviderForm(true);
  };

  return (
    <div>
      <button onClick={handleConsumerClick}>Consumer Register</button>
      <button onClick={handleServiceProviderClick}>Service Provider Register</button>
      {showConsumerForm && <TCCRegister />}
      {showServiceProviderForm && <TCSRegister />}
    </div>
  );
}
