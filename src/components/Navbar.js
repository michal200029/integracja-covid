import axios from 'axios';
import React, { Component } from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap'
export default class Navigation extends Component {

    constructor(props) {
        super(props);
        this.state = {
            token: localStorage.getItem("token"),
            branches: [],
        }
    }

    componentDidMount() {
        const headers = { 
            'Authorization': "Bearer " + this.state.token
        };
        axios.get(`http://localhost:8080/branches`,{headers})
            .then(res => {
                this.setState({ branches: res.data })
            })
    }

    render() {
        if (this.state.token !== null) {
            return (
                <div>
                    <div className="row">
                        <div className="col-md-12">
                            <Navbar bg="dark" variant="dark" expand="lg" sticky="top">
                                <Navbar.Collapse id="basic-navbar-nav">
                                    {this.state.branches.map((val) => {
                                            return (
                                                <Nav key={val.name} className="m-auto">
                                                    <NavDropdown title={val.name} id="basic-nav-dropdown">
                                                        {val.subbranches.map((value,i) => {
                                                            if(i===val.subbranches.length-1)
                                                            {
                                                            return (<>
                                                                <NavDropdown.Item href={"/"+value}>{value}</NavDropdown.Item></>)
                                                            }
                                                            else
                                                            {
                                                                return (<>
                                                                    <NavDropdown.Item href={"/"+value}>{value}</NavDropdown.Item>
                                                                    <NavDropdown.Divider /></>)
                                                                }
                                                        })}
                                                    </NavDropdown>
                                                </Nav>)
                                    })}
                                </Navbar.Collapse>
                            </Navbar>
                            <br />
                        </div>
                    </div>
                </div>
            )
        }
    }
}