import axios from "axios";
import { useEffect, useState } from "react";

function FetchPost() {
    let [userId, setUserId] = useState(0);
    let [posts, setPosts] = useState([]);
    let [msg, setMsg] = useState("");

    const showPosts = async () => {
        try {
            let response = await axios.get(`https://jsonplaceholder.typicode.com/users/${userId}/posts`);
            setPosts(response.data);
            if (posts.length === 0)
                setMsg('No Posts found for this user id.')
            else
                setMsg("")
        }
        catch (err) {
            setMsg('Could not fetch data for given ID');
        }
    }
    return (
        <div className="container">
            <div className="row">
                <div className="col-lg-12 mb-4 mt-4">
                    <div >
                        <label>Enter User ID: </label>
                        <input type="text" onChange={$e => setUserId($e.target.value)} className="form-control" />
                        <br />
                        <button className="btn btn-secondary" onClick={() => showPosts()}>Show Posts</button>
                    </div>
                </div>
                <div className="col-lg-12 mb-4">
                    {msg !== "" ? <div>{msg}</div> : ""}
                </div>
                {
                    posts.map((post) => (
                        <div className="col-lg-12" key={post.id}>
                            <div className="card" >
                                <div className="card-header">
                                    User ID: {post.userId}
                                </div>
                                <div className="card-body">
                                    <h5 className="card-title"> {post.title}</h5>
                                    <p className="card-text">{post.body}</p>
                                    <a href="#" className="btn btn-primary">View Comments</a> &nbsp;&nbsp;

                                </div>
                            </div>
                        </div>
                    ))
                }

            </div>
        </div>
    )
}

export default FetchPost;