import React, {Component} from 'react';
import SearchBox from './searchBox'

class AppHeader extends Component {

    constructor() {
        super();
        this.state = {
            searchField: ''
        }
    }

    onSearchChange =(event) => {
        this.setState({searchField: event.target.value});
        console.log(event.target.value)
        const filteredRobots = this.state.robots.filter(robot =>{
            return robot.name.toLowerCase().includes(this.state.searchField.toLowerCase()
            )
        });
        console.log(filteredRobots)
    };

    render() {
        return (
            <div className='tc bg-lightest-blue'>
                <h1>RoboFriends</h1>
                <SearchBox searchChange={this.onSearchChange}/>
            </div>
        );
    }
}

export default AppHeader