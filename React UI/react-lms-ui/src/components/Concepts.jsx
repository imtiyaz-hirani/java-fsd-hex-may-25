import { useState } from "react";

function Concepts() {
    // I want to create a variable , but as a state 
    let [count, setCount] = useState(0); Number
    let [name, setName] = useState("");
    let [showWelcome, setShowWelcome] = useState(false);
    let [arryIpl, setArryIpl] = useState(["CSK", "KKR", "MI"]); //<-- this is my array which initially has 3 values

    const welcome = () => {
        setShowWelcome(true);
    }
    return (
        <div>
            <h1 style={{ color: 'red' }}>count = {count} </h1> {/** <--- JSX */}
            <button onClick={() => { setCount(count + 1) }}>Incr-count</button>
            <button onClick={() => { setCount(count - 1) }}>Decr-count</button>
            <hr /> <br /><br />
            <label>Enter your Name: </label>
            <input type="text" onChange={($e) => { setName($e.target.value) }} />
            <br />
            <button onClick={() => { welcome() }}>Submit</button>
            <br />
            {showWelcome == true ? <span>Welcome {name}</span> : ""}
            <hr /> <br /><br />
            <h4>Array of IPL Teams</h4>
            {
                arryIpl.map((e) => (
                    <li key={e}>{e}</li>
                ))
            }
        </div>
    )
}

export default Concepts;
/** 
 * ()=>{}
 * ()=>()
 */