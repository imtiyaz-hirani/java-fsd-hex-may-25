import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import AuthorDashboard from "./components/author/AuthorDashboard";
import Courses from "./components/author/Courses";
import Enrollments from "./components/author/Enrollments";
import Profile from "./components/author/Profile";
import Stats from "./components/author/Stats";
import LearnerDashboard from "./components/learner/LearnerDashboard";
import CourseDetails from "./components/author/CourseDetails";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />}></Route>
        <Route path="/author" element={<AuthorDashboard />}>
          <Route index element={<Stats />} />
          <Route path="courses" element={<Courses />} />
          <Route path="enrollments" element={<Enrollments />} />
          <Route path="profile" element={<Profile />} />
          <Route path="course-details/:cid" element={<CourseDetails />} />
        </Route>
        <Route path="/learner" element={<LearnerDashboard />}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App;

/**
 * private int count; //0
 * getter and setter 
 * 
 * let [count,setCount]
 * 
 * ()=>{}
 * if u change the value of state variable, I will re-render it. 
 */