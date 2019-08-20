import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Switch, Route} from 'react-router-dom';
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import rootReducers from './reducers';
import './index.css';
import App from './components/App';
import * as serviceWorker from './serviceWorker';
import Stack from './components/Stack';
import {setStack}  from './action/index';
import StackForm from './components/StackForm';

const store = createStore(rootReducers);
store.subscribe(() => {console.log('state', store.getState())});
store.dispatch(setStack({id: 0, title: 'example', cards: []}));


ReactDOM.render(
    <Provider store = {store}>
        <BrowserRouter>
            <Switch>
                <Route exact path = "/" component = {App}/>
                <Route exact path = "/stack" component = {Stack}/>
                <Route exact path = "/create-stack" component = {StackForm}/>
            </Switch>
        </BrowserRouter>
    </Provider>
    ,document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
