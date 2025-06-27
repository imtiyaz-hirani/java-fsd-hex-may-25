import axios from "axios";
import { useEffect, useState } from "react";

function Courses() {
    const [courses, setCourses] = useState([])
    const [page, setPage] = useState(0);
    const [size, setSize] = useState(3);

    useEffect(() => {
        axios.get(`http://localhost:8080/api/course/all?page=${page}&size=${size}`)
            .then(resp => setCourses(resp.data))
            .catch(err => console.log(err))
    }, [page])
    return (
        <>
            <h1> All Courses with Pagination</h1>
            <div className="container">

                <div className="row">
                    <div className="col-lg-12">
                        <nav aria-label="Page navigation example">
                            <ul className="pagination justify-content-end">
                                <li className="page-item ">
                                    <button className="page-link" onClick={() => {
                                        setPage(page - 1)
                                        console.log(page)
                                    }}>Previous</button>
                                </li>
                                <li className="page-item"><a className="page-link" href="#">1</a></li>
                                <li className="page-item"><a className="page-link" href="#">2</a></li>
                                <li className="page-item"><a className="page-link" href="#">3</a></li>
                                <li className="page-item">
                                    <button className="page-link" onClick={() => {
                                        setPage(page + 1)
                                        console.log(page)
                                    }}>Next</button>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    {
                        courses.map((c, index) => (
                            <div className="col-sm-4" key={index}>
                                <div className="card" style={{ 'width': ' 25rem' }}>
                                    <img className="card-img-top" src={`images/${c.imageUrl}`} alt="Card image cap" />
                                    <div className="card-body">
                                        <h5 className="card-title">{c.title}</h5>
                                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                        <a href="#" className="btn btn-primary">Go somewhere</a>
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