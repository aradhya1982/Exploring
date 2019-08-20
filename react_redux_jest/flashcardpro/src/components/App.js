import React from 'react';
import '../App.css';
import StackList from './StackList';
import {Link} from 'react-router-dom';

function App() {
  return (
    <div>
      <h2>Flash Cards</h2>
      <br></br>
      <StackList/>
      <hr />
      <Link to = 'create-stack'>
        <h4>Create Stack</h4>
      </Link>
    </div>
  );
}

export default App;
