import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {mount} from 'enzyme';

it('renders without crashing', () => {
  const div = document.createElement('div');
  let app = mount(<App />);
  ReactDOM.unmountComponentAtNode(div);
});
