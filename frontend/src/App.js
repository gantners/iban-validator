import React, { useState } from 'react';

const App = () => {
  const [iban, setIBAN] = useState('');
  const [ibanVerified, setIBANVerified] = useState('');
  const [validationResult, setValidationResult] = useState('');
  const [bankName, setBankName] = useState('');
  const [bic, setBIC] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();

    fetch('http://localhost:8080/api/validate-iban', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ iban }),
    })
      .then((response) => response.json())
      .then((data) => {
        setValidationResult(data.valid ? 'true' : 'false');
        setBankName(data.bankName);
        setBIC(data.bic);
        setIBANVerified(data.iban)
      })
      .catch((error) => {
        console.error('Error while validating IBAN:', error);
        setValidationResult('Error occurred during validation.');
        setBankName('');
        setBIC('');
        setIBANVerified('');
      });
  };
  //usually for iban there should be only iban characters allowed, but for now we allow all and leave it to the backend
  return (
    <div>
      <h1>IBAN Validator and bank lookup</h1>
      <p>Enter your iban and hit validate to verify your iban on an external service.<br />
      If you provided a valid iban, the corresponding bic and name of the bank will be displayed.
      </p>
      <form onSubmit={handleSubmit}>
        <label htmlFor="iban-input">
          IBAN:
        </label>
        <input id="iban-input" type="text" value={iban} onChange={(e) => setIBAN(e.target.value)} placeholder='Type Iban number' size={25}/>
        <button type="submit">Validate</button>
      </form>
      {validationResult.length > 0 && validationResult === 'false' && <div>Your IBAN is invalid, please check again.</div>}
      {ibanVerified && <h1>Related bank data:</h1>}
      {ibanVerified && <div>Verified IBAN: {ibanVerified}</div>}
      {bankName && <div>Bank Name: {bankName}</div>}
      {bic && <div>BIC: {bic}</div>}
    </div>
  );
};

export default App;
