// I vl configure store here
// src/store/store.js

import { configureStore } from "@reduxjs/toolkit"
import UserReducer from "./reducers/UserReducer";
import CourseReducer from "./reducers/CourseReducer";

// Register all your reducers
const store = configureStore({
    reducer: {
        user: UserReducer, // come back here later after creating reducer 
        courses: CourseReducer
    }
})

export default store; 