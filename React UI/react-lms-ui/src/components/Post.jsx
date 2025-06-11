import { useEffect, useState } from "react";

function Post() {
    let [postArry, setPostArry] = useState([]);
    useEffect(() => {
        //Call the API : fetch 
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(resp => resp.json())
            .then(data => setPostArry(data))
    }, []);
    return (
        <div className="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div><h3 class="display-5">All Posts</h3></div>
            <div className="row">

                {
                    postArry.map((post) => (
                        <div className="col-md-12 mb-2">
                            <div class="card" key={post.id}>
                                <div class="card-header">
                                    User ID: {post.userId}
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title"> {post.title}</h5>
                                    <p class="card-text">{post.body}</p>
                                    <a href="#" class="btn btn-primary">View Comments</a>
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