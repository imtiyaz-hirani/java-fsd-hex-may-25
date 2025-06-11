import AddPost from "./components/AddPost";
import Concepts from "./components/Concepts";
import Post from "./components/Post";
import Task from "./components/Task";
import TodoList from "./components/Todo";

function App() {

  return (
    <div>
      {/** <Concepts />**/}
      {/** <Task />**/}
      {/** <TodoList />**/}
      {/** <Post />**/}
      <AddPost />
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