import React, {Component} from 'react';
import {Link} from 'react-router-dom';
// import {connect} from 'react-redux';
// import {Link} from 'react-router-dom';
// import Card from './Card';

class StackForm extends Component {
    render() {
        return  <div>
                    <Link to = '/' className = "link-home"> <h4>Home </h4> </Link>
                    <h4> Create Stack</h4>
                </div>;
    }
}

export default  StackForm;