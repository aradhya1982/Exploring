import React, {Component} from 'react';

class Card extends Component {
    constructor() {
        super();
        this.state = {
            showAnswer: false
        }
    }
    render() {
        const {prompt, answer } = this.props.card;
        return <div className='card' onClick = {() => { this.setState({showAnswer: true});}}>
            <div className = 'card-prompt'><h4>{prompt}</h4></div>
            <div className = 'card-answer'><h4 className = {this.state.showAnswer ? 'showAnswer' : 'hideAnswer'} > {answer}</h4></div>
        </div>
    }
}

export default Card;