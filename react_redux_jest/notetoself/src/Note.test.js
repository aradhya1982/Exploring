import React from 'react';
import {mount} from 'enzyme';
import Note from './Note';
import { isMainThread } from 'worker_threads';

const props = {note: {text:'Hi there'}};

describe ('note', () => {
    let note = mount(<Note {...props}/>);

    it('check the presense of text', () => {
        expect(note.find('p').text()).toEqual(props.note.text);
        // expect(note.find('p').text()).toEqual(props.note.text);
    })



})