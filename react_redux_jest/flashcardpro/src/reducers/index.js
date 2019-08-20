import { SET_STACK, LOAD_STACKS } from "../action";
import {combineReducers} from 'redux';

function stack (state = {}, action) {
    switch (action.type) {
        case SET_STACK: 
            return action.stack; 
        default:
            return state;
    }
}

function stacks (state = [], action) {
    switch (action.type) {
        case LOAD_STACKS: 
            return action.stacks; 
        default:
            return state;
    }
}

export default combineReducers({stack: stack, stacks: stacks});