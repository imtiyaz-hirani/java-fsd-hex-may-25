import axios from "axios";
import { useEffect, useState } from "react";

function Post() {
    let [postArry, setPostArry] = useState([]);
    useEffect(() => {
        const getPosts = async () => {
            try {
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts');
                //console.log(response) <-- I get the response structure from here... 
                setPostArry(response.data)
            } catch (err) {
                console.log(err)
            }
        }
        getPosts(); //<-- calling the function to ensure API is called.. 
    }, []);
    return (
        <div className="container-fluid">
            <nav className="navbar navbar-expand-lg navbar-light bg-light mb-4">
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Navbar</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                <a className="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Features</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Pricing</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link disabled" href="#" >Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div><h3 className="display-5">All Posts</h3></div>
            <div className="row">

                {
                    postArry.map((post) => (
                        <div className="col-md-12 mb-2" key={post.id}>
                            <div className="card" >
                                <div className="card-header">
                                    User ID: {post.userId}
                                </div>
                                <div className="card-body">
                                    <h5 className="card-title"> {post.title}</h5>
                                    <p className="card-text">{post.body}</p>
                                    <a href="#" className="btn btn-primary">View Comments</a>
                                </div>
                            </div>
                        </div>
                    ))
                }


            </div>
        </div>
    )
}

export default Post; 