import { useParams } from "react-router-dom";

function CourseDetails() {

    const params = useParams();
    return (
        <div>
            <h3>CourseDetails Dashboard : {params.cid}</h3>
        </div>
    )
}

export default CourseDetails;