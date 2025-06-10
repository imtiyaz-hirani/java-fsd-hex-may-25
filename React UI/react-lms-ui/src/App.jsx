import Concepts from "./components/Concepts";
import Task from "./components/Task";

function App() {

  return (
    <div>
      {/** <Concepts />**/}
      <Task />
    </div>
  )
}

export default App;

/**
 * private int count; //0
 * getter and setter 
 * 
 * let [count,setCount]
 * 
 * ()=>{}
 * if u change the value of state variable, I will re-render it. 
 */