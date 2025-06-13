import axios from "axios";
import { useEffect, useState } from "react";

function Courses() {
    const [courses, setCourses] = useState([]);

    useEffect(() => {
        const getAllCourses = async () => {
            try {
                let response = await axios.get('http://localhost:8080/api/course/by-author',
                    { headers: { 'Authorization': 'Bearer ' + localStorage.getItem('token') } }
                )
                setCourses(response.data)
            }
            catch (err) {
                console.log(err)
            }
        }
        getAllCourses();
    }, [])
    return (
        <>
            <h1>Courses</h1>
            <div className="container">
                <div className="row">
                    {
                        courses.map((c, index) => (
                            <div className="col-md-4 mb-4" key={index}>
                                <div class="card" >
                                    <img class="card-img-top" style={{ padding: '50px', height: '21rem' }} src={`../images/${c.imageUrl}`} alt={c.title} />
                                    <div class="card-body">
                                        <h5 class="card-title">{c.title}</h5>
                                        <p class="card-text">Credits : {c.credits}Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                        <p class="card-text">Author: {c.author.name}</p>
                                        <a href="#" class="btn btn-primary">View Details</a>
                                    </div>
                                </div>
                            </div>
                        ))
                    }

                </div>
            </div>
        </>
    )
}

export default Courses;