import { useParams } from "react-router-dom";

function CourseDetails() {

    const params = useParams();
    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-lg-12">
                    <nav aria-label="breadcrumb">
                        <ol className="breadcrumb">
                            <li className="breadcrumb-item"><a href="#">Author Dashboard</a></li>
                            <li className="breadcrumb-item"><a href="#">Courses</a></li>
                            <li className="breadcrumb-item active" aria-current="page">Cuourse Details</li>
                        </ol>
                    </nav>
                </div>
            </div>
            <div className="col=lg-12 ">
                <h3>Core Java - Enterprise Development : {params.cid}</h3>
                <div className="card mt-2">
                    <div className="card-body">
                        Display some basic info about the course here.
                        <br />
                        Like a short description, final outcome,
                        <br /> Teaching technique <br /> Pre requites and Learner mindset
                    </div>
                </div>
            </div>
            <div className="col-lg-12 mt-4" >
                <div>
                    <span style={{ padding: '10px' }}> <button className="btn btn-primary" data-toggle="collapse" href="#module" aria-expanded="false" aria-controls="collapseExample">
                        Modules
                    </button>
                    </span>
                    &nbsp;&nbsp;
                    <span style={{ padding: '10px' }}>
                        <button className="btn btn-info" data-toggle="collapse" data-target="#video" aria-expanded="false" aria-controls="collapseExample">
                            Videos
                        </button></span>
                    <span style={{ padding: '10px' }}>  <button className="btn btn-secondary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                        Author Profile
                    </button></span>
                    <span style={{ padding: '10px' }}> <button className="btn btn-warning" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                        Reviews
                    </button></span>




                </div>
                <div className="collapse" id="module">
                    <div className="card card-body">
                        Display list of all modules
                    </div>
                </div>

                <div className="collapse" id="video">
                    <div className="card card-body">
                        Display a list of All videos along with modules
                        <p>Object Orientation</p>
                        <li> Classes and Objects </li>
                        <li>Heap and Stack</li>
                    </div>
                </div>

                <div className="collapse" id="author">
                    <div className="card card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                    </div>
                </div>

                <div className="collapse" id="review">
                    <div className="card card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                    </div>
                </div>
            </div>


        </div >
    )
}

export default CourseDetails;