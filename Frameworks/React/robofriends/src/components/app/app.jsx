import React, {Fragment, Component} from 'react';
//import Header from './header';
import AppCardList from "./cardList";
import {robots} from "../../assets/robots";
import SearchBox from "./header/searchBox";

class App extends Component {
    constructor() {
        super();
        this.state = {
            robots: robots,
            searchField: ''
        }
    }

    onSearchChange =(event) => {
        this.setState({searchField: event.target.value});
    };

    render() {
        const filteredRobots = this.state.robots.filter(robot =>{
            return robot.name.toLowerCase().includes(this.state.searchField.toLowerCase()
            )
        });

        return (
            <Fragment>
                {/*<Header/>*/}
                <div className='tc'>
                    <h1>RoboFriends</h1>
                    <SearchBox searchChange={this.onSearchChange}/>
                    <AppCardList robots={filteredRobots}/>
                </div>
            </Fragment>
        );
    }
}

export default App;
