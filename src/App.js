import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Route, Routes, BrowserRouter } from 'react-router-dom'
import { Home } from './components/Home';
import { Usd } from './components/Waluty/Usd.js';
import { Gbp } from './components/Waluty/Gbp.js';
import { Eur } from './components/Waluty/Eur.js';
import { Btc } from './components/Krypto/Btc.js';
import { Eth } from './components/Krypto/Eth.js';
import { Ltc } from './components/Krypto/Ltc.js';
import { Prze } from './components/Usa/Przemysl.js';
import { Rekre } from './components/Usa/Rekreacja.js';
import { Trans } from './components/Usa/Transport.js';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' exact element={<Home />} />
        <Route path='/usd' element={<Usd />} />
        <Route path='/gbp' element={<Gbp />} />
        <Route path='/eur' element={<Eur />} />
        <Route path='/btc' element={<Btc />} />
        <Route path='/eth' element={<Eth />} />
        <Route path='/ltc' element={<Ltc />} />
        <Route path='/produkcja' element={<Prze />} />
        <Route path='/rekreacja' element={<Rekre />} />
        <Route path='/transport' element={<Trans />} />
      </Routes>
    </BrowserRouter>
  );

}
export default App;

