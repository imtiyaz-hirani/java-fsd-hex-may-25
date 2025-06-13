import { BrowserRouter, Route, Routes } from "react-router-dom";
import AddPost from "./components/AddPost";
import Concepts from "./components/Concepts";
import CourseList from "./components/CourseList";
import FetchPost from "./components/FetchPost";
import Login from "./components/Login";
import Post from "./components/Post";
import Task from "./components/Task";
import TodoList from "./components/Todo";

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />}></Route>
        <Route path="/author" element={<Post />}></Route>
        <Route path="/learner" element={<CourseList />}></Route>
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