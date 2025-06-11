import axios from "axios";
import { useState } from "react";

function AddPost() {
    let [title, setTitle] = useState("");
    let [postText, setPostText] = useState("");
    let [userId, setUserId] = useState(undefined);
    let [msg, setMsg] = useState("");

    const addPost = async () => {
        try {
            await axios.post('https://jsonplaceholder.typicode.com/posts/8989898',
                {
                    'title': title,
                    'body': postText,
                    'userId': userId,
                }
            )
            setMsg("Post created successfully!!!!")
        }
        catch (err) {
            setMsg("Operation Failed, Try again")
        }
    }
    return (
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <div className="card">
                        <div className="card-header"> Enter Post Details</div>
                        <div className="card-body">
                            {
                                msg != "" ? <div className="mb-4">
                                    <div className="alert alert-primary">
                                        {msg}
                                    </div>
                                </div> : ""
                            }

                            <div className="mb-4">
                                <label>Enter Post Title</label>
                                <input type="text" onChange={$e => setTitle($e.target.value)} className="form-control" />
                            </div>
                            <div className="mb-4">
                                <label>Enter Post Text</label>
                                <textarea onChange={$e => setPostText($e.target.value)} className="form-control" />
                            </div>
                            <div className="mb-4">
                                <label>Enter Post UserId</label>
                                <input type="number" onChange={$e => setUserId($e.target.value)} className="form-control" />
                            </div>
                            <div className="mb-4">
                                <button className="btn btn-primary" onClick={() => addPost()}>Add Post</button>
                            </div>
                        </div>
                        <div className="card-footer">
                            View All Posts
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default AddPost; 