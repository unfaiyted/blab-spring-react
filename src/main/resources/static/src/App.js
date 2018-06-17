import './App.css';
import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ChannelList from './component/ChannelList'

const API = 'http://localhost:8080/api';


export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {channels: []};
    }


    componentDidMount() {
        fetch(API + '/channels')
            .then(response => response.json())
            .then(data =>
                  this.setState({channels: data._embedded.channels}));
    }


    render() {
        return (
            <ChannelList channels={this.state.channels} />
        )
    }


  // render() {
  //   return (
  //     <div className="App">
  //       <header className="App-header">
  //         <img src={logo} className="App-logo" alt="logo" />
  //         <h1 className="App-title">Welcome to React</h1>
  //       </header>
  //       <p className="App-intro">
  //         To get started, edit <code>src/App.js</code> and save to reload.
  //       </p>
  //     </div>
  //   );
  // }
}
//
// export default App;

ReactDOM.render(
    <App />,
    document.getElementById('root')
)