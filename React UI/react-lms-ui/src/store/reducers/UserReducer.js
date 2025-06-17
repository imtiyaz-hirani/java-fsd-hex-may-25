//src/store/reducers/UserReducer
const initialState = {
    username: "",
    role: ""
}
const UserReducer = (state = initialState, action) => {

    if (action.type === "SET_USER_DETAILS") {  // This is for login 
        let user = action.payload;
        return {
            ...state,
            username: user.username,
            role: user.role
        }
    }
    if (action.type === "DELETE_USER_DETAILS") {  // This is for logout
        return {
            ...state,
            username: "",
            role: ""
        }
    }
    return state;
}
export default UserReducer;

/**
 * reducer Fn has 2 arguments : state and action 
 * 1. state: to begin with state has username and role as "" 
 *    state.username="" 
 *    state.role="" 
 *    This state will go in redux store. So you store will have an object like this: 
 *    {
        username: "", 
        role : ""
      }
    2. action: When the API will be called from action file or data will be by component, it will dispatch an object that comes and gets saved in this action variable. 
    action = {
        'payload': user,
        'type': 'SET_USER_DETAILS'
    }
 */