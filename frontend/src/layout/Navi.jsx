import React, {useState} from 'react'
import { Navbar, Nav, Container, NavItem, Button } from 'react-bootstrap';
import SignIn from './SignIn';
import SignOut from './SignOut';

export default function Navi() {

    const [isAuthenticated, setIsAuthenticated] = useState(false);

    return (
        <div>
            <Navbar bg="dark" variant="dark" >
                <Container >
                    <Navbar.Brand href="#home" >
                        <img
                            alt="Logo"
                            src="/shoebasketlogo-removebg-preview.png"
                            width="50"
                            height="40"
                        />
                        <Navbar.Text>
                            <span style={{ fontFamily: "fantasy", fontSize: "1.2em", verticalAlign: "bottom"}}>ShoeBasket</span>
                        </Navbar.Text>
                    </Navbar.Brand>
                    {isAuthenticated?<SignIn/>:<SignOut/>}
                    
                </Container>
            </Navbar>
        </div>
    )
}
