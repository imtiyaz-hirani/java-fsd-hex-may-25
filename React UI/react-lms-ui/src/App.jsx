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
    <div>
      {/** <Concepts />**/}
      {/** <Task />**/}
      {/** <TodoList />**/}
      {/** <Post /> **/}
      {/** <AddPost />**/}
      {/** <FetchPost /> **/}
      {/* <CourseList /> */}
      <Login />
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