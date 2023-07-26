import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

test('renders iban label', () => {
  const { getByText } = render(<App />);
  expect(getByText(/IBAN/i)).toBeInTheDocument();
});
