//src/store/reducers/CourseReducer
const initialState = {
    courses: []
}
const CourseReducer = (state = initialState, action) => {
    console.log('In reducer... ')
    console.log(action.payload)
    if (action.type === "FETCH_ALL_COURSES") {
        return {
            ...state,
            courses: action.payload
        }
    }
    return state;
}
export default CourseReducer;