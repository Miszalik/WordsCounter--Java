import React, { useState, useEffect } from "react";

import UserService from "../services/user.service";

const Home = () => {
    const [content, setContent] = useState("");

    useEffect(() => {
        UserService.getPublicContent().then(
            (response) => {
                setContent(response.data);
            },
            (error) => {
                const _content =
                    (error.response && error.response.data) ||
                    error.message ||
                    error.toString();

                setContent(_content);
            }
        );
    }, []);

    console.log(content);

    return (
        <div className="container">
            <header className="jumbotron">
                <h2>Zagramy w grę?</h2>
                <p>
                   Comming soon...
                </p>
            </header>
        </div>
    );
};

export default Home;