//import logo from './logo.svg';
import { useEffect, useState, useRef } from 'react';
import './App.css';

function App() {
  const [poed, setPoed] = useState([]);

  const nimiRef = useRef();
  const avamineRef = useRef();
  const sulgemineRef = useRef();
  const kulastamineRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/pood")
    .then(response => response.json())
    .then(json => {
      setPoed(json);
    })
  }, []);

  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/pood/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
        setPoed(json);
      })
  }

  function lisa() {
    const pood = {
      "nimetus": nimiRef.current.value,
      "avamine": avamineRef.current.value,
      "sulgemine": sulgemineRef.current.value,
      "külastajad": kulastamineRef.current.value
    }
    fetch("http://localhost:8080/pood", 
    {
      "method": "POST",
      "body": JSON.stringify(pood),
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
        setPoed(json);
      })
  }

  return (
    <div className="App">
      <h1>POED</h1>

      <label>Poe nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br/>
      <label>Avamine</label> <br/>
      <input ref={avamineRef} type="text" /> <br/>
      <label>Sulgemine</label> <br/>
      <input ref={sulgemineRef} type="text" /> <br/>
      <label>Külastajad</label> <br/>
      <input ref={kulastamineRef} type="number" /> <br/>
      <button onClick={() => lisa()}>Lisa</button> <br/>
      <br/>
      Poodide nimekiri ({poed.length}):
      {poed.map(p => <div>• {p.nimetus} | {p.avamine} | {p.sulgemine} | {p.külastajad}<button onClick={() => kustuta(p.id)}>🗑️</button></div>)}
    </div>
  );
}

export default App;