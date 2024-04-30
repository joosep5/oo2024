//import logo from './logo.svg';
import { useEffect, useState, useRef } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); //HTMLs esinevad muutujad peavad olema useState sees
  const [toiduained, setToiduained] = useState([]); 
  const nimiRef = useRef();
  const valkRef = useRef();
  const rasvRef = useRef();
  const sysivesikRef = useRef();
  const [toidukomponendid, setToiduKomponendid] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/toiduained", {"method": "GET"})
    .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
    .then((json) => {
      setKogus(json.length)
      setToiduained(json);
    }) //body
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/toidukomponendid", {"method": "GET"})
    .then(response => response.json()) 
    .then((json) => {
      setToiduKomponendid(json);
    })
  }, []);

  function kustuta (primaarvoti){
    fetch("http://localhost:8080/api/toiduained/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
      .then((json) => {
        setKogus(json.length)
        setToiduained(json);
      })
  }
  function kustutaTK (primaarvoti){
    fetch("http://localhost:8080/toidukomponendid/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
      .then((json) => {
        setToiduKomponendid(json);
      })
  }
  function lisa (){
    if (nimiRef.current.value.trim() ===""){
      return;
    }
    const toiduaine = ({
      "nimetus": nimiRef.current.value,
      "valk": valkRef.current.value,
      "rasv": rasvRef.current.value,
      "sysivesik": sysivesikRef.current.value
  });
    fetch("http://localhost:8080/api/toiduained", 
    {
      "method": "POST", 
      "body": JSON.stringify(toiduaine), 
      "headers": {"content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then((json) => {
        setKogus(json.length)
        setToiduained(json);
      })
  }

  const tkNimiRef = useRef(); // inputi luger, mist loev HTMLst mida kirjutati
  const kogusRef = useRef();
  function lisaTK (){
    const lisatavTK = {
      "toiduaine":{nimetus: tkNimiRef.current.value},
      "kogus": kogusRef.current.value
    }
    if (nimiRef.current.value.trim() ===""){
      return;
    }
    fetch("http://localhost:8080/toidukomponendid", 
    {
      "method": "POST",
      "body": JSON.stringify(lisatavTK), 
      "headers": {"content-Type": "application/json"}
    })
    .then(response => response.json()) 
    .then((json) => {
      setToiduKomponendid(json);
    })
  }
  return (
    <div className="App">
      Mul on {kogus} toiduainet
      <br/><br/> 
      <label>Toiduaine nimi</label> <br/> 
      <input ref={nimiRef} type = "text"/> <br/>
      <label>Toiduaine valk</label> <br/> 
      <input ref={valkRef} type = "text"/> <br/>
      <label>Toiduaine rasv</label> <br/> 
      <input ref={rasvRef} type = "text"/> <br/>
      <label>Toiduaine sysivesik</label> <br/> 
      <input ref={sysivesikRef} type = "text"/> <br/>
      <button onClick={()=> lisa ()}>Sisesta</button> <br/>
      <br/>
      

      {toiduained.map(t => <div>{t.nimetus} <button onClick={()=> kustuta(t.nimetus)}>X</button> </div> )}
      
      <hr />
      <label>Toiduaine nimi</label> <br/> 
      <input ref={tkNimiRef} type = "text"/> <br/>
      <label>Kogus</label> <br/> 
      <input ref={kogusRef} type = "text"/> <br/>
      <button onClick={()=> lisaTK ()}>Sisesta</button> <br/>

      {toidukomponendid.map(tk => <div>{tk.id} | {tk.toiduaine?.nimetus} | {tk.kogus} | <button onClick={()=> kustutaTK(tk.id)}>X</button> </div> )}
    </div>
  );
}

export default App;
