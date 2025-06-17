import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { setUserDetails } from "../../store/actions/UserAction";

function Navbar() {
    const [user,] = useState(useSelector(state => state.user));
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const logout = () => {
        let u = {
            "username": "",
            "role": ""
        }
        setUserDetails(dispatch)(u);
        localStorage.clear();
        navigate("/")
    }
    return (
        <div >
            <nav className="navbar navbar-light bg-light justify-content-between"  >
                <div className="navbar-brand "> </div>
                <div className="form-inline mt-2 mb-4 ">
                    Welcome {user.username} - {user.role}
                    &nbsp;&nbsp;&nbsp;
                    <button class="btn btn-outline-success" onClick={() => logout()}>Logout</button>

                </div>

            </nav>

        </div>
    )
}

export default Navbar; 