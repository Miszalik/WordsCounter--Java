import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "./style/App.css";

import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./components/Home";
import Profile from "./components/Profile";
import BoardUser from "./components/BoardUser";
import NavigationBar from "./components/NavigationBar";

const App = () => {

  return (
      <Router>
        <div>
          <NavigationBar  />

          <div className="container mt-3">
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/home" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/register" element={<Register />} />
              <Route path="/profile" element={<Profile />} />
              <Route path="/user" element={<BoardUser />} />
              {/*<Route path="/mod" element={<BoardModerator />} />*/}
              {/*<Route path="/admin" element={<BoardAdmin />} />*/}
            </Routes>
          </div>
        </div>
      </Router>
  );
};

export default App;