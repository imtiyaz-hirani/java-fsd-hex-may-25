import { useState } from "react";

function Task() {
    let [task, setTask] = useState("");
    let [taskArry, setTaskArry] = useState([]);
    const addToList = () => {
        // taskArry.push(task) <-- taskArry is a state, and so its private(immutable) - can't change it directly
        let temp = [...taskArry] //<-- ... spread operator: this clones tempArry elements into new array temp 
        temp.push(task); //<-- i can push this task in temp as temp is not a state..... 
        setTaskArry(temp) //<-- this is a proper way of updating an array by adding an element 
    }
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <br /><br /><br /><br /><br /><br /><br /><br />
                </div>
            </div>
            <div className="row">
                <div className="col-md-3">
                    <div className="card">
                        <div className="card-body">
                            <label>Enter Task: </label> <br />
                            <textarea cols={30} onChange={($e) => { setTask($e.target.value) }} />
                            <button className="btn btn-info" onClick={() => { addToList() }}>Add to List</button>
                        </div>
                    </div>
                </div>
                <div className="col-md-6">Task List
                    {
                        taskArry.map((e) => (
                            <li key={e}>{e}</li>
                        ))
                    }
                </div>
            </div>
        </div>
    )
}

export default Task;