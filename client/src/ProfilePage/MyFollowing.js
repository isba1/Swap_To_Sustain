import React, { useState, useEffect } from "react";
import axios from "axios";
import "./profile.css";

const MyFollowing = ({place, myID}) =>{
    const [modal, setModal] = useState(false);
    const [data, setData] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await axios.get(`http://localhost:8080/profile/following?userID=${myID}`);
                const user = response.data;
                setData(user);
            } catch (error) {
                console.error("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };

        if (modal) {
            fetchData();
        }
    }, [modal, myID]);

    const toggleModal = () => {
        if (modal){
            setData(null);
        }
        setModal(!modal);
    }

    if (modal){
        document.body.classList.add('active-modal')
      }else{
        document.body.classList.remove('active-modal')
    }

    return(<div>
        <button className='showfollowbutton' onClick={toggleModal}>{place}</button>

        {modal &&(
        <div className="showfollowmodal">
          <div className="showfollowoverlay" onClick={toggleModal}></div>
          <div className="showfollowmodal-content">
            <h2>Following:</h2>
            <button className="showfollowclose-modal" onClick={toggleModal}>X</button>
            {loading ? (
                            <p>Loading...</p>
                        ) : (
                            <div>
                                {data && data.length > 0 ? (
                                    <ul>
                                        {data.map(item => (
                                            <li key={item.id}>{/* Render your item content here */}</li>
                                        ))}
                                    </ul>
                                ) : (
                                    <p>You aren't following anyone! Get connected with other users!</p>
                                )}
                            </div>
                        )}
            </div> 
        </div>
      )}
    </div>
    )
}

export default MyFollowing;