import React from 'react'
import { DropdownButton, Dropdown, Container } from 'react-bootstrap'
import CartSummary from './CartSummary'

export default function SignIn() {
    return (
        <div>
            <Container style={{display: "flex"}}>
                <CartSummary />
                
                <DropdownButton variant="success" id="dropdown-basic-button" title="Efe Uzun"  style={{marginLeft : "15px"}}>
                    <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                    <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                    <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                    <Dropdown.Divider />
                    <Dropdown.Item href="#/action-4">Separated link</Dropdown.Item>
                </DropdownButton>
            </Container>
        </div>
    )
}
