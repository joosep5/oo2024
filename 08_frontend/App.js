//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); // HTMLs esinevad muutujad peavad olema useState sees
  const [autod, setAutod] = useState([]);
  const nimiRef = useRef();
  const maksumusRef = useRef();
  const mootorRef = useRef();
  const aastaRef = useRef();
  const [autokomponendid, setAutoKomponendid] = useState([]);


    // Reacti hookid: use eesliidesega, neid peab importima. Reacti erikood
    // Springis annotatsioonid: @RestController, @GetMapping. neid peab importima. Springi erikood.

    // uef -> JS: onLoad()
    useEffect(() => {
            fetch("http://localhost:8080/api/autod")
                    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json => {
            setKogus(json.length);
    setAutod(json);
      }) // body
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/autokomponendid", {"method": "GET"})
    .then(response => response.json()) 
    .then((json) => {
      setAutoKomponendid(json);
    })
  }, []);

    function kustutaAuto(primaarivoti) {
            fetch("http://localhost:8080/api/autod/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json())
      .then(json => {
            setKogus(json.length);
    setAutod(json);
      })
  }
  function kustutaTK (primaarvoti){
    fetch("http://localhost:8080/autokomponendid/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
      .then((json) => {
        setAutoKomponendid(json);
      })
  }

    function lisaAuto() {
        // document.getElemenyById("sad").value -> guugeldada see vs useRef
        if (nimiRef.current.value.trim() === "") {
            return;
        }
    const auto = ({
                "nimetus": nimiRef.current.value,
                "maksumus": maksumusRef.current.value,
                "mootor": mootorRef.current.value,
                "aasta": aastaRef.current.value
    });
        fetch("http://localhost:8080/api/autod",
                {
                        "method": "POST",
                "body": JSON.stringify(auto),
                "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json())
      .then(json => {
                setKogus(json.length);
        setAutod(json);
      })
    }
    const tkNimiRef = useRef(); // inputi luger, mist loev HTMLst mida kirjutati
    const kogusRef = useRef();
    function lisaTK (){
      const lisatavTK = {
        "auto":{nimetus: tkNimiRef.current.value},
        "kogus": kogusRef.current.value
      }
      if (nimiRef.current.value.trim() ===""){
        return;
      }
      fetch("http://localhost:8080/autokomponendid", 
      {
        "method": "POST",
        "body": JSON.stringify(lisatavTK), 
        "headers": {"content-Type": "application/json"}
      })
      .then(response => response.json()) 
      .then((json) => {
        setAutoKomponendid(json);
      })
    }
    return (
            <div className="App">
            Mul on {kogus} autot
            <br /><br />

      <label>auto nimi</label> <br/>
      <input ref={nimiRef} type="text" /> <br />
      <label>auto maksumus</label> <br/>
      <input ref={maksumusRef} type="text" /> <br />
      <label>auto mootor</label> <br/>
      <input ref={mootorRef} type="text" /> <br />
      <label>auto aasta</label> <br/>
      <input ref={aastaRef} type="text" /> <br />
      <button onClick={() => lisaAuto()}>Sisesta</button> <br />
      <br />

            {autod.map(t => <div>{t.nimetus} <button onClick={() => kustutaAuto(t.nimetus)}>x</button> </div> )}
            
      <hr />
      <label>auto nimi</label> <br/> 
      <input ref={tkNimiRef} type = "text"/> <br/>
      <label>Kogus</label> <br/> 
      <input ref={kogusRef} type = "text"/> <br/>
      <button onClick={()=> lisaTK ()}>Sisesta</button> <br/>

      {autokomponendid.map(tk => <div>{tk.id} | {tk.auto?.nimetus} | {tk.kogus} | <button onClick={()=> kustutaTK(tk.id)}>X</button> </div> )}

    </div>
  );
}

export default App;