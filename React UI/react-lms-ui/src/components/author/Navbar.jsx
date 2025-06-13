import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Navbar() {
    const [name,] = useState(localStorage.getItem('name'));
    const navigate = useNavigate();
    const logout = () => {
        localStorage.clear();
        navigate("/")
    }
    return (
        <div >
            <nav className="navbar navbar-light bg-light justify-content-between"  >
                <div className="navbar-brand "> </div>
                <div className="form-inline mt-2 mb-4 ">
                    Welcome {name}
                    &nbsp;&nbsp;&nbsp;
                    <button class="btn btn-outline-success" onClick={() => logout()}>Logout</button>

                </div>

            </nav>

        </div>
    )
}

export default Navbar; 