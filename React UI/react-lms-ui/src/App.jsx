import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import AuthorDashboard from "./components/author/AuthorDashboard";
import LearnerDashboard from "./components/learner/LearnerDashboard";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />}></Route>
        <Route path="/author" element={<AuthorDashboard />}></Route>
        <Route path="/learner" element={<LearnerDashboard />}></Route>
      </Routes>
    </BrowserRouter>
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