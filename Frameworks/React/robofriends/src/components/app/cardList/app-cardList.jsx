import React from 'react';
import AppCardListCard from "./app-cardList-card";

const AppCardList = ({robots}) => {
    return (
        <div className="tc">
            {
                robots.map((user, index) => {
                    return <AppCardListCard
                        key={index}
                        id={robots[index].id}
                        name={robots[index].name}
                        email={robots[index].email}
                    />
                })
            }
        </div>
    )
};

export default AppCardList