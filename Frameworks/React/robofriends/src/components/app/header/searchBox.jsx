import React from 'react';

const SearchBox = ({searchChange}) => {
    return (
        <div className='pa'>
            <input
                className='pa3 ba b--green bg-light-blue'
                type="search"
                placeholder='search robots'
                onChange={searchChange}
            />
        </div>
    );
};

export default SearchBox